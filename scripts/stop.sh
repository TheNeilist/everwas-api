if [ -a /tmp/everwas-api-pid ]
        then
                PID=$(cat /tmp/everwas-api-pid)
		echo "Killing process $PID"
                kill -9 $PID
                rm -f /tmp/everwas-api-pid
	else
		echo "pid file does not exist"
fi
