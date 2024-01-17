REM set MAVEN_OPTS=-Xms512M -Xmx1500M -XX:MaxPermSize=256m
set MAVEN_OPTS=-Xms512M -Xmx1500M
set PWD=%CD:\=/%

set TARGETS=clean verify

set OPTIONS=-Dtycho.localArtifacts=ignore

call mvn clean verify %OPTIONS% %* -f clean-pom.xml  || exit 102

call mvn %TARGETS% %OPTIONS% %* -f releng/mirroring/pom.xml || goto :EOF

call mvn %TARGETS% %OPTIONS% %* -f releng/core/pom.xml || goto :EOF

call mvn %TARGETS% %OPTIONS% %* -f releng/runtime/pom.xml -P runtime4x || goto :EOF

call mvn %TARGETS% %OPTIONS% %* -f releng/ide/pom.xml || goto :EOF

call mvn %TARGETS% %OPTIONS% %* -f releng/rap/pom.xml -P core || goto :EOF

call mvn %TARGETS% %OPTIONS% %* -f releng/rap/pom.xml -P ide || goto :EOF

call mvn %TARGETS% %OPTIONS% %* -f releng/runner/pom.xml || goto :EOF
