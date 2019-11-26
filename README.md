# k8s-ms-demo

## Server details
sj1010010251187.corp.adobe.com
dev/dev@123

## Installing minikube
https://www.radishlogic.com/kubernetes/running-minikube-in-aws-ec2-ubuntu/
minikube dashboard
minikube addons enable ingress

## Installing jenkins
https://www.blazemeter.com/blog/how-to-setup-scalable-jenkins-on-top-of-a-kubernetes-cluster/
docker build -t wolfdragon19/jenkins-image:latest .

docker run -d -v /var/run/docker.sock:/var/run/docker.sock -v /usr/bin/docker:/usr/bin/docker:ro -v /lib64/libdevmapper.so.1.02:/usr/lib/x86_64-linux-gnu/libdevmapper.so.1.02 -v /lib64/libudev.so.0:/usr/lib/x86_64-linux-gnu/libudev.so.0 -p 8080:8080 --name jenkins -u root --privileged=true -t -i wolfdragon19/jenkins-image:latest

manual install - 
pipeline
docker

Jenkins URL
10.10.251.187:31326


## kubectl commands
kubectl cluster-info
kubectl get pods --all-namespaces -o wide
kubectl get services --namespace=jenkins
kubectl get ingress --namespace=jenkins

kubectl describe service profanity-service-load-balancer
kubectl logs profanity-service-deployment-7d774c9f8c
kubectl exec -it jenkins-576756f95f-lkmjg -- nslookup kubernetes




docker run --privileged --name yourDockerContainerNameHere 

docker run --privileged -t -i wolfdragon19/jenkins-image:latest -p 8080:8080 -d docker:dind

docker run --name jenkins -p 8080:8080 -v /var/jenkins_home




