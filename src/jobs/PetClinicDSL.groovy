mavenJob('PetClinic-DSL') {
    description 'Build job for Jenkins Pet Clinic'
    preBuildSteps {
        shell('''
      echo '
      FROM openjdk:8-jdk-alpine
      RUN addgroup -S spring && adduser -S spring -G spring
      USER spring:spring
      ARG JAR_FILE=target/*.jar
      COPY ${JAR_FILE} petclinic.jar
      ENTRYPOINT ["java","-jar","/petclinic.jar"]' > Dockerfile
      '''
        )
    }
    scm {
        git {
            remote {
                url 'https://github.com/spring-projects/spring-petclinic'
            }
            branch 'Master'
        }
    }
    postBuildSteps('SUCCESS') {
        shell("docker build -t petclinic . ")
        shell("mvn deploy -DaltDeploymentRepository=snapshots::default::http://localhost:8081/artifactory/libs-snapshot")
    }
}