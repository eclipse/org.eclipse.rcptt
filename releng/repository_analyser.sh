#!/bin/bash

set -e

URL=$1
shift
DIR=/tmp/rcptt/reports

mkdir -p  "$DIR"
pushd "$DIR"
rm -r "$DIR/"* || true

${ECLIPSE_INSTALLER:="/Applications/Eclipse Installer.app/Contents/MacOS/eclipse-inst"} \
 -application org.eclipse.oomph.p2.core.RepositoryIntegrityAnalyzer \
 -consoleLog \
 -noSplash \
 -o "$DIR/output" \
 -s "Vasili Gulevich" \
 -v \
 -t "$DIR/tests" \
 -p "$DIR/page" \
 "$URL" \
 -vmargs \
   -Dfile.encoding=UTF-8 \
   -Dorg.eclipse.emf.ecore.plugin.EcorePlugin.doNotLoadResourcesPlugin=true \
   -Xmx8g