###Repository that extends CrudRepository.

First, create a new package in the same directory that holds your main application, called repository. Then, create a new Java interface called DogRepository (note that you can create a new interface in IntelliJ first by adding a new Java class, and then selecting interface on the menu that comes up).

Here, you'll need to import both your Dog entity as well as CrudRepository from the Spring framework, which will extend your DogRepository interface. While Spring implements a lot of the repository for you, I have added a few helpful queries to be able to obtain some of the necessary information for our DogService later. When I use an id as input to findBreedById, I needed to add a : into the query line to feed in from my method.

Note that instead of taking this approach, you could alternatively use the built-in queries from CrudRepository within the DogService to get all dogs or get a dog by ID, then process the resulting object as well.