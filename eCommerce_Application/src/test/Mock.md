## Mocks

Sometimes it is impossible or undesirable to directly work with a particular object, such as if that object is unavailable or impractical to work with. But we may still want to test our code to see how it works with that object. In such cases, we can create a mock object (or mock) that simulates the real object in specific, controlled ways—and then test our code using this simulated object. In this section, we'll explore how to create such mocks using a framework called Mockito.

![Alt text](Mocks.png?raw=true "Mocks")

### Mockito

#### Few important methods and annotations provided by Mockito are:

* ```mock()```/```@Mock``` - To create mock object. Here, ```mock()``` is an overloaded static method which accepts ```Class<T> classToMock``` as an argument and correspondingly returns a mock instance.
* ```when()```/```given()``` - To specify the behaviour of mock object. ```when()``` method takes a particular method X as argument and set the expected (mocked) return value as Y. Following are the few examples:

```java
    when(mock.someMethod()).thenReturn(200); 
    //parameterized methods as argument
    when(mock.someMethod(anyString())).thenReturn(200); 
    //throw an exception 
    when(mock.someMethod("some argument")).thenThrow(new RuntimeException());
```
* ```spy()```/ ```@Spy``` - It is used for partial mocking. It means that the real methods are invoked but still can be verified and stubbed.
* There are few more methods and annotations available, such as ```@InjectMocks```, ```verify()```

Note that if a project contains private methods to test, then we can't use Mockito as it does not mock private methods. Mockito assumes that private methods don't exist from the viewpoint of testing.

There are few other mocking frameworks available for Java, such as JMock, EasyMock, and Powermock. It is a matter of choice of the developer based on preferences such as Powermock can even mock private methods. 

