#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/eureka-server1:$IMAGE_VERSION
docker build -f Dockerfile-eureka1 -t service-hive/eureka-server1:$IMAGE_VERSION .

docker rmi service-hive/eureka-server2:$IMAGE_VERSION
docker build -f Dockerfile-eureka1 -t service-hive/eureka-server2:$IMAGE_VERSION .