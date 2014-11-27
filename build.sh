#!/bin/sh
export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"

OPTIONS="$@"

mvn clean verify -f releng/core/pom.xml $OPTIONS || exit 101
mvn clean verify -f releng/runtime/pom.xml -P runtime3x $OPTIONS || exit 102
mvn clean verify -f releng/runtime/pom.xml -P runtime4x $OPTIONS || exit 103
mvn clean verify -f releng/ide/pom.xml $OPTIONS || exit 104

