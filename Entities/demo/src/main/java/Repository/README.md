![Alt text](RepositoryPattern1.png?raw=true "")

![Alt text](RepositoryPattern2.png?raw=true "")

### Flushing and Transactions

#### Definitions

* Flushing: The process of synchronizing the state of the persistence context with the underlying database.
* Transaction: A set of operations that either succeed or fail as a group.
* Level 1 Cache: The Persistence Context functions as a Level 1 Cache, because it does not write changes to the database until Flushing occurs.

#### Flushing Triggers

1. Transaction Ends
2. Query overlaps with queued Entity actions
3. Native SQL Query executes without registering affected Entities

#### Transactions

If we execute multiple persistence operations, a failure on one could leave the Database in an inconsistent state. 
By wrapping multiple operations in a Transaction, no changes will be applied unless all operations succeed.
A good practice is to start one Transaction for each request that interacts with the database. The simplest way to do 
this in Spring is through the ```@Transactional``` annotation. You can annotate methods to begin a transaction when the 
method starts and close it when you leave. You can also annotate classes to treat all their methods as ```@Transactional```. 
This annotation is best done at the Service layer, so a new transaction is started whenever the Controller classes 
request operations that may involve the database.