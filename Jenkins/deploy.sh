kubectl delete -f jenkins-deployment.yaml --namespace=jenkins
kubectl delete -f jenkins-service.yaml --namespace=jenkins

kubectl apply -f jenkins-deployment.yaml --namespace=jenkins
kubectl apply -f jenkins-service.yaml --namespace=jenkins


