#!/bin/sh
export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"

OPTIONS="-Dtycho.localArtifacts=ignore $@"

mvn clean verify -f releng/mirroring/pom.xml $OPTIONS || exit 100 
