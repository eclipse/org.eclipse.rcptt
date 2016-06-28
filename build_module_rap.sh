#!/bin/sh
export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"

OPTIONS="-Dtycho.localArtifacts=ignore $@"

mvn clean verify -f releng/rap/pom.xml -P core $OPTIONS || exit 110
mvn clean verify -f releng/rap/pom.xml -P ide $OPTIONS || exit 111
