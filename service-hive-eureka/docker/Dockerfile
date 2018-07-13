FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER devcloud@huaweicloud.com
VOLUME /tmp
ARG APP_FILE=app.jar
ENV ACTIVE_PROFILE=peer1
ADD certs/ ${JAVA_HOME}/jre/lib/security/
ADD ${APP_FILE} app.jar
RUN ln -s ${JAVA_HOME}/jre/lib/security/servicehive.jks /servicehive.jks && touch /app.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","app.jar","--spring.profiles.active=${ACTIVE_PROFILE}"]