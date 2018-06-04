#!/bin/bash
IMAGE_VERSION=1.0.1

docker rmi service-hive/admin-server:$IMAGE_VERSION
docker build -t service-hive/admin-server:$IMAGE_VERSION .
  