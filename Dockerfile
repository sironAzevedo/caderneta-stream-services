FROM openjdk:11
VOLUME /tmp

ADD ./target/caderneta-stream-services-0.0.1-SNAPSHOT.jar caderneta-stream-services.jar
ADD ./docker-entrypoint.sh /

RUN ["chmod", "+x", "/docker-entrypoint.sh"]
ENTRYPOINT ["/docker-entrypoint.sh"]