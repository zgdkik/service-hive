FROM java
VOLUME /tmp
ADD api-gateway.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8443
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","app.jar"]