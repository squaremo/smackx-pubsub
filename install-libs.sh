#!/bin/sh
mvn install:install-file -DgroupId=smack -DartifactId=smack -Dversion=3.1.0 -Dpackaging=jar -Dfile=smack.jar
mvn install:install-file -DgroupId=smack -DartifactId=smackx -Dversion=3.1.0 -Dpackaging=jar -Dfile=smackx.jar
mvn install:install-file -DgroupId=smack -DartifactId=smack-test -Dversion=3.1.0 -Dpackaging=jar -Dfile=smack-test.jar
mvn install:install-file -DgroupId=smack -DartifactId=smack-debug -Dversion=3.1.0 -Dpackaging=jar -Dfile=smackx-debug.jar
