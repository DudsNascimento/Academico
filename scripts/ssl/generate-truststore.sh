#!/bin/bash
openssl req -new -x509 -keyout ca-key -out ca-cert -days 365
keytool -keystore academico.truststore.p12 -storetype PKCS12 -alias CARoot -import -file ca-cert
keytool -keystore academico.p12 -alias academico -certreq -file cert-file
openssl x509 -req -CA ca-cert -CAkey ca-key -in cert-file -out cert-signed -days 365 -CAcreateserial -passin pass:122333
keytool -keystore academico.p12 -alias CARoot -import -file ca-cert
keytool -keystore academico.p12 -alias academico -import -file cert-signed