FROM java
VOLUME /tmp
ADD certs/ ${JAVA_HOME}/jre/lib/security/
ADD hystrix-dashboard.jar app.jar
RUN ln -s ${JAVA_HOME}/jre/lib/security/servicehive.jks /servicehive.jks && bash -c 'touch /app.jar' 
EXPOSE 8771
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","app.jar"]