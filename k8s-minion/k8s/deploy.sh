kubectl delete -f k8s-minion-configmap.yaml
kubectl delete -f k8s-minion-deployment.yaml
kubectl delete -f k8s-minion-service.yaml
kubectl delete -f k8s-minion-ingress.yaml

kubectl apply -f k8s-minion-configmap.yaml
kubectl apply -f k8s-minion-deployment.yaml
kubectl apply -f k8s-minion-service.yaml
kubectl apply -f k8s-minion-ingress.yaml

