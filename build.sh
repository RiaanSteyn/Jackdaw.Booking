#!/usr/bin/env bash
mvn clean package

if [ $? -ne 0 ]; then
  exit $?
fi

docker build -t gcr.io/$PROJECT/email:${BUILD_NUMBER} -t gcr.io/$PROJECT/bookings:latest .
#
gcloud docker -- push gcr.io/$PROJECT/bookings:${BUILD_NUMBER}
gcloud docker -- push gcr.io/$PROJECT/bookings:latest

