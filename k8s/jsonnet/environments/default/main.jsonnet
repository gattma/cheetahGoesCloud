local bk = import "github.com/gattma/tanka-bk/ocp.libsonnet";
local k = import 'github.com/grafana/jsonnet-libs/ksonnet-util/kausal.libsonnet';
{
  local deploy = k.apps.v1.deployment,
  local container = k.core.v1.container,
  local port = k.core.v1.containerPort,
  local service = k.core.v1.service,
  local ingress = k.networking.v1.ingress,
  local rule = k.networking.v1.ingressRule,
  local path = k.networking.v1.httpIngressPath,

  _config:: {
    demo_microservice: {
      port: 8080,
      name: 'demo-microservice',
      image: 'ghcr.io/gattma/cheetah-goes-cloud:step1-3d7728e',
      replicas: 1,
      host: 'demo-service-jsonnet.localdev.me',
    },
  },

  demo_microservice: {
    deployment: deploy.new(name=$._config.demo_microservice.name, replicas=$._config.demo_microservice.replicas, containers=[
      container.new($._config.demo_microservice.name, $._config.demo_microservice.image)
      + container.withPorts(
        [port.new('http', $._config.demo_microservice.port)]
      ),
    ]),

    service: k.util.serviceFor(self.deployment)
    + service.mixin.spec.withType('ClusterIP'),

    local paths = [
      path.withPath("/")
        + path.mixin.withPathType("Prefix")
        + path.mixin.backend.service.withName(self.service.metadata.name)
        + path.mixin.backend.service.port.withNumber($._config.demo_microservice.port)
    ],
    local rules = [
      rule.withHost($._config.demo_microservice.host)
        + rule.mixin.http.withPaths(paths)
    ],
    ingress: ingress.new(self.service.metadata.name)
      + ingress.mixin.spec.withIngressClassName("nginx")
      + ingress.mixin.spec.withRules(rules)
  },
}