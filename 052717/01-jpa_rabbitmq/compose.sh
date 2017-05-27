#!/usr/bin/env bash

# se construye la aplicación
./gradlew clean build -x test

cd build/libs

# se levantan los contenedores configurados
docker-compose up --build

docker-compose stop

cd ../..
