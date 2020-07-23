### Java DataSources

#### Data Source vs. DataSource

Sometimes we use these words interchangeable, so just to clarify:

* Data Source: A source of data, such as a database. 
* DataSource: Java utility class that manages connections to physical or logical databases.

![Alt text](JavaDataSourceObjects.png?raw=true "Types of Java DataSource Objects")

#### Spring DataSource Properties

Spring automatically builds a DataSource for us on startup. You can configure all the properties of the datasource by setting values in your application.properties file. Here is a List of Spring Data Properties. Anything beginning with spring.datasource refers to DataSource configuration.

Example application.properties:

```xml
spring.datasource.url=jdbc:mysql://localhost:3306/exampledb
spring.datasource.username=sa
spring.datasource.password=sa1234
```

The url property uses the format: 

```subprotocol : serverName[:port] / databaseName : properties```

We have not specified any properties as part of the URL string in this example, because we are specifying them using additional rows in our properties file.

Note: Depending on your driver version and locale, you may run into issues with Spring Boot retrieving the server timezone from MySQL and deciding that it is invalid. This is because certain time zones, such as ‘PDT’, Pacific Daylight Time, are not recognized by some Java MySQL connectors.

```xml
spring.datasource.url=jdbc:mysql://localhost:3306/exampledb?serverTimezone=UTC
```

#### Creating Initial Database

Before using your application to connect to a database server, you should create a database instance on that server to store your information. Then you should create an admin user for that database. You can use the MySQL Workbench to do this, or any other tool that allows you to execute sql against your database.
```mysql-sql
create user 'sa'@'localhost' identified by 'sa1234'; -- Create the user
grant all on exercise1.* to 'sa'@'localhost'; -- Gives all privileges to that user on new db
```

#### Programmatic DataSource Configuration

##### ```@Bean```

The ```@Bean``` annotation marks methods that should create beans during Spring initialization. Each method will be executed and the returned object will be added as a Bean for Spring to use in dependency injection. These can also be configured by xml. We’re using the @Bean annotation to identify methods that return DataSource instances. Spring will inject these into persistence classes as needed.

#### Programmatic Configuration

DataSources can also be configured programmatically by creating a class annotated with ```@Configuration``` that returns a ```@Bean``` of the desired type. Spring will inject this DataSource whenever a DataSource is requested. This could be useful if you need to retrieve some DataSource properties dynamically.

##### ```@ConfigurationProperties```

You can also combine properties and programmatic configuration by using the @ConfigurationProperties annotation. Spring will attempt to inject any properties found beginning with the provided prefix into the returned @Bean.

```dbn-sql
CREATE SCHEMA `plant` ; -- Create the plant database

CREATE USER 'sa'@'localhost' IDENTIFIED BY 'sa1234'; -- Create the user if you haven’t yet
GRANT ALL ON plant.* TO 'sa'@'localhost'; -- Gives all privileges to the new user on plant
```

```java
@Configuration
public class DataSourceConfig {

   @Bean
   @Primary
   @ConfigurationProperties(prefix="com.udacity.datasource")
   public DataSource getDataSource() {
       DataSourceBuilder dsb = DataSourceBuilder.create();
       dsb.url("jdbc:mysql://localhost:3306/plant");
       return dsb.build();
   }
}
```

#### DataSourceProperties

Different DataSource providers sometimes have different names for their properties. You can use a DataSourceProperties object to manage converting between the standard spring.datasource properties and your desired DataSource type by creating a @Bean that returns a DataSourceProperties object you populate from your properties file.

We will annotate both the DataSourceProperties and DataSource beans with @Primary so that spring knows which beans to use by default of that type.

#### Multiple DataSources

If your data is stored in multiple locations, you can access it by creating multiple DataSource @Beans. You will have to provide beans for an EntityManagerFactory and a TransactionManager as well. To support Spring Data repositories, we also use the @EnableJpaRepositories annotation to reference the specific classes.

Here are the definitions for two different config classes. The first one defines everything we need to load spring.datasource properties into one DataSource for storing our Humanoid Entities. The next one uses the properties from spring.datasource2 to access our Outfit Entities.

##### spring.datasource.initialization-mode values
* Embedded: Default. Initialization performed on embedded databases only.
* Always: Initialization for both embedded and external databases.
* Never: No initialization for either embedded or external databases.

##### spring.jpa.hibernate.ddl-auto

This property allows you to customize Hibernate’s initialization behavior.

* create: Drop all tables for defined Entities, then create them.
* create-drop: Create tables, drop them when application stops.
* update: Attempt to migrate previous version of tables to match current Entities.
* validate: Throw an exception if tables or columns are missing.
* none: Do not initialize tables.

##### show-sql

Spring offers a useful command to print all generated sql commands to the console:

```dbn-sql
spring.jpa.show-sql=true
```

There’s also a hibernate property for formatting the sql output that makes it easier to read:

```dbn-sql
spring.jpa.properties.hibernate.format_sql=true
```

#### Configuring Unit Tests with application.properties

One way to configure the unit test datasource is to simply provide a second application.properties file. You could add the following properties to force H2 for unit tests:

```xml
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:db
spring.datasource.username=sa
spring.datasource.password=sa
```

Remember, the default initialization-mode is embedded, so you do not need to specify this property when using H2 for unit tests. Also recall that the default ddl-auto property for in-memory databases is create-drop, so you also do not need to set that property unless you wish some other behavior.

##### ```@SpringBootTest```

This annotation goes on your unit test class. creates an entire Spring ApplicationContext when running unit tests. It is used if you need to test controller or service classes, or perform integration tests spanning multiple layers.

##### ```@DataJpaTest```

This annotation provides an alternate way to test your data layer without providing an application.properties file. It disables Spring autoconfiguration and automatically uses an in-memory database if available. It only loads Entities and Spring Data JPA repositories, but not your Services or Controllers.

##### TestEntityManager

TestEntityManager is a class provided by Spring Boot that provides useful methods for persisting test data inside persistence unit tests. It is still available in @DataJpaTests despite the rest of the app not being wired up.

##### ```@AutoConfigureTestDatabase```

This annotation can be used with either @SpringBootTest or @DataJpaTest. You can use it to customize Spring’s behavior for replacing the normal datasource. For example, the following annotation could be used in conjunction with @DataJpaTest to indicate that Spring should NOT replace the datasource with an in-memory datasource.

```java
@AutoConfigureTestDatabase(replace=Replace.NONE)
```



