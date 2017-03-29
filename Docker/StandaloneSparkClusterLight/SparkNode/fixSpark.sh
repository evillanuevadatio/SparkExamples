#!/bin/sh

sed -i  's/nohup --/nohup /g' /opt/spark-hadoop-2.7/sbin/spark-daemon.sh
