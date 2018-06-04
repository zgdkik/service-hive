#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/demo-hr-client-with-feign-hystrix:$IMAGE_VERSION
docker build -t service-hive/demo-hr-client-with-feign-hystrix:$IMAGE_VERSION .
