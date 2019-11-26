pipeline {
   agent any
   
   environment{
		REGISTRY_LINK = 'https://hub.docker.com/wolfdragon19'
		DOCKER_IMAGE = 'wolfdragon19/k8s-minion'
		DOCKER_USER = 'wolfdragon19'
		DOCKER_PASSWORD = 'wolfdragon19@1234'
		
	}

   stages {

		stage('projectInstall') {
		
		steps {
		
			checkout([
			$class: 'GitSCM', branches: [[name: '*/dev']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, parentCredentials: false, recursiveSubmodules: true, reference: '', trackingSubmodules: false]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GitHubId', url: 'https://github.com/wolfdragon19/k8s-ms-demo.git']]])
		
			sh '''
				cd k8s-minion
				mvn clean -U install
			'''
		}
		
		}
		

		stage('dockerBuild') {
		
		steps {
		
			sh '''
				cd k8s-minion
				docker build -t ${DOCKER_IMAGE}:latest .
				docker login -u "${DOCKER_USER}" -p "${DOCKER_PASSWORD}"
				docker push "${DOCKER_IMAGE}":latest
				'''
			}
		
		}
		


		stage(rollingUpdates){
		
		steps {
			
			sh '''
				 cd k8s-minion/k8s && ./deploy.sh
				 sleep 30 
				 kubectl get pods
				 kubectl get services
				 kubectl get ingress
			 '''
			 
			}
		
		}
			 
	}	
}