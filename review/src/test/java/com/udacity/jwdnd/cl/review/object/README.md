**Create Page Objects for the HTML templates involved in the tests.** 

The goal of a Page Object is to simplify and abstract away common Selenium tasks, like finding elements on the page.

In order to test our registration/login/message submission flow, we should implement separate Page Objects for the 
```signup.html```, ```login.html```, and ```chat.html``` templates. 

Previously, we did this with ```driver.findElement``` and ```driver.findElements```, but in a Page Object, 
we can take a much more Spring-like approach by declaring annotated fields representing the elements we want to capture on the page. These element selectors will be automatically processed by Selenium, but we have to kick that process off ourselves - which we do in the next section:

***Initializing Elements in the Constructor***
```java
    public CounterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
```

In this example, we declare a WebDriver as the only constructor argument, and we call ```PageFactory.initElements()``` 
with the driver and the ```this``` keyword as arguments. This is shorthand to tell Selenium to use the given driver to 
initialize the ```@FindBy```-annotated fields in the class. In principle, we could do this somewhere else, but as we'll 
see, initializing a Page Object in its constructor like this is pretty flexible and clean.

By adding this constructor, whenever we create a new ```CounterPage``` object, Selenium will automatically find 
and capture the elements we declared, reducing a bunch of similar calls to ```driver.findElement``` to a single new 
```CounterPage()``` instantiation. Once we have those elements, we can move on to the next section:

**Creating Helper Methods**
```java
    public int getDisplayedCount() {
        return Integer.parseInt(countDisplay.getText());
    }

    public void incrementCount() {
        incrementButton.click();
    }

    public void resetCount(int value) {
        resetValueField.clear();
        resetValueField.sendKeys(String.valueOf(value));
        resetButton.click();
    }
```

Now that our Page Object has selected elements from the page it represents, we can define helper methods that 
encapsulate common tasks for the page. In this counter example, we need to be able to read the current count from the 
screen, we need to be able to increment the count, and we need to reset the count. Notice that I didn't mention any 
specific elements to describe the functionality of these actions - while we have to be specific in our implementation of 
these methods, as you can see in the code above, the goal of writing these helpers is to separate the action taken on 
the class from the specific element interactions required to fulfill that action. In some ways, this is another instance 
of separation of concerns - by hiding the implementation details in these methods, if the HTML of the page ever changes, 
we don't have to update anything except the code inside this class - the tests that will use this class can just 
continue to call the same methods they did before.