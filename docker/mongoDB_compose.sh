#!/bin/bash
LAUGH='\U0001f602';
echo -e "mongo compose is starting... ${LAUGH}"
docker-compose -f mongoDB.yml config &&\
docker-compose -f mongoDB.yml up && docker-compose -f mongoDB.yml down --rmi local
