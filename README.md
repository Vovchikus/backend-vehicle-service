* appspec.yml - this file is used by AWS CodeDeploy when deploying the web
  application to EC2
* buildspec.yml - this file is used by AWS CodeBuild to build the web
  application
* pom.xml - this file is the Maven Project Object Model for the web application
* src/ - this directory contains your Java application source files


Getting Started
---------------

1. Install maven.  See https://maven.apache.org/install.html for details.

2. Install tomcat.  See https://tomcat.apache.org/tomcat-7.0-doc/setup.html for
   details.

3. Build the application.

        $ mvn -f pom.xml compile
        $ mvn -f pom.xml package

4. Copy the built application to the Tomcat webapp directory.  The actual
   location of that directory will vary depending on your platform and
   installation.

        $ cp target/ROOT.war <tomcat webapp directory>

4. Restart your tomcat server

5. Open http://127.0.0.1:8080/ in a web browser to view your application.

What Is This?
------------------

REST Application for a Vehicle Service

http://ec2-34-209-34-16.us-west-2.compute.amazonaws.com/api/vehicles (GET, POST)
.../api/vehicles/marks (GET)

iOS implementation - https://github.com/ProsviryakovVadim/CarRU

Tech
------------------
Java 8, MongoDB
