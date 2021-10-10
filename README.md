# RedBridge Academy Intro to FaaS on Kubernetes

## Prerequisities

The demos use RabbitMQ and MariaDB as middleware, install MariaDB using Helm as following:

```shell
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install mysql \
  --set nameOverride=mysql,auth.rootPassword=pass,auth.database=database,secondary.replicaCount=0 \
  -n middleware bitnami/mysql

```
