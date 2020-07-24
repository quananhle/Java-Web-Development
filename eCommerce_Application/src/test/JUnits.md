## Introduction to JUnits

We'll now go through a hands-on example that would get you some experience with JUnits. To follow along, you can download the starter code that the Instructor uses from this GitHub repository.

### 1. Background

JUnit is a unit-testing "framework" to write repeatable tests in Java. To use this framework, you would need to perform the following steps:

    Download the .jar file from its official website
    Add the downloaded .jar file to your Test classpath in IDE
    Add the dependency to the pom.xml file in your IDE. POM is the abbreviation for "Project Object Model". The pom.xml file contains information about the project and configuration details used by Maven to build the project. A dependency can be added to the pom.xml file as follows:
    
```xml
<dependency>
<groupId>junit</groupId>
<artifactId>junit</artifactId>
<version>4.13</version>
<scope>test</scope>
</dependency>
```

#### Annotation

JUnit uses annotation @ before the definition of classes and methods that designate a test. Few frequently used annotations for methods are:

    @Test - Declares a method as a test method
    @Before - Runs before each test. It prepares the necessary state of the system (e.g., read input data, initialize the other classes)
    @BeforeClass - Runs once before any of the test methods in the class. In other words, it runs exactly once before the entire set of tests in the class.. @After - Executed after each test. It releases the resources used for the test (e.g., delete temporary data, restore defaults) There are many more annotations that we may learn in the project code.

#### Assert statement

JUnit provides static methods in ```Assert``` class, to test certain conditions. These assertion methods start with the word assert. These methods allow us to specify the error message, the expected output, and the actual output. The assertion method checks the value returned by a test to the expected value. It throws an ```AssertionException``` if the comparison fails. Some useful assertion methods are:

* ```assertTrue([message,] boolean condition)``` - Checks that the boolean condition is true.
* ```assertFalse([message,] boolean condition)``` - Checks that the boolean condition is false.
* ```assertEquals([message,] expected, actual)``` - Tests that two values are the same.
* ```assertEquals([message,] expected, actual, tolerance)``` - Tests whether float or double values are identical. The tolerance is the number of decimals, which must be the same.
* ```assertNull([message,] object)``` - Checks that the object is null.

#### Failed Tests

It is essential to check our methods using the corresponding test methods. If a test fails, console output would tell what went wrong so that we may make the necessary correction.

```pom.xml``` file contains information about the project and configuration details used by Maven to build the project. 

#### Advanced Features of JUnit

Using ```@Before```, ```@BeforeClass```, ```@After```, ```@AfterClass``` and ```@Ignore```

![Alt text](JUnit_Annotations.png?raw=true "Types of Testing")

#### Code Coverage

Code coverage is a measure used to find the degree to which the source code of a program is executed when the tests for that program are run. In other words, if running the tests results in 80% of the program's code being executed, then we would say that we have achieved 80% code coverage.

