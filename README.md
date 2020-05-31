# Pet Clinic

Pet clinic is an app based on Spring that you can find here  
https://github.com/spring-projects/spring-petclinic  

This project contains Jenkins DSL to compile, run test and package the project on a docker container.

## Installation
Jenkins: ``` java -jar jenkins.war  ```
Configure on Gradle, Git and Maven on Jenkins  
Install job-dsl.hpi as a plugin on Jenkins

  
## Configuration
Create a job and paste Groovy code from PetClinicDSL.groovy and save it and Run it Process Job as DSL

## Docker
Create image  
```  docker build -t petclinic . ``` 
Run container  
```  docker run -p 8090:8080 petclinic ```  

## Jcenter
Change on settings.xml for Maven adding repository Jcenter  
Instructions from https://bintray.com/bintray/jcenter

## Artifactory
Instructions from https://www.jfrog.com/confluence/display/JFROG/Installing+Artifactory
oss version on Mac

## Jenkins integration with Artifactory
https://www.jfrog.com/confluence/display/JFROG/Configuring+Jenkins+Artifactory+Plug-in
