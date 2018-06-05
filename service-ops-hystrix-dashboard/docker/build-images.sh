#!/bin/bash
IMAGE_VERSION=1.0.0
APP_FILE=hystrix-dashboard-1.0.0-RELEASE.jar

docker rmi service-hive/hystrix-dashboard:$IMAGE_VERSION
docker build --build-arg APP_FILE=${APP_FILE} -t service-hive/hystrix-dashboard:$IMAGE_VERSION .
  