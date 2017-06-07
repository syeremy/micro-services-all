#FROM openjdk:8-jre
FROM openjdk:8u131-jre
VOLUME /tmp
ADD app.jar /app.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
ADD start.sh /start.sh
RUN chmod +x /start.sh
RUN sh -c 'touch /app.jar'

ENTRYPOINT ["/start.sh"]