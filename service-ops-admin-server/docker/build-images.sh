#!/bin/bash
IMAGE_VERSION=1.0.0
APP_FILE=admin-server-1.0.0.jar

docker rmi service-hive/admin-server:$IMAGE_VERSION
docker build --build-arg APP_FILE=${APP_FILE} -t service-hive/admin-server:$IMAGE_VERSION .
  