#!/bin/bash
#
# Start Java Application on AWS environment

if [ -z $1 ]; then
  ENV="dev";
else
  ENV=$1
fi

APPAWSPATH="/var/peixeurbano/apps/simple-store"

echo "starting simple-store application..."

java -Xms64m -Xmx128m -Dlogging.config=$APPAWSPATH/config/logback-spring.xml -Dspring.config.location=$APPAWSPATH/config/application-$ENV.properties -jar $APPAWSPATH/lib/simple-store.jar &
echo $! > /var/run/simple-store.pid
echo "simple-store started."

$SHELL