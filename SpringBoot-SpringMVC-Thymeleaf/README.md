![Alt text](pictures/l0-30-course-outline.jpg?raw=true "Java-Web-Developing-Structure")

* Basics of Java server architecture, dependency management in Java, and how Spring integrates with both.

        Web servers and how early servers were single-function programs that could host files, serve web pages, and expose databases to external connections.
        Java application servers, which provide a pluggable architecture for applications to interface with, granting access to shared resources and multi-threaded request processing.
        Spring framework, a family of libraries that build on the abstractions of the application server to support many third-party integrations to provide easy abstractions for common web development tasks.
        Spring Boot, a convention-over-configuration approach to Spring app development that provides defaults for many Spring configuration options in order to provide a smoother development experience.
        Spring Initializr, the official project generator for Spring Boot, which allows developers to specify an application's metadata and dependencies and receive a fully-configured Spring Boot project, ready for development.

* Core Spring principles. We'll be covering dependency injection, bean configuration, service development, and server-wide configuration.

        Inversion of Control (IoC): A design pattern in which the developer creates independent application components and uses a framework to connect them, rather than writing the integration code themselves 
        Business Logic: Code that relates exclusively to an application's conceptual model and featureset. Contrast with utility code like database access, HTTP request parsing, etc. 
        Persistent Components: Java Objects that Spring maintains over time; they're persistent because they're created and maintained for as long as the application needs them to be. 
        Dependency Injection: A mechanism by which IoC may be implemented. Components are configured with dependencies on other components, which are injected at runtime. Injection is quite literal - a component's dependencies are usually expressed as annotated fields on the component class, and Spring will populate those fields with the dependencies at runtime.
        
    ![Alt text](pictures/InversionOfControl.png?raw=true "Spring-Boot")
        
    ![Alt text](pictures/Spring-IOC.png?raw=true "Spring-IOC")
        
    ![Alt text](pictures/Onion-Architecture.png?raw=true "Onion-Architecture")
    
* ```Spring MVC``` and ```Thymeleaf```, an HTML template engine. ```Spring controllers```, ```Thymeleaf``` template attributes, and connecting the two with the MVC pattern.

    ![Alt text](pictures/SpringMVC-Thymeleaf.png?raw=true "Spring-MVC-Thymeleaf")

* Connecting your Spring app to a database and securing it with Spring Security. We'll cover the basics of ORM and MyBatis, an ORM tool for Java. We'll use the database to store user credentials securely and use them to authenticate users with Spring Security.

    ![Alt text](pictures/DataPersistence-MyBatis.png?raw=true "Data-Persistence")

* Testing and web browser automation with ```Selenium```. We'll cover how to set up and run tests with JUnit, how a web driver works, and how to simulate user actions in the browser with Selenium. We'll also discuss page objects, Selenium's powerful abstraction tool.

    ![Alt text](pictures/Testing-JUnit-Selenium.png?raw=true "Data-Persistence")
   


