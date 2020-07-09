User support is a common feature in web applications, which means that a user can register an account and use credentials to login to the application in the future.

It's important to design databases with the assumption that they will some day be breached, and so we cannot store passwords or other secret credentials in plain text. Two approaches to storing passwords are:

    Encryption: Modifying data before storing it, with the intention of using another algorithm to return the data to its original form once it needs to be used.
    Hashing: Modifying data before storing with the intention of never returning it to its original form. The modified data will be compared to other modified data only.

**Hashing** and **Encryption** should occur in a service dedicated to that purpose, rather than on the front end or in the controller. Remember separation of concerns and our onion architecture! The idea is that all user flows originate externally, travel through a controller, then through one or more services, finally through a data access bean to the database, and then all the way back up the chain. Structuring applications this way makes it easy to follow dependencies and separate concerns, so that's how we're going to build applications from now on.