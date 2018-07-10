#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_46d5efca5ac9_key -iv $encrypted_46d5efca5ac9_iv -in codesigning.asc.enc -out codesigning.asc -d
    gpg2 --fast-import cd/signingkey.asc
fi