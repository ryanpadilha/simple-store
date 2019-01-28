#!/bin/bash
#
# Stop Java Application on AWS environment

echo "stop simple store application..."

PID=$(cat /var/run/simple-store.pid)
kill -9 $PID