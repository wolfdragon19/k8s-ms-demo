def getTimeStamp(){
    return sh (script: "date +'%Y%m%d%H%M%S%N' | sed 's/[0-9][0-9][0-9][0-9][0-9][0-9]\$//g'", returnStdout: true);
}
node('dev'){
    
    stage('Init'){
        script{
		
        env.TIMESTAMP = getTimeStamp();
        env.REGISTRY_LINK = 'https://hub.docker.com/wolfdragon19'
		env.DOCKER_IMAGE_URL = 'wolfdragon19/k8s-minion'
        
        }
    }

	stage('projectInstall') {
	git credentialsId: '0ac45d84-ce44-4746-9ec7-10df4df7b699', url:'https://github.com/wolfdragon19/k8s-ms-demo.git', branch: 'dev'
		dir('k8s-minion') {
		  sh '''mvn clean -U install'''
		}
	}

	stage('dockerBuild') {
	dir('k8s-minion') {

		sh '''
				docker build -t ${DOCKER_IMAGE_URL}:latest .
				docker tag "${DOCKER_IMAGE_URL}":latest "${DOCKER_IMAGE_URL}":"${TIMESTAMP}"
				docker push ${DOCKER_IMAGE_URL}":"${TIMESTAMP}"
				echo "${TIMESTAMP}"
		'''
	}}


	stage(rollingUpdates){
		dir('k8s-minion') {
				 sh '''
					 cd k8s &&./deploy.sh
					 sleep 30 
					 kubectl get pods
					 kubectl get ing 
					 kubectl get ing
				 '''
			}
		}

}
