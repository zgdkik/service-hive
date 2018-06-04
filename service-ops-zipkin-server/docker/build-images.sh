#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/zipkin-server:$IMAGE_VERSION
docker build -t service-hive/zipkin-server:$IMAGE_VERSION .
  