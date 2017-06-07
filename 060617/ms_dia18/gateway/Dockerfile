#FROM openjdk:8-jre
FROM openjdk:8u131-jre
VOLUME /tmp
ADD app.jar /app.jar
ADD start.sh /start.sh
ADD wait-for-it.sh /wait-for-it.sh
RUN sh -c 'touch /app.jar'

ENTRYPOINT ["/wait-for-it.sh","registry:8761", "--", "/start.sh"]