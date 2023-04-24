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

  demo_microservice: {
    deployment: deploy.new(name='demo-microservice', replicas=1, containers=[
      container.new('demo-microservice', 'ghcr.io/gepaplexx/demo-microservice:latest')
      + container.withPorts(
        [port.new('http', 8080)]
      ),
    ]),

    service: k.util.serviceFor(self.deployment)
    + service.mixin.spec.withType('ClusterIP'),

    route: bk.ocp.route.new("demo-service", "demo-microservice")
  },
}