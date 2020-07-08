MVC is an acronym that stands for Model-View-Controller, and it's a common software pattern for user interface design. Traditionally, it divides the roles of components in an app into three layers:

*the **Model**, which is responsible for maintaining the state of an application,
*the **View**, which is responsible for displaying the UI to the user,
*and the **Controller**, which is responsible for processing user actions (sent from the View) to update the Model, and for forwarding those updates back to the View

MVC is an abstract pattern, though, and every library implements it differently. Spring MVC is built around the browser as a platform, and it organizes these roles like this:

**HTML templates** are the views - each one represents a specific screen or screen component that the user is shown.
**Spring beans** are the controllers - specifically, Spring MVC gives an @Controller annotation that we can use to register our beans as controllers. Think of Spring bean controllers as specialized application components that can define methods to handle specific user requests. Those methods are responsible for choosing the HTML template that is generated in response, as well as for populating the Model object for that template.

**Model** objects are the models - every controller method can take an optional Model argument, and by reading and changing the data inside of it, the controller can read user-submitted data and populate the template with the changes. Think of the Model class a simple data-transfer object: something that can store various bits of data with keys to look that data up, and that can be passed between the browser, the template engine, and the controller to facilitate the transfer of data between the user and the application.

