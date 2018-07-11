#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn -q -B clean deploy --settings="cd/mvnsettings.xml" -DskipTests
fi