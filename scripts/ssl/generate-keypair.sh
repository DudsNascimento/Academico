#!/bin/bash
keytool -genkeypair -alias academico -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore academico.p12 -validity 365;
