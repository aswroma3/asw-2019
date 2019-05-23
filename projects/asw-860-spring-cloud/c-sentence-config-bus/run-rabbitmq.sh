#!/bin/bash

echo Starting RABBIT MQ in a Docker Container 

docker run -d --hostname localhost --name some-rabbit --publish 5672:5672 rabbitmq:3
