#!/bin/bash

echo Halting RABBIT MQ  

docker stop some-rabbit 
docker rm some-rabbit 
