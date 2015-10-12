#!/bin/sh
export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"

export MAVEN_EXTRA="-Dmaven.repo.local=./m2"
OPTIONS="-Dtycho.localArtifacts=ignore $MAVEN_EXTRA $@"

read -p "\nBuild Core(y/n)? " -n 1 -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/core/pom.xml $OPTIONS || exit 101
fi

export REPLY=""

read -p "\nBuild Runtime 3x(y/n)? " -n 1 -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/runtime/pom.xml -P runtime3x $OPTIONS || exit 102
fi

export REPLY=""

read -p "\nBuild Runtime 4x(y/n)? " -n 1 -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/runtime/pom.xml -P runtime4x $OPTIONS || exit 103
fi

export REPLY=""

read -p "\nBuild IDE and modules(y/n)? " -n 1 -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/ide/pom.xml $OPTIONS || exit 104
fi

export REPLY=""

read -p "\nBuild Product(y/n)? " -n 1 -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/rcptt/pom.xml $OPTIONS || exit 105
fi
