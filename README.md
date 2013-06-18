# Spring MVC Template Application
*   This application can be used as a starting point for any Spring MVC application.
*   Uses Spring __Java Configuration__ in place of XML configuration.

## Git Branches
A description of the branches in this repository:

*   __basic__ - bare bones app containing a web service layer and MVC controller.  The absolute smallest app possible.
*   __standard__ - contains Spring properties, Log4J, SLF4J, Maven-Surefire, and TestNG support. (in progress)
*   __mybatis__ - adds mybatis support on top of the __standard__ branch. (in progress)
*   __security__ - adds Spring Security to the __mybatis__ branch. (in progress)

### Additional Add Ons
*   __resume-pdf__ - retrieves my online CV and generates a resume in PDF format.


## Instructions
1.  Prerequisites: Maven 3, Java 1.6
2.  Clone this repo
3.  Build: <pre><code>mvn clean install</code></pre>
4.  Start Jetty webserver: <pre><code>mvn jetty:run</code></pre>
5.  Jetty server will be listening on port 8080