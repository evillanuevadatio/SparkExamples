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


# Download Zookeeper

RUN mkdir -p /opt/zookeeper
ADD http://www-eu.apache.org/dist/zookeeper/stable/zookeeper-3.4.10.tar.gz /opt/zookeeper/
RUN cd /opt/zookeeper; tar -xzf zookeeper-3.4.10.tar.gz 


ENV ZOOKEEPER_HOME /opt/zookeeper
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk

ENV PATH ${PATH}:${JAVA_HOME}/bin
ENV PATH ${PATH}:${JAVA_HOME}/jre/bin
ENV PATH ${PATH}:${ZOOKEEPER_HOME}/bin

# Expose client port (2188/tcp), peer connection port (2888/tcp), leader election port (3888/tcp)
EXPOSE 2181 2888 3888



