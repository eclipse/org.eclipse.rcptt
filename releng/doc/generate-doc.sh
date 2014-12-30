#! /bin/bash

SCRIPT_LOC=$( cd "$( dirname "${BASH_SOURCE[0]}" )" > /dev/null && pwd )
CLASSIFIER=${CLASSIFIER:-linux/gtk/x86_64}
TARGET=$SCRIPT_LOC/target


if [ -d "$TARGET" ]; then
    rm -r "$TARGET"
fi

ECLIPSE_LOC=${ECLIPSE_LOC:-$SCRIPT_LOC/../../repository/full/target/products/org.eclipse.rcptt.platform.product/$CLASSIFIER/rcptt}
LAUNCHER=$(find $ECLIPSE_LOC/plugins -name "org.eclipse.equinox.launcher_*")

echo "SCRIPT_LOC = $SCRIPT_LOC"
echo "PWD = $PWD"
echo "CLASSIFIER = $CLASSIFIER"
echo "ECLIPSE_LOC = $ECLIPSE_LOC"
echo "TARGET = $TARGET"
echo "LAUNCHER = $LAUNCHER"

JAVA=$JAVA_HOME/bin/java
$JAVA -jar $LAUNCHER \
      -application org.eclipse.rcptt.ecl.doc.generator \
      -output $TARGET/doc/ecl/index.html
