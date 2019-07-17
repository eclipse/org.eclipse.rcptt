FROM consol/centos-xfce-vnc:latest

# Switch to root user to install additional software
USER 0

## Install a java 8 and a javafx
RUN yum install -y java-1.8.0-openjdk-devel \
    && yum clean all

## Install a maven
ENV MAVEN_VER="3.6.0"
RUN wget http://www-eu.apache.org/dist/maven/maven-3/${MAVEN_VER}/binaries/apache-maven-${MAVEN_VER}-bin.tar.gz \
 && tar xvf apache-maven-${MAVEN_VER}-bin.tar.gz \
 && rm apache-maven-${MAVEN_VER}-bin.tar.gz \
 && mv apache-maven-${MAVEN_VER} /opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=${PATH}:${MAVEN_HOME}/bin

## switch back to default user
USER 1000
