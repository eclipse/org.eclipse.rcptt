set MAVEN_OPTS="-Xmx512m"
set PWD=%CD:\=/%

set TARGETS=clean verify

call mvn clean verify -f clean-pom.xml || exit 102

call mvn %TARGETS% -f releng/core/pom.xml ^
    -DheliosRepository=http://updates.xored.com/helios ^
    -DindigoRepository=http://updates.xored.com/indigo ^
    -DkeplerRepository=http://updates.xored.com/kepler ^
    || exit 103

call mvn %TARGETS% -f releng/runtime/pom.xml -P runtime3x ^
    -DheliosRepository=http://updates.xored.com/helios ^
    -DindigoRepository=http://updates.xored.com/indigo ^
    -DkeplerRepository=http://updates.xored.com/kepler ^
    -DcoreRepository=file:%PWD%/repository/core/target/repository ^
    || exit 104

call mvn %TARGETS% -f releng/runtime/pom.xml -P runtime4x ^
    -DheliosRepository=http://updates.xored.com/helios ^
    -DindigoRepository=http://updates.xored.com/indigo ^
    -DkeplerRepository=http://updates.xored.com/kepler ^
    -DcoreRepository=file:%PWD%/repository/core/target/repository ^
    || exit 105

call mvn %TARGETS% -f releng/ide/pom.xml ^
    -DheliosRepository=http://updates.xored.com/helios ^
    -DindigoRepository=http://updates.xored.com/indigo ^
    -DkeplerRepository=http://updates.xored.com/kepler ^
    -DcoreRepository=file:%PWD%/repository/core/target/repository ^
    -De3xRepository=file:%PWD%/repository/e3x/target/repository ^
    -De4xRepository=file:%PWD%/repository/e4x/target/repository ^
    || exit 106

