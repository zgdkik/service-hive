FROM java
VOLUME /tmp
ADD demo-hr-client-with-ribbon-hystrix.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]