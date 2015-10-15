#!/bin/sh
export MAVEN_OPTS="-Xms512m -Xmx756m -XX:MaxPermSize=256m"

export MAVEN_EXTRA="-Dmaven.repo.local=./m2"
OPTIONS="-Dtycho.localArtifacts=ignore $MAVEN_EXTRA $@"

echo ""
read -p "Build Core(y/n)? " -e -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/core/pom.xml $OPTIONS
fi

export REPLY=""

echo ""
read -p "Build Runtime 3x(y/n)? " -e -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/runtime/pom.xml -P runtime3x $OPTIONS
fi

export REPLY=""

echo ""
read -p "Build Runtime 4x(y/n)? " -e -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/runtime/pom.xml -P runtime4x $OPTIONS
fi

export REPLY=""

echo ""
read -p "Build IDE and modules(y/n)? " -e -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/ide/pom.xml $OPTIONS
fi

export REPLY=""

echo ""
read -p "Build Product(y/n)? " -e -r
if [[ $REPLY =~ ^[Yy]$ ]]
then
mvn clean install -f releng/rcptt/pom.xml $OPTIONS
fi
