FROM openjdk:8u131-jre

ADD dia7-0.0.1-SNAPSHOT.jar /app.jar
ADD wait-for-it.sh /wait-for-it.sh
ADD start.sh /start.sh

ENTRYPOINT ["/wait-for-it.sh","postgres:5432", "--", "/start.sh"]