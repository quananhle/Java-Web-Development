![Alt text](data/@Embeddable@IdClass.png?raw=true "Comparison of @Embeddable and @IdClass Composite Keys")

#### Ways to Associate Data

    Value Types: Become single columns in containing Entity’s table.
    Embeddables: Add their attributes as columns in the containing Entity’s table.
    Entities: Become new tables which relate to a containing entity by a Join Column.

![Alt text](data/OnetoOne.png?raw=true "OneToOne Data Contained in Parent Table")

#### Association Reciprocity

#### Unidirectional - Association specified on one side of the relationship only.

    Doesn't retrieve data you won’t use.
    Should use Set collection type for most efficient SQL.

#### Bidirectional - Association specified on both sides of the relationship. Use mappedBy on the containing Entity side.

    Access both sides of relationship with a single query.
    Hibernate recommends for @OneToMany, because it allows the foreign key constraint to exist only on the table of the contained object.

#### Types of Entity Associations

    OneToOne: Single Entity on each side of the relationship.
    OneToMany and ManyToOne: List of Entities on one side, single Entity on the other.
    ManyToMany: Lists of Entities on both sides.

![Alt text](data/AssociationTypes.png?raw=true "Association Types")

#### Unidirectional

You only need to specify the Entity on a single side of the relationship. For Example, this is the Person class showing a unidirectional ```@OneToMany``` relationship to Outfit.

![Alt text](data/OnetoMany.png?raw=true "Directional")

#### Bidirectional

Both classes have a reference to each other. Here is a bidirectional OneToMany relationship showing that one person has many outfits, and each outfit has one person.

![Alt text](data/Bidirectional.png?raw=true "Bidirectional")

#### @JoinTable

Many associations can be stored in a single ```@Joinumn``` on one of the two entity tables, but you may also elect to 
store the relationship in a table designated for that purpose. ```@ManyToMany``` relColationships must use a Join Table, 
and will automatically create one even if not specified.

To control the name of the table and its columns, you can use the ```@JoinColumn``` annotation.

#### @ElementCollection

You can use the ```@ElementCollection``` annotation to denote an association between a single Entity and a list of values 
that are not themselves Entities. This annotation lets you persist Lists of Embeddables or enums, for example. 
These embeddables will be stored in a separate table, along with the id of the Entity in which they are contained. 

### Inheritance

#### Single Table Inheritance

The default inheritance strategy used by Hibernate is Single Table inheritance. All the fields of the parent and children 
classes are stored in the same table. Allows the fastest polymorphic queries because no tables need to be joined to access 
all subclasses. Cannot support Not Null column constraints because columns must be able to contain null for sibling classes.

#### Polymorphic Query

A query for the parent class that returns elements of all subclass types.

![Alt text](data/SingleTableInheritance.png?raw=true "Single Table Inheritance")