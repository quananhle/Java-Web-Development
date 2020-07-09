MyBatis provides a shallow ORM layer over JDBC (Java Database Connectivity). That means it helps map your Java objects to queries that save and retrieve data using JDBC.

MyBatis is mostly used through interface definitions. MyBatis automatically generates classes that implement the interface and makes them available as Spring beans. This is an example interface that defines a MyBatis Mapper. 
    
   **@Select, @Insert, @Update, @Delete**: Annotations representing SQL statements to be executed. Each annotation takes a string for a SQL statement of the corresponding type. For example, a @Select annotation takes a string for a SQL SELECT statement.
   
   **@Options**: Annotation providing access to switches and configuration options for JDBC statements.

The **@Insert** annotation automatically references attributes on the user object. Note username, firstName, lastName are all referenced directly here, because they are attributes of the user object.
```java
@Mapper
public interface UserMapper {
   @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) " +
           "VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
   @Options(useGeneratedKeys = true, keyProperty = "userId")
   int insert(User user);
}
```
This example also demonstrates the @Options annotation. @Insert normally returns an integer that is the count of rows affected. By using the @Options annotation, we're telling MyBatis that we want to automatically generate a new key and put it in userId. Now the method will return the new userId once the row has been inserted.

All we have to do to use these methods is inject beans for this interface into our services and MyBatis will automatically create the code for the JDBC requests!