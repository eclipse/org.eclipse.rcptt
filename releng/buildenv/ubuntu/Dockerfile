FROM consol/ubuntu-xfce-vnc:latest

# Switch to root user to install additional software
USER 0

## Install a java 8, a webkit and a javafx
RUN apt-get -y update \
 && apt-get install -y \
    openjdk-8-jdk \
    libwebkit2gtk-4.0 \
    openjfx

## Install a maven
ARG MAVEN_VERSION=3.6.1
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries
ARG MAVEN_HOME=/usr/share/maven

RUN wget -O /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && mkdir ${MAVEN_HOME} \
  && tar -xzf /tmp/apache-maven.tar.gz -C ${MAVEN_HOME} --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME ${MAVEN_HOME}

## switch back to default user
USER 1000
