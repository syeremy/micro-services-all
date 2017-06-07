#!/usr/bin/env bash

# se construye la aplicación
gradle clean build -x test

cd ms_dia18

# se levantan los contenedores configurados
# con -d el docker se va al segundo plano
docker-compose up --build

#docker-compose up --build