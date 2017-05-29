#!/usr/bin/env bash

docker run -d -p 9200:9200 -p 9300:9300 --rm elasticsearch:2.4.4-alpine
