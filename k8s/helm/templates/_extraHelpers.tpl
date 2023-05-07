{{- define "demo_microservice.logical.name" -}}
{{- default .Release.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{- define "demo_microservice.technical.name" -}}
{{- printf "%s-%s" .Release.Name .Chart.Name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{- define "demo_microservice.service.name" -}}
{{- default .Release.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}


{{- define "demo_microservice.ingress.name" -}}
{{- default .Release.Name .Values.nameOverride | trunc 54 | trimSuffix "-" -}}
{{- end -}}

{{- define "demo_microservice.ingress.hostname" -}}
{{- if .Values.ingress.hostname -}}
{{ .Values.ingress.hostname }}
{{- else if .Values.ingress.basename -}}
{{ printf "%s.%s" .Release.Name .Values.ingress.basename }}
{{- else -}}
{{- default .Release.Name .Values.nameOverride | trunc 54 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}