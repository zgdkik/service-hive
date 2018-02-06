FROM java
VOLUME /tmp
ADD zipkin-server.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8774
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]