#!/bin/bash
curl -k --header "Content-Type: application/json" \
	--request POST \
	--data "@login_json"\
	-v https://localhost:8080/api/login;