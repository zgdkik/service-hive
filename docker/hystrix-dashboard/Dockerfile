FROM java
VOLUME /tmp
ADD hystrix-dashboard.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8771
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]