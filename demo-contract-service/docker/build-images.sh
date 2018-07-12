#!/bin/bash
IMAGE_VERSION=1.0.0
APP_FILE=demo-contract-service-1.0.0.jar

docker rmi service-hive/demo-contract-service:$IMAGE_VERSION
docker build --build-arg APP_FILE=${APP_FILE} -t service-hive/demo-contract-service:$IMAGE_VERSION .
  