#!/usr/bin/env bash

if [ -a /tmp/everwas-api-pid ]
        then
                EVERWAS_API_PID=$(cat /tmp/everwas-api-pid)
		echo "Killing process $EVERWAS_API_PID"
                kill -9 $EVERWAS_API_PID
                rm -f /tmp/everwas-api-pid
	else
		echo "pid file does not exist"
fi
