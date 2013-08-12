# Spring MVC Template Application
*   This application can be used as a starting point for any Spring MVC application.
*   Uses Spring **Java Configuration** in place of XML configuration.

## Git Branches
A description of the branches in this repository:

*   **basic** - bare bones app containing a web service layer and MVC controller.  The absolute smallest app possible.
*   **standard**
    - Spring property files,
    - Spring AspectJ Aspect Oriented Programming (AOP)
    - Log4J/SLF4J
    - TestNG support using test suite XML configuration.
    - Inherits features from the *basic* branch
*   **spring-data-remote-db**
    - Spring Data
    - Connects to a remote MySQL host/database
    - c3p0 pooled database connections
    - Uses a multiple user, weight tracking application as an example.
*   **mybatis**
    - MyBatis ORM Framework
    - HSQLDB embedded in-memory database
    - Inherits features from the *standard* branch
*   **mybatis-remote-db**
    - Connects to a remote MySQL host/database
    - c3p0 pooled database connections
    - Inherites features from the *mybatis* branch
*   **security** (in progress)

### Additional Add Ons
*   **resume-pdf** - retrieves my [online CV](http://www.orangemako.com/wiki/index.php/Curriculum_Vitae) and generates a resume in PDF format.
    - Flying Saucer (CSS formatting)
    - IText (PDF Generation)

## Instructions
1.  Prerequisites: Maven 3, Java 1.6
2.  Clone this repo
3.  Build: <pre><code>mvn clean install</code></pre>
4.  Start Jetty webserver: <pre><code>mvn jetty:run</code></pre>
5.  Jetty server will be listening on port 8081
