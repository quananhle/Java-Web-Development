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
__________________________________________________
Let's look at a simple example of hashing. Suppose that a user has the following password: ```passw0rd!```. If we directly store this text in the database, we will have a major security vulnerability.

    passw0rd! → database (⚠️ Bad idea! ⚠️)

So instead, we can first run the password through a one-way function that produces a jumbled up piece of text (which has no obvious discernible relationship to the original password). That jumbled up piece of text is the hash, and it might look something like this:

    passw0rd! → hash function → @kdF3lkAWoLA

So when the client interacts with the server, rather than directly sending the password, the client can instead send the hash:

    passw0rd! → hashing function → @kdF3lkAWoLA → stored in database

This way, if someone gains access to the database, they will still not have access to the plain-text password.
_________________________________________________

#### Some famous Hashing Algorithms

There are many hashing algorithms prevalent in the industry.

    MD5: The MD5 Message-Digest Algorithm is a hash function that accepts an input message of any length, and correspondingly produces a 128-bit (16-byte) hash value. Mostly, MD5 is used to verify data integrity. It was proposed by Ronal Rivest in 1992, as specified in RFC 1321. MD5 is comparatively unsafe, as it might get reversed by using brute-force-attack. Also, the chances of collision are very high in MD5. For non-critical applications, MD5 can be a good choice as it is computationally faster than other algorithms.

    SHA: The SHA (Secure Hash Algorithm) is a set (SHA-0, SHA-1, SHA-2, and SHA-3) of cryptographic hash functions developed by the National Institute of Standards and Technology (NIST). In comparison to MD5, SHA generates secure hashes. SHA-1 is a 160-bit hash function. SHA-2 is further of two types: SHA-256 and SHA-512. SHA-256 is a 256-bit hash function that provides 128 bits of security in the case of collision attacks, while SHA-512 is a 512-bit hash function is designed for 256 bits of security. SHA-3 supports the same hash lengths as SHA-2. Chances of collision are high in SHA as well, but lesser than MD5. Thus, SHA-2 could be a good choice for general purpose application with a limited set of inputs, such as a University portal.

    bCrypt: It is generally used to generate the hash for user-passwords. bCrypt is based on the Blowfish cipher algorithm. It has a crucial phase for key setup. This phase starts with encrypting a sub-key and uses the output of this encryption to change another sub-key. This way, the bCrypt involves iterative steps for generating the hash, making it a preferred choice of developers for critical applications.

    sCrypt: It is a computationally intensive password-based key derivation function, proposed in 2016, as specified in RFC 7914. As part of the algorithm, it generates a large vector of pseudorandom bit strings. Thus, it requires a large amount of memory for computation. It isn't easy for a brute-force-attacker to reverse the hash, as it would involve a significantly high amount of time, memory, and a high number (billion) of attempts. Other password-based key derivation functions such as PBKDF1 and PBKDF2 have relatively low resource demands.

#### Deep Dive Topics to Explore Further

##### Collision

In several scenarios, two different keys can generate the same hash. Such a scenario is called Collision. If we use a simple hash function, such as input length or sum of ASCII code of all characters, then it might lead to a collision. A collision can be resolved by using any of the following Collision Resolution Techniques:

    Separate Chaining - It is a type of Open Hashing technique. The idea is to store the keys corresponding to collision (same) hash outputs in a Linked List. There would be a separate Linked List for each unique hash output.
    Open Addressing - It is also called Closed Hashing. In this approach, for a given set of $n$ input keys, we take a data structure that can accommodate more than $n$ keys. The idea is to store the keys corresponding to collision (same) hash outputs in the next available slot in the data structure.
        Linear or quadratic probing - Keep probing until an empty slot is found.
        Double Hashing - We use two hash functions - one for hashing, and another for calculating the offset. Then, this offset is appended to the output of the first hash function. This way, the final output is expected to be collision-free value.

The below diagram lists the approaches used for collision resolution.

![Alt text](collisionresolutiontechniques.png?raw=true "Collision Resolution Techniques")

#### Salting

A salt is random data that is used as an additional input to a one-way function that "hashes" data, so that the final hash becomes more secure. Salting is an approach to generate two different hash values for two different users providing the same input.

#### A Sample Scenario to Depict the Need for Salting

Assume there are two users who might have the same password. For example, Alice and Bob, each with the password m1p2s9wo@d. According to a hash function, these two same input passwords would both map to a single output, say, q#az5sd%!24. Now, if the hash or corresponding password is compromised for one user, then the attacker would get access for another user as well. Salting then, prevents this by forcing each password to be unique in a way transparent to the user.

#### How does Salting Works?

Following figure explains the concept of Salting:

![Alt text](salting.png?raw=true "Salting")

In the above example, two users have the same password: ```m1p2s9wo@d```. Here's what happens if we run those passwords through a hash function:

    User 1: m1p2s9wo@d → hash(m1p2s9wo@d) → q#az5sd%!24
    User 2: m1p2s9wo@d → hash(m1p2s9wo@d) → q#az5sd%!24

In the above case, we end up with the same hashed value for both users. But if we first add a salt, the result is different:

    User 1: m1p2s9wo@d + AE1USR → hash(m1p2s9wo@dAE1USR) → A#bz5AA%Z24

    User 2: m1p2s9wo@d + BB2USR → hash(m1p2s9wo@dBB2USR) → B#bz5BB%Z48

As you can see, even though both users have the same original password, the hashes are different after salting.

##### Points to Consider

* In a web application, the Salting must be done on the Server.
* While hashing user-passwords, the Salt should be generated randomly. It is preferable if the Salt is unique for each user's password.
* For numeric Salt, it is good to use secure algorithms such as Cryptographically Secure Pseudo-Random Number Generator (CSPRNG) . Java has ```java.security.SecureRandom``` class for generating PRNG
* For pseudo-random alpha-numeric string generator, you may use Apache class, as ```org.apache.commons.text.RandomStringGenerator```
* When we use Salting, there are two separate steps involved - 

        (i) Generate the salted password, and
        (ii) Verify the salted password. We would see the detailed implementation in the project, where we would implement bCrypt hashing algorithm along with Salting.

##### Implementing Hashing (SHA) along with Salting:

In the following example, SHA-256 algorithm is used for hashing, and Salting is done by using an instance of ```java.security.SecureRandom``` class. For hashing, we can create an instance of ```java.security.MessageDigest``` to use any of the hashing algorithms SHA-1, SHA-256, SHA-512

```java

import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.MessageDigest;

public class SaltExample {

public static void main(String[] args)throws NoSuchAlgorithmException, NoSuchProviderException {
  String passwordToHash = "password";
  byte[] salt = createSalt();

  String securePassword = get_SecurePassword(passwordToHash, salt); 
  System.out.println(securePassword); 
 }


// Method to generate the hash. 
//It takes a password and the Salt as input arguments
private static String get_SecurePassword(String passwordToHash, byte[] salt){
  String generatedPassword = null;
  try {
   MessageDigest md = MessageDigest.getInstance("SHA-256");
   md.update(salt);
   byte[] bytes = md.digest(passwordToHash.getBytes());
   StringBuilder sb = new StringBuilder();
   for(int i=0; i< bytes.length ;i++)
   {
    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
   }
   generatedPassword = sb.toString();
  } 
  catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }
  return generatedPassword;
 } 

// Method to generate a Salt
private static byte[] createSalt() {
  SecureRandom random = new SecureRandom();
  byte[] salt = new byte[16];
  random.nextBytes(salt);
  return salt;
 }

}
```

Please note, if you wish to use bCrypt for hashing, you may use an instance of ```org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder``` class, which is a part of the Spring framework. We would see the implementation of bCrypt in our Spring Boot project. A sample snippet to understand the concept is given below:

```java
BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
  String securePassword = bCryptPasswordEncoder.encode("mySaltedPassword");
```

In the above snippet, ```securePassword``` is the generated hash, and the ```mySaltedPassword``` is the String containing the actual password and the appended Salt. 