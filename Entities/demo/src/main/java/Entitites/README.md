![Alt text](demo/src/main/java/Entitites/data/@Embeddable@IdClass.png?raw=true "Comparison of @Embeddable and @IdClass Composite Keys")

#### Ways to Associate Data

    Value Types: Become single columns in containing Entity’s table.
    Embeddables: Add their attributes as columns in the containing Entity’s table.
    Entities: Become new tables which relate to a containing entity by a Join Column.

![Alt text](demo/src/main/java/Entitites/data/OnetoOne.png?raw=true "OneToOne Data Contained in Parent Table")

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

