#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/api-gateway:$IMAGE_VERSION
docker build -t service-hive/api-gateway:$IMAGE_VERSION .
  