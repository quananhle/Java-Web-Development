#### JdbcTemplate

```JdbcTemplate``` functions like the EntityManager: it provides connections, executes queries, and manages transactions.

```NamedParameterJdbcTemplate``` allows you to use named parameters in your query string.

```dbn-sql
-- with standard JdbcTemplate
select * from person where id = ? and age >= ?

-- with NamedParameterJdbcTemplate
select * from person where id = :id and age >= :minAge
```

#### queryForObject

To query for a single object, you can use the jdbcTemplate.queryForObject method. This example takes three parameters:

1. Query String
2. A map of parameter names to parameter values
3. A RowMapper that returns the instance of the object for which we’re querying

```java
@Autowired
NamedParameterJdbcTemplate jdbcTemplate;

private static final String SELECT_PERSON_BY_ID = 
   "SELECT * FROM person " + 
   "WHERE id = :id";

public PersonData getPersonById(Long id){
   return jdbcTemplate.queryForObject(
           SELECT_PERSON_BY_ID,
           new MapSqlParameterSource().addValue("id", id),
           new BeanPropertyRowMapper<>(PersonData.class));
}
```

##### update

The ```jdbcTemplate.update``` method allows you to execute SQL statements that modify the database, such as INSERT, UPDATE, or DELETE.

Instead of taking a RowMapper, it takes an optional KeyHolder object that can contain the id of the new row.

```java
private static final String INSERT_PERSON = 
   "INSERT INTO person (name, age, favorite_composer) " + 
   "VALUES(:name, :age, :favoriteComposer)";

public Long addPerson(PersonData personData) {
   KeyHolder key = new GeneratedKeyHolder();
   jdbcTemplate.update(
           INSERT_PERSON,
           new BeanPropertySqlParameterSource(personData),
           key);
   return key.getKey().longValue();
}
```

```SimpleJdbcInsert```

The ```SimpleJdbcInsert``` class allows us to do inserts without writing a query, which can make it easier to maintain our code if the composition of our tables change.

```java
// does the same as the previous addPerson method
public Long addPersonInsert(PersonData personData) {
   SimpleJdbcInsert sji = new SimpleJdbcInsert(jdbcTemplate.getJdbcTemplate())
           .withTableName("person")
           .usingGeneratedKeyColumns("id");
   return sji.executeAndReturnKey(new 
  BeanPropertySqlParameterSource(personData)).longValue();
}
```

##### ```@Transactional```

Many operations in DAOs involve combining multiple queries into a single request, so transaction management is just as important as before! Fortunately, JdbcTemplate provides a Spring-managed connection, so we can simply use @Transactional to set our transaction boundaries by method just like we did when using Hibernate.
Multiple Database Requests Occurring Inside Transaction

![Alt text](1.png?raw=true "Multiple Database Requests Occurring Inside Transaction")

Let’s look at an example implementation of CandyDAO. We’ve organized our queries and made reusable code into constants. You can see that our implementation methods are actually quite simple!

```java
@Repository
@Transactional
public class CandyDAOImpl implements CandyDAO {

   @Autowired
   NamedParameterJdbcTemplate jdbcTemplate;

   //we can avoid some typo-based errors by using string constants
   private static final String CANDY_ID = "candyId";
   private static final String DELIVERY_ID = "deliveryId";

   private static final String SELECT_ALL_CANDY =
           "SELECT * FROM candy";

   private static final String INSERT_DELIVERY =
           "INSERT INTO candy_delivery (candy_id, delivery_id) " +
           "VALUES (:" + CANDY_ID + ", :" + DELIVERY_ID + ")";

   private static final String FIND_CANDY_BY_DELIVERY =
           "SELECT c.* FROM candy_delivery AS cd " +
           "JOIN candy AS c on c.id = cd.candy_id " +
           "WHERE cd.delivery_id = :" + DELIVERY_ID;

   private static final RowMapper<CandyData> candyDataRowMapper =
           new BeanPropertyRowMapper<>(CandyData.class);

   @Override
   public List<CandyData> list() {
       //no parameters, so we can use a version of .query that only takes two arguments
       return jdbcTemplate.query(SELECT_ALL_CANDY, candyDataRowMapper);
   }

   @Override
   public void addToDelivery(Long candyId, Long deliveryid) {
       //we don't have an object of the right type to use SimpleJdbcInsert, so we'll just do a normal .update
       jdbcTemplate.update(INSERT_DELIVERY,
               new MapSqlParameterSource()
                       .addValue(CANDY_ID, candyId)
                       .addValue(DELIVERY_ID, deliveryid));
   }

   @Override
   public List<CandyData> findByDelivery(Long deliveryId) {
       return jdbcTemplate.query(FIND_CANDY_BY_DELIVERY,
               new MapSqlParameterSource(DELIVERY_ID, deliveryId),
               candyDataRowMapper);
   }
}
```

#### JPA vs. JDBC

#### JPA

* Convenient
* Table relationships defined in Java
* SQL is generated

#### JDBC

* Can be faster
* Table relationships defined in Database
* SQL is written

Generally, optimizing for convenience will save you more time in the long run. If you need to improve the performance of specific operations, there are a few properties you can use to help measure performance. This will cause Hibernate to report on the number of JDBC Statements prepared and executed during each session, as well as their time costs.

```xml
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=DEBUG
```

For Hibernate 5.4.5 and later you can also use this property to cause any single query longer than the specified duration to print a message to the log.

```xml
hibernate.session.events.log.LOG_QUERIES_SLOWER_THAN_MS=25
```
