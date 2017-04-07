#!/bin/sh

ZK_CFG_FILE="/opt/zookeeper/etc/kafka/zookeeper.properties"

echo "==========================="
ls -l /opt/
echo "==========================="
ls -l /opt/zookeeper
echo "==========================="
echo $ZOOKEEPER_HOME
echo "==========================="

kServer.sh start
$ZOOKEEPER_HOME/bin kServer.sh start
