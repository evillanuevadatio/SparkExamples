#!/bin/sh

# Start Master
echo "============= HOSTNAME ================="
echo `hostname`
echo "========================================"

start-master.sh
start-slave.sh spark://`hostname`:7077

# 
while true; do
    sleep 120;
done 

