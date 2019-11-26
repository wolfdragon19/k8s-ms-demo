# k8s-ms-demo

## Server details
sj1010010251187.corp.adobe.com
dev/dev@123

## Installing minikube
https://www.radishlogic.com/kubernetes/running-minikube-in-aws-ec2-ubuntu/
minikube dashboard

## Installing jenkins
https://www.blazemeter.com/blog/how-to-setup-scalable-jenkins-on-top-of-a-kubernetes-cluster/
docker build -t wolfdragon19/jenkins-image:1.0 .


## kubectl commands
kubectl cluster-info
kubectl get pods --all-namespaces -o wide
kubectl get services --namespace=jenkins
kubectl get ingress --namespace=jenkins

kubectl describe service profanity-service-load-balancer
kubectl logs profanity-service-deployment-7d774c9f8c
kubectl exec -it profanity-service-deployment-7d774c9f8c-6p64q -- nslookup kubernetes





http://10.10.251.187:30489/api/v1/namespaces/kubernetes-dashboard/services/http:kubernetes-dashboard:/proxy/

10.10.251.187:30886

https://10.10.251.187:8443/api/v1/namespaces/kubernetes-dashboard/services/kubernetes-dashboard:/proxy/