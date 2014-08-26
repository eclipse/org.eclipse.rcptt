export MAVEN_OPTS="-Xmx512m -XX:MaxPermSize=256m"

mvn clean verify -f releng/core/pom.xml \
    -DheliosRepository=http://updates.xored.com/helios \
    -DindigoRepository=http://updates.xored.com/indigo \
    -DkeplerRepository=http://updates.xored.com/kepler

mvn clean verify -f releng/runtime/pom.xml -P runtime3x \
    -DheliosRepository=http://updates.xored.com/helios \
    -DindigoRepository=http://updates.xored.com/indigo \
    -DkeplerRepository=http://updates.xored.com/kepler \
    -DcoreRepository=file:$PWD/repository/core/target/repository

mvn clean verify -f releng/runtime/pom.xml -P runtime4x \
    -DheliosRepository=http://updates.xored.com/helios \
    -DindigoRepository=http://updates.xored.com/indigo \
    -DkeplerRepository=http://updates.xored.com/kepler \
    -DcoreRepository=file:$PWD/repository/core/target/repository

mvn clean verify -f releng/ide/pom.xml \
    -DheliosRepository=http://updates.xored.com/helios \
    -DindigoRepository=http://updates.xored.com/indigo \
    -DkeplerRepository=http://updates.xored.com/kepler \
    -DcoreRepository=file:$PWD/repository/core/target/repository \
    -De3xRepository=file:$PWD/repository/e3x/target/repository \
    -De4xRepository=file:$PWD/repository/e4x/target/repository

