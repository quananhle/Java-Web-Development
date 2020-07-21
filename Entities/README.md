###Entity Design

Programs can represent all kinds of ideas, so the tools we use to describe our data must be flexible. 
The variables, which are the building blocks of our Entities, are like words that can mean different things to different 
people. We will use Entities to communicate ideas to our database.

![Alt text](demo/src/main/resources/entities-design.png?raw=true "Entities Design")

####Java Persistence API (JPA)

A specification describing how to manage relational data.

####POJO or "Plain Old Java Object"

A Java object that contains data, but no methods to describe behavior.

####Entity Types

Java classes that describe a collection of data.

* Contain Data only, no behavior
* Represented by a table in the database

####Value Types

The data inside an Entity.

* Primitives like int, boolean, char
* Classes that only represent a single piece of data, like BigInteger or LocalDate
* Represented by a column in the database

####@Entity and @Table Annotations

![Alt text](demo/src/main/resources/@Entity@Table.png?raw=true "Entity and Table Annotations")
######@Entity and @Table Annotations Example

To identify which Java classes we wish to consider as Entities, we added the ```@Entity``` annotation before the class 
name. This informs Hibernate that this class should be stored in the database. Each Entity class will be associated with 
a table of the same name, or you can specify your own table name using the ```@Table``` annotation at the class level. 
The attributes of the classes automatically become columns of the same name, and we can change the names and properties 
of the columns with the ```@Column``` annotation.

As we can see in this example, we’ve added the ```@Entity``` annotation to our ```Person``` class, and we have specified 
that the ```favoriteComposer``` field should be stored in a column called “composer”.

One additional point to remember about Entity classes is that they must provide a public or protected no-arg constructor. 
Java automatically creates one for you if no constructor is specified, but if you create one or more of your own 
constructors for the class, you’ll also have to make sure to include a no-arg version as well.

####Basic Types

Types map a single database column to a single, non-aggregated Java type. Here are some examples of basic types:

|Java                  |JDBC    |Hibernate type    |Registry Key|
|---                   |---     |---               |---    |
|java.lang.String      |VARCHAR |StringType        |string |
|java.lang.String      |NVARCHAR|StringNVarcharType|nstring|
|int, java.lang.Integer|INTEGER |IntegerTypes      |int    |
|long, java.lang.Long  |BIGINT  |LongType          |long   |

![Alt text](demo/src/main/resources/@TypeAnnotation.png?raw=true "@Type Annotation")
An Example of using the ```@Type``` Annotation to Force a Typing

Each BasicType should only map a single value to a single column in the database. Do not attempt to serialize objects or 
lists of primitives into a single column. Doing so violates First Normal Form of database design, preventing standard 
relational functioning.

![Alt text](demo/src/main/resources/Map.png?raw=true "Mapping")
######Basic Types should Map to Single Values, not Composite Values

####Serialization

Transforming your data into a format that can be stored and reconstructed later.

####First Normal form

Each attribute of a table contains only atomic values.

####Atomic

Representing a single piece of data; indivisible.




