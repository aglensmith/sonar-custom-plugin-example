#!/usr/bin/env bash

# build
mvn clean package

# copy jar to extensions/plugins
cp -f target/sonar-example-plugin-10.0.0.jar ~/sonar/qube/10.6.0.92116/extensions/plugins/
# mv jar to ~/sonar/qube dirs
