FROM ubuntu:22.04

ARG DEBIAN_FRONTEND=noninteractive

#INSTALL PYTHON
RUN apt-get update \
 && apt-get upgrade -y \
 && apt-get install -y software-properties-common
 
 
RUN add-apt-repository ppa:deadsnakes/ppa \
 && apt-get update \
 &&  apt-get install -y python3.8

#INSTALL JAVA
RUN apt-get update \
 && apt-get install  openjdk-18-jdk -y

RUN apt-get update
RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN apt-get -qq -y install curl
RUN apt-get install -y unzip
RUN apt-get install -y zip
RUN curl -s https://get.sdkman.io | bash
RUN chmod a+x "$HOME/.sdkman/bin/sdkman-init.sh"
RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && sdk install kotlin

RUN update-alternatives --install /usr/bin/python python /usr/bin/python3 2