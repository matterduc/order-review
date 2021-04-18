
lap
-----

This is a multi-module Spring Boot Angular Maven starter app with good defaults.
The frontend Angular app is built using [angular-cli](https://cli.angular.io/). The project packages Angular application code as a [WebJar](https://www.webjars.org/).

This project provides productive setup for building Spring Boot Angular applications. The application is divided into two Maven modules:

1. `back`: This contains Java code of the application.
2. `front`: This contains source code for the Angular based frontend.

This project uses following versions:

1. Spring Boot v2.0.3
2. Angular v6.0.5
3. Core UI 2.0.2 


- Java 1.8
- Eclipse Neon (or a version that supports Java 8)
- Visual Studio Code
- Tomcat v8.5
- Maven 3.2.5
- Node v8.11.3


You can build the package as a single artifact by running the `mvn clean install`.

The application will be accessible at `http://localhost:8080`.


This starter comes bundled with the following features:

1. Multi module Maven project: A multi module project to modularize backend and frontend code separately.
2. Frontend packaged as a WebJar.
3. CORS enabled: A global configuration is added to enable CORS so that frontend can work seamlessly with backend during development.
4. Maven release plugin
5. Spring Security with JWT
6. Form validation using annotations
7. Single Sign-On
8. Intelligent query language using [specifications](http://www.baeldung.com/rest-api-search-language-spring-data-specifications) and request parameters.
9. Boilerplate code generation using Lombok and Selma Mapper



Double-click lombok.jar (`$YOUR_REPO\projectlombok\lombok`). This starts the eclipse installer which will find eclipse, and offers to install lombok into these eclipse installations. The same tool can also uninstall lombok.


Folow these steps for the **backend module**:

- Project Properties → Java Compiler → Annotation Processing

- check "Enable project specific settings" and "Enable annotation processing"

- Project Properties → Java Compiler → Annotation Processing → Factory Path

- "Add JARs..." for each jar :

  - `repo\fr\xebia\extras\selma-processor\1.0\selma-processor-1.0.jar`
  - `repo\fr\xebia\extras\selma\1.0\selma-1.0.jar`
  - `repo\com\squareup\javawriter\2.5.0\javawriter-2.5.0.jar`

"Clean and Build All" projects just to be sure


In Development, you might want to activate the Dev profil : `-Dspring.profiles.active=dev` to enable CORS.

There are multiple ways to run the backend. For development, you can use your favorite IDE and run the
`com.example.app.Application` class. As soon as your code compiles, Spring Boot DevTools will reload the code.

You can also run the application using Maven.

```bash
$  mvn spring-boot:run
```


Make sure to install Node on your development machine.

Once the Node.JS is installed, you can start the frontend using the `npm start` or `ng serve` command.

The url of the App will be : http://localhost:4200


Both the front-end and back-end modules support hot reloading.


As it's a multi-module maven project, go to the root of the project and run `mvn clean install`."# orders" 
