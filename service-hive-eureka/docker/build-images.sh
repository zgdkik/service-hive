#!/bin/bash
IMAGE_VERSION=1.0.0
APP_FILE=eureka-server-1.0.0-RELEASE.jar

docker rmi service-hive/eureka-server:$IMAGE_VERSION
docker build --build-arg APP_FILE=${APP_FILE} -f Dockerfile -t service-hive/eureka-server:$IMAGE_VERSION .