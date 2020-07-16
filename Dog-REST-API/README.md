Test this in ```Postman```, where I change the "Authorization" tab to use "Basic Auth", I am using a ```GET request```, 
and then first attempt without a username and password. I will again get a status code of 401 meaning I am unauthorized. 
If I add the correct username and password, I can access the API.

![Alt text](resources/WebSecurityConfigurerAdapter.png?raw=true "Find All Dog Breeds")
 
 WebSecurityConfigurerAdapter to secure the API with Basic Authentication
 
![Alt text](resources/postman-unauthorized.png?raw=true "Postman")
 
