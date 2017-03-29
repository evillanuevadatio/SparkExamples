FROM alpine:3.5
MAINTAINER Eder Villanueva (chartrix@gmail.com)


# Default to UTF-8 file.encoding
ENV LANG C.UTF-8


ENV JAVA_DISTRIBUTION openjdk
ENV JAVA_VERSION 8

RUN apk add "$JAVA_DISTRIBUTION$JAVA_VERSION" --update 
RUN rm -rf /var/cache/apk/*
RUN ln -s "/usr/lib/jvm/java-1.$JAVA_VERSION-openjdk/bin/javac" /usr/bin/javac

RUN apk add --update bash &&   rm -rf /var/cache/apk/*
RUN apk add --update curl &&   rm -rf /var/cache/apk/*
RUN apk add --update procps &&   rm -rf /var/cache/apk/*
RUN apk add --update sed gawk  &&   rm -rf /var/cache/apk/*

# Download Spark 2.1
RUN mkdir -p /opt/spark
ADD http://d3kbcqa49mib13.cloudfront.net/spark-2.1.0-bin-hadoop2.7.tgz /opt/spark/
RUN cd /opt/spark; tar -xzf spark-2.1.0-bin-hadoop2.7.tgz
RUN ln -s /opt/spark/spark-2.1.0-bin-hadoop2.7 /opt/spark-hadoop-2.7

#Fix spark 
COPY . /
RUN /fixSpark.sh
#RUN sed 's/nohup --/nohup ' /opt/spark-hadoop-2.7/sbin/spark-daemon.sh

ENV SPARK_HOME /opt/spark-hadoop-2.7
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk

ENV PATH ${PATH}:${JAVA_HOME}/bin
ENV PATH ${PATH}:${JAVA_HOME}/jre/bin
ENV PATH ${PATH}:${SPARK_HOME}/bin
ENV PATH ${PATH}:${SPARK_HOME}/sbin

EXPOSE 7077 6066 8080 8081




