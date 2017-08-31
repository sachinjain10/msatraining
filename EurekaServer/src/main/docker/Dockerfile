FROM java8
VOLUME /tmp
ADD /home/msa/.m2/repository/com/example/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.jar /eureka.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/eureka.jar"]
