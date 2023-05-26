{{/*
Expand the name of the chart.
*/}}
{{- define "cheetah_goes_cloud.name" -}}
{{- default .Chart.Name .Values.nameOverride | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Create a default fully qualified app name.
We truncate at 63 chars because some Kubernetes name fields are limited to this (by the DNS naming spec).
If release name contains chart name it will be used as a full name.
*/}}
{{- define "cheetah_goes_cloud.fullname" -}}
{{- if .Values.fullnameOverride }}
{{- .Values.fullnameOverride | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- $name := default .Chart.Name .Values.nameOverride }}
{{- if contains $name .Release.Name }}
{{- .Release.Name | trunc 63 | trimSuffix "-" }}
{{- else }}
{{- printf "%s-%s" .Release.Name $name | trunc 63 | trimSuffix "-" }}
{{- end }}
{{- end }}
{{- end }}

{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "cheetah_goes_cloud.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{/*
Common labels
*/}}
{{- define "cheetah_goes_cloud.labels" -}}
helm.sh/chart: {{ include "cheetah_goes_cloud.chart" . }}
{{ include "cheetah_goes_cloud.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "cheetah_goes_cloud.selectorLabels" -}}
app.kubernetes.io/name: {{ include "cheetah_goes_cloud.name" . }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}

{{- define "cheetah_goes_cloud.ingress.hostname" -}}
{{- if .Values.ingress.hostname -}}
{{ .Values.ingress.hostname }}
{{- else if .Values.ingress.basename -}}
{{ printf "%s.%s" .Release.Name .Values.ingress.basename }}
{{- else -}}
{{- default .Release.Name .Values.nameOverride | trunc 54 | trimSuffix "-" -}}
{{- end -}}
{{- end -}}