#!/usr/bin/env bash

#This conditional statement is done for the following reason: when deploying staging get the gcp image from staging for uat and prod, get the image from production
if [ "$PROJECT" = "jackdaw-staging-platform" ] ; then
        export IMAGE_SOURCE="jackdaw-staging-platform"
    else
        export IMAGE_SOURCE="jackdaw-production-platform"
fi

envsubst < deployment.yml.template > deployment.yml

echo 'GCP image source:' ${IMAGE_SOURCE}
echo 'Project:' ${PROJECT}
gcloud config set project ${PROJECT}
gcloud container clusters get-credentials ${CLUSTER} --zone europe-west1-c
kubectl cluster-info
kubectl apply -f deployment.yml
kubectl apply -f service.yml
