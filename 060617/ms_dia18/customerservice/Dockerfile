#FROM openjdk:8-jre
FROM openjdk:8u131-jre
VOLUME /tmp
ADD app.jar /app.jar
ADD wait-for-it.sh /wait-for-it.sh
ADD start.sh /start.sh
ADD w4r.sh /w4r.sh
RUN sh -c 'touch /app.jar'

ENTRYPOINT ["/wait-for-it.sh","postgres:5432", "--", "/w4r.sh"]