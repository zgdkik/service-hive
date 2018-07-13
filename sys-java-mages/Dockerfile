FROM frolvlad/alpine-glibc:alpine-3.8
MAINTAINER <likuan33@126.com>

ADD jdk.tar.gz /usr/java/

ENV JAVA_HOME /usr/java/jdk
ENV PATH ${PATH}:${JAVA_HOME}/bin
WORKDIR /opt