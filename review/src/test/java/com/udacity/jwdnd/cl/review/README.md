There are a few things we have to do to set up a test file for a Spring Boot app. The main thing is that we have to make 
sure our server is running before the tests start - we do that here with 
```@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)```. This tells JUnit to run the application 
before any tests are executed, with a random port number instead of the default ```8080```. This is useful because it means we 
can have multiple copies of the app running at the same time, which is common in development and testing environments.

Of course, we need to know what the random port ends up being so that we can use Selenium's ```driver.get()``` method to 
navigate the browser to our app. Spring makes this easy for us with the ```@LocalServerPort``` annotation. Spring will inject 
the current port into a field annotated with this like the example above.

As we mentioned in the video, we set up the Selenium driver in an ```@BeforeAll``` method, and we quit it in an ```@AfterAll``` 
method. However, the magic really starts with the ```@BeforeEach``` method - here, we navigate to the ```/chat``` URL and initialize 
a new ```CounterPage``` object. This means that every test will start from this URL and with a fresh CounterPage object - 
which makes test development extremely simple.

As you can see from the rest of the tests, we simply use the helper methods we defined on CounterPage to perform all 
actions in and retrieve all data from the browser. This makes our test code highly legible, and each test starts to look 
a lot like a user story - for example, for increment, we could read the test as

As a user, I can increment the count in order to see the displayed count increase by one

And the code doesn't look far off from that statement! That's a truly powerful abstraction. 

As you can see, the abstraction of Page Objects makes this test very readable and simple to follow. 
First, we use the driver to navigate to the signup page. We initialize a ```SignupPage``` object and call the ```signup``` method 
with some user account details - in my Page Objects, every top-level user action is represented by a single, simple method like this.

For the sake of simplicity, we're assuming that each form submission is a success, so we then navigate to the login page 
and create another Page Object for that screen. We log in with the same credentials we registered, and since our 
Spring Security configuration is set up to automatically forward us to the ```/chat``` URL on successful login, we don't have 
to navigate with ```driver.get``` again.

We then instantiate a ```ChatPage``` object, use its ```sendChatMessage``` method to send a new message to the chat, 
and the retrieve the sent message data from the browser. Notice that we're using the same ```ChatMessage``` class we're 
using throughout the application - don't be afraid to reuse POJOs like this when it fits the situation!

Finally we check that the username and message text in the ```ChatMessage``` matches what we submitted, and we're done!