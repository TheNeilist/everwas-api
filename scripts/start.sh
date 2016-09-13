nohup java -jar ../target/everwas-api-0.0.1.jar server ../everwas-api.yml > log.txt 2> errors.txt < /dev/null &
PID=$!
echo $PID > /tmp/everwas-api-pid
