#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/hystrix-dashboard:$IMAGE_VERSION
docker build -t service-hive/hystrix-dashboard:$IMAGE_VERSION .
  