We can see that the second configure method does four things:

    - Allows all users to access the /signup page, as well as the css and js files.
    - Allows authenticated users to make any request that's not explicitly covered elsewhere.
    - Generates a login form at /login and allows anyone to access it.
    - Redirects successful logins to the /home page.

**configure(AuthenticationManagerBuilder auth)**: used to tell Spring to use our AuthenticationService to check user logins
**configure(HttpSecurity http)**: used to configure the HttpSecurity object by chaining methods to express security requirements