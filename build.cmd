set MAVEN_OPTS="-Xmx512m"
set PWD=%CD:\=/%

set TARGETS=clean verify

set OPTIONS=-Dtycho.localArtifacts=ignore

REM call mvn clean verify %OPTIONS% %* -f clean-pom.xml  || exit 102

call mvn %TARGETS% %OPTIONS% %* -f releng/core/pom.xml ^
    || exit 103

call mvn %TARGETS% %OPTIONS% %* -f releng/runtime/pom.xml -P runtime3x ^
    || exit 104

call mvn %TARGETS% %OPTIONS% %* -f releng/runtime/pom.xml -P runtime4x ^
    || exit 105

call mvn %TARGETS% %OPTIONS% %* -f releng/ide/pom.xml  ^
    || exit 106

