#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/eureka-server1:$IMAGE_VERSION
docker build -f eureka-server1-dockerfile -t service-hive/eureka-server1:$IMAGE_VERSION .

docker rmi service-hive/eureka-server2:$IMAGE_VERSION
docker build -f eureka-server2-dockerfile -t service-hive/eureka-server2:$IMAGE_VERSION .

docker rmi service-hive/admin-server:$IMAGE_VERSION
docker build -f admin-server-dockerfile -t service-hive/admin-server:$IMAGE_VERSION .

docker rmi service-hive/api-gateway:$IMAGE_VERSION
docker build -f api-gateway-dockerfile -t service-hive/api-gateway:$IMAGE_VERSION .

docker rmi service-hive/demo-hr-client-with-feign-hystrix:$IMAGE_VERSION
docker build -f demo-hr-client-with-feign-hystrix-dockerfile -t service-hive/demo-hr-client-with-feign-hystrix:$IMAGE_VERSION .

docker rmi service-hive/demo-hr-client-with-ribbon-hystrix:$IMAGE_VERSION
docker build -f demo-hr-client-with-ribbon-hystrix-dockerfile -t service-hive/demo-hr-client-with-ribbon-hystrix:$IMAGE_VERSION .

docker rmi service-hive/demo-hr-service:$IMAGE_VERSION
docker build -f demo-hr-service-dockerfile -t service-hive/demo-hr-service:$IMAGE_VERSION .

docker rmi service-hive/hystrix-dashboard:$IMAGE_VERSION
docker build -f hystrix-dashboard-dockerfile -t service-hive/hystrix-dashboard:$IMAGE_VERSION .

docker rmi service-hive/zipkin-server:$IMAGE_VERSION
docker build -f zipkin-server-dockerfile -t service-hive/zipkin-server:$IMAGE_VERSION .
  