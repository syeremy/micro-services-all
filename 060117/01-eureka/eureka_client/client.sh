#!/usr/bin/env bash

dir="./build/libs/client$1"

mkdir -p $dir
cp build/libs/eureka_client-0.0.1-SNAPSHOT.jar $dir

cd $dir

appEnv="devclient$1"

echo "Running with $appEnv"

java -jar eureka_client-0.0.1-SNAPSHOT.jar --spring.profiles.active="$appEnv"

cd ../../..
