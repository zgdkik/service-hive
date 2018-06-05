FROM java
MAINTAINER devcloud@huaweicloud.com
VOLUME /tmp
ARG APP_FILE=app.jar
ADD certs/ ${JAVA_HOME}/jre/lib/security/
ADD ${APP_FILE} app.jar
RUN ln -s ${JAVA_HOME}/jre/lib/security/servicehive.jks /servicehive.jks && bash -c 'touch /app.jar' 
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","app.jar"]