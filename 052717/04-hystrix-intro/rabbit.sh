#!/usr/bin/env bash

docker run -d -p 5672:5672 -p 15672:15672 --rm rabbitmq:3.6.9-management-alpine