## Authentication and Authorization

### Why bother?

Data breaches are on the rise and are expensive. It is estimated that the amount of data stolen will triple in the next 5 years. The number of people affected rose 3 million from 2017 to 2018. The average cost of a single breach in the US has been estimated to be $7.9 million, and $3.8 million on average worldwide. Data breaches are becoming harder to track and locate.In 2018, the average amount of time to identify that a breach had occurred was 196 days. The more straightforward solution is to try to prevent breaches before they can occur; therefore, authentication and authorization are critical.

### What is Authentication?

Authentication confirms your identity. It is a process that proves that you are the person who you say you are. In the digital world, the most common way to authenticate is to use a username and password. For example, while logging into your eCommerce account, you prove your identity by providing an email and a password, sometimes followed by an OTP or a second factor. There are many other ways to authenticate, and these are depicted in the figure below.

![Alt text](authentication.png?raw=true "Authentications")

#### Common Mechanisms for Authentication

   __Token-based authentication__ - an object you have or you control proves who you are (see https://scotch.io/tutorials/the-ins-and-outs-of-token-based-authentication) (note: we do use this later in the form of JWT, but we first authenticate with the username and password, then sending the token on each subsequent request)

   **OAuth** - is an industry-standard protocol for authorization that provides a token on your behalf once you’ve authenticated to the external service (see https://auth0.com/docs/protocols/oauth2 if you've ever seen a "Sign in with Google/Facebook/etc", this is likely done using OAuth)

   __Time based token (TOTP)__ - a token is generated with something only you know. This token changes after some time period (see https://www.freecodecamp.org/news/how-time-based-one-time-passwords-work-and-why-you-should-use-them-in-your-app-fdd2b9ed43c3/ This is very commonly used in Two Factor Authentication as the 2nd factor. If you have random codes you need to enter, they may have been generated using this scheme)

   __Biometric authentication__ such as Fingerprints or Facial recognition (popular on smartphones)
    
##### Network Authentication Protocols

    Most of the standard mechanisms for authentication utilizes either of the following two "Network authentication protocols": i). Kerberos, and ii). Secure Sockets Layer (SSL) / Transport Layer Security (TLS).

### What is Authorization?

In general, Authorization comes after Authentication. Authorization determines whether you are permitted or have the right privilege to access the requested resources. In other words, it determines what a user is allowed to access.

The following figure shows the order of execution of basic authentication and authorization in an application that follows the Model View Controller (MVC) architectural pattern. MVC is a way of organizing source code into three main categories - Model, View, and Controller. MVC helps in achieving loose coupling and high cohesion in the source code. MVC makes it easier to add new functionalities and changes without disturbing the existing code. The "Model" handles the data-related logic, "View" handles the user-interface related logic, the "Controller" handles the entire business logic such as processing the requests, and data manipulation. The Controller acts as an interface between the View and the Model.

![Alt text](basic-authentication-and-authorization.png?raw=true "Basic authentication and authorization")

#### Authentication Considerations

Good authentication practices center around protecting the data used for authentication. You wouldn't just tell people your password, and so your website shouldn't either. You also need to ensure things are sufficiently random and complex, with things like length requirements, to ensure that your credentials aren't easily cracked. They must not be able to be forged easily, so no one can impersonate anyone else. Finally, they have to be deterministically generated, that is they must be generated the same way every time, to ensure you actually can authenticate users into your system.

#### Authentication Protection

Imagine you have an application that must store users’ passwords. You might store them in a database, but storing them as is allows anyone to read them, if they can access your database, they can see your password. How can we solve this problem?

We solve this with ”hashing”. Hashing is the process of generating a unique value (hash) for a given text, string, or numeric input (key). Unlike encryption-decryption, a good hash is irreversible. So, it is extremely difficult to compute the input given the output. If we do not use a good hashing algorithm, then an attacker may try to reverse the hash by brute-force, or exhaustive key search.

Example: Let's take a hashing function that maps the input string to their length, as shown in the following table:

|Input|Output Hash|
|---  |---        |
|CAT  |3          |
|HAPPY|5          |
|LOGIC|5          | 	
 	
The string CAT would convert to 3, and the string HAPPY would map to 5. If you are given the output as 5, you would not be able to predict the actual input.
Another point to note here is that two different inputs HAPPY and LOGIC are generating the same output, 5. Hence, the above example of hashing isn't a very good or secure hashing function. This illustration concludes the following two properties of hashing:

* Hashing must be irreversible
* Each input should have a unique output (or, practically, as close to unique as possible)

A scenario, when a hash function gives the same output for different inputs, is called a collision. Let's explore more about hashing and collision next .

#### Hashing

##### What is Hashing?

Hashing is the process of generating a unique value (hash) for a given text, string, or numeric input (key). The generated value (hash) itself could be either text, string, or numeric, which depends upon the underlying Hash function. A Hash function is a one-way mathematical function which is used to generate a unique value for a given input.

##### Hashing is Irreversible

Let there be a function f, which can generate unique hash values for a given set of input. Another function g can get the original value back if the hash value is given as input. In such a case, the function f would be called reversible, as we can get the original value back. Hence, f cannot be used as a Hash function. Following is an example of a reversible function:

![Alt text](Hashing.png?raw=true "Hashing")

##### Where to use Hashing in an Application?

We use hashing to store any sensitive information in the system, such as user passwords.

