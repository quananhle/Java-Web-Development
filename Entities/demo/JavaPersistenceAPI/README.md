### Persistence Context

#### Definitions

    Persistence Context: Describes the relationship between all the Entity instances in our program and their representations in the underlying database.
    Instance: A specific copy of an Entity in program memory.

#### Persistence Context Entity States

    Transient: not associated with the persistence context. Often has not yet had an ID assigned.
    Managed: persistent. Managed by the current persistence context. Changes to the entity will be reflected in the backing database.
    Detached: previously managed. Occurs to all managed entities when persistence context ends.
    Removed: scheduled to be removed from the database. Java object still exists and has ID.

![Alt text](PersistenceContext.png?raw=true "Persistence Context Keeps Track of which Java Objects are Managed Entities")

#### Changing Persistence States

    Persist: Takes an Entity not yet managed. The Entity becomes managed and will be saved to the database.
    Find: Looks up an id in the database and returns a managed Entity.
    Merge: Updates an Entity that is in the detached state. Returns an instance of that Entity that is now managed. If Entity was not found in the database to update, persists Entity as a new row.
    Remove: Detaches an entity and deletes it from the database.
    
Setting a fetch strategy can prevent your Entities from loading associated values until those values are referenced.

#### FetchType.EAGER

Always retrieve the associated values as part of the Entity retrieval. This means the initial query for the entity 
retrieves this data.

#### FetchType.LAZY

Wait to retrieve associated values until they are referenced. Lazy-loaded attributes are Hibernate proxy objects whose 
specific values are retrieved from the database only if they’re accessed. The initial query for the entity will NOT 
retrieve this data.

#### Default Values

An easy way to remember this is that both associations mapping to Many objects default to Lazy, because it’s more costly to retrieve lots of objects from the database. Associations mapping to One object default to Eager, because there’s usually less information.

#### FetchType.LAZY:

    @OneToMany
    @ManyToMany

#### FetchType.EAGER:

    @ManyToOne
    @OneToOne

![Alt text](SQL.png?raw=true "Persistence Context Keeps Track of which Java Objects are Managed Entities")

Named queries can help us organize our queries by class. They also allow us to compiler-check our queries for validity at build time. Any named queries that reference invalid entities will throw exceptions, helping ensure we don’t commit invalid query strings. To use them, declare them at the top of the Entity class to which they refer. Remember that their names are global across the whole persistence unit, so they should all have unique names.
```java
@NamedQueries({
 @NamedQuery(
  name = "Outfit.findByHat", 
  query = "select o from Outfit o where o.hat = :hat"),
 @NamedQuery(
  name = "Outfit.findBySock", 
  query = "select o from Outfit o where o.sock = :sock")
})
```

You can also use the criteria builder to construct queries dynamically using Java code. We can represent the following query with criteria builder as follows.
```mysql-sql
SELECT h FROM Humanoid h
WHERE :outfit MEMBER OF h.outfits
```

```java
List<Humanoid> findHumanoidByOutfitCriteria(Outfit o) {
   CriteriaBuilder cb = entityManager.getCriteriaBuilder();
   CriteriaQuery<Humanoid> criteria = cb.createQuery(Humanoid.class);
   Root<Humanoid> root = criteria.from(Humanoid.class);

   criteria.select(root).where(cb.isMember(o, root.get("outfits")));
   return entityManager.createQuery(criteria).getResultList();
}
```
#### Unique Interface, Unique Implementation

    More customizable, able to limit methods per Entity.
    Lots of very similar interfaces and classes.

#### Generic Interface, Unique Implementation

    Fewer Interfaces, but implement unused methods.

#### Generic Interface, Generic Implementation

    Most work up front.
    Least redundant code.

