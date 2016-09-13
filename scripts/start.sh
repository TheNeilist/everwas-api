nohup java -jar /var/lib/jenkins/workspace/everwas-api/target/everwas-api-0.0.1.jar server /var/lib/jenkins/workspace/everwas-api/everwas-api.yml > log.txt 2> errors.txt < /dev/null &
PID=$!
echo $PID > /tmp/everwas-api-pid
