FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER devcloud@huaweicloud.com
VOLUME /tmp
ADD certs/ ${JAVA_HOME}/jre/lib/security/
ARG APP_FILE=app.jar
ADD ${APP_FILE} app.jar
RUN ln -s ${JAVA_HOME}/jre/lib/security/servicehive.jks /servicehive.jks && touch /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","app.jar"]