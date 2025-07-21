node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/httpdport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/httpdport.git'), string(name: 'PORT_DESCRIPTION', value: 'The Apache HTTP Server is a powerful and flexible HTTP/1.1 compliant web server' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
