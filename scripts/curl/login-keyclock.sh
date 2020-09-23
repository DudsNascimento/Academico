#!/bin/bash
curl --header "Content-Type: application/x-www-form-urlencoded" \
	--request POST \
	--data-urlencode 'grant_type=password' \
	--data-urlencode 'client_id=academico-login' \
	--data-urlencode 'username=user1' \
	--data-urlencode 'password=122333' \
	-v http://localhost:8180/auth/realms/Academico/protocol/openid-connect/token;