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


