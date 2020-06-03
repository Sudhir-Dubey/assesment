# assessment.

A new sprint boot project for the REST Endpoints of fincovi-assessment. This is now kind of monolith source repository
but in future the end points may be separated out to different repositories.

## Dependencies
### JDK 8
#### Installation on Mac OS
For installing adopt-open-jdk 8 on mac, run the following commands:
```shell script
$ brew tap AdoptOpenJDK/openjdk
$ brew cask install adoptopenjdk8
```

# Build  the project 
### mvn clean -U install -d maven.test.skip=true

# Run the project 
## use the bellow command
### ./target java -jar  assessment-0.0.1-SNAPSHOT.jar

# view the rest end points
### use the bellow url in browser
## http://localhost:8080/swagger-ui.html

#for test case h2 file is used instead of in-memory

# import post man collection
### https://www.getpostman.com/collections/d4ef07e25dbfa35f5d2c
    
