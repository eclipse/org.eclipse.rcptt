#!/bin/bash
. repository/full/target/publisher.properties
mvn clean verify -B -f rcpttTests/pom.xml \
-DrcpttPath=../repository/full/target/products/org.eclipse.rcptt.platform.product-macosx.cocoa.x86_64.zip \
-DexplicitRunner=../runner/product/target/rcptt.runner-${productVersion}-SNAPSHOT.zip || true
test -f rcpttTests/target/results/tests.html