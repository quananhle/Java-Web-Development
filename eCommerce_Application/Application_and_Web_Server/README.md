## What is an Application and Web Server?

An application server is a compute system that processes requests and performs actions. In other words, the application 
server generates the dynamic (user-specific) content based on user-request. In our case, external users (across the 
internet) can connect to the eCommerce application server through a web-server that accepts the request for a particular 
"resource" and reverts with the "response". ```IntelliJ IDE``` has a built-in web server that can be used to preview and 
debug your application. This web server is always running and does not require any manual configuration. 

![Alt text](application_web_server.png?raw=true "Application server and web server")

#### What is the Postman client?

    Postman is a client (a tool) that helps to test the RESTful APIs. RESTful APIs use request paths, types, and bodies to perform a specific action, such as creating a user or modifying a cart associated with an existing user. Postman client can be downloaded from https://www.getpostman.com/downloads/. Once you start the application server and open the Postman client, you can make requests and receive a response. Postman is a useful tool to issue and save requests. Postman can create GET, PUT, POST, etc. requests complete with bodies.

#### What is an API endpoint?
    
    Postman is used to test API endpoints automatically. The API endpoint is a URL that is used to make a specific request to the server. Let's look at an example of an API endpoint:

![Alt text](postman.png?raw=true "API Endpoint")

We can add additional information to an endpoint to return a specific response. In the case of a successful response, 
the Postman client will display ```200 OK``` status. This endpoint can be accessed in the Postman as shown in the snapshot below:

![Alt text](Postman_GET.png?raw=true "Postman endpoint")

For retrieving the data of the first 3 users, you would have to use 
    
    GET http://localhost:8080/api/user/limit=3 
    
And, if you make a ```POST``` request, you'd get a ```200 OK``` response, if successful. 
