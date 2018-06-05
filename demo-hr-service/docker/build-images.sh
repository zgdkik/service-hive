#!/bin/bash
IMAGE_VERSION=1.0.0
APP_FILE=demo-hr-service-1.0.0-RELEASE.jar

docker rmi service-hive/demo-hr-service:$IMAGE_VERSION
docker build --build-arg APP_FILE=${APP_FILE} -t service-hive/demo-hr-service:$IMAGE_VERSION .
  