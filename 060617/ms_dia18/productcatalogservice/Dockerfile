#FROM openjdk:8-jre
FROM openjdk:8u131-jre
VOLUME /tmp
ADD app.jar /app.jar
ADD wait-for-it.sh /wait-for-it.sh
ADD start.sh /start.sh
RUN sh -c 'touch /app.jar'

ENTRYPOINT ["/wait-for-it.sh","elasticsearch:9200", "--", "/start.sh"]