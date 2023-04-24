{{- define "demo_microservice.logical.name" -}}
{{- default .Release.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{- define "demo_microservice.technical.name" -}}
{{- printf "%s-%s" .Release.Name .Chart.Name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{- define "demo_microservice.service.name" -}}
{{- default .Release.Name .Values.nameOverride | trunc 63 | trimSuffix "-" -}}
{{- end -}}


{{- define "demo_microservice.route.name" -}}
{{- default .Release.Name .Values.nameOverride | trunc 54 | trimSuffix "-" -}}
{{- end -}}

{{- define "demo_microservice.route.hostname" -}}
{{- if .Values.route.hostname -}}
{{ .Values.route.hostname }}
{{- else if .Values.route.basename -}}
{{ printf "%s.%s" .Release.Name .Values.route.basename }}
{{- else -}}
{{- default .Release.Name .Values.nameOverride | trunc 54 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}