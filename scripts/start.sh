#!/usr/bin/env bash

BUILD_ID=pleaseDontKillMeApi
nohup java -jar /var/lib/jenkins/workspace/everwas-api/target/everwas-api-0.0.1.jar server /var/lib/jenkins/workspace/everwas-api/everwas-api.yml > log.txt 2> errors.txt < /dev/null &
EVERWAS_API_PID=$!
echo $EVERWAS_API_PID > /tmp/everwas-api-pid
echo "started everwas-api PID $EVERWAS_API_PID"