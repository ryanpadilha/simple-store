#!/bin/bash
#
# Stop Java Application on AWS environment

echo "stop wplex-garagem application..."

PID=$(cat /var/run/simple-store.pid)
kill -9 $PID