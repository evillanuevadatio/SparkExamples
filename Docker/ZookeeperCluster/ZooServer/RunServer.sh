#!/bin/sh

ZK_CFG_FILE="/opt/zookeeper/etc/kafka/zookeeper.properties"
echo "======================"

${zk_id:=1}
: ${zk_tickTime:=2000}
: ${zk_initLimit:=5}
: ${zk_syncLimit:=2}
: ${zk_clientPort:=2181}
: ${zk_maxClientCnxns:=0}

export zk_dataDir='/var/lib/zookeeper'

export zk_id
export zk_tickTime
export zk_initLimit
export zk_syncLimit
export zk_clientPort
export zk_maxClientCnxns

zkServer.sh start
