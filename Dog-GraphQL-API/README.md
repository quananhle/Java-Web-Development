First, using a ```POST``` request, then add graphQL URL [url]http://localhost:8080/graphql to the app. Then, add a Header with ```Content-Type``` as ```application/json```.

![Alt text](pictures/java-graphql-postman.png?raw=true "Find All Dog Breeds")
Adding a ```POST``` request to the ```GraphQL API```

For each of the request, enter into *"Body"* in Postman and then *"Send"* the request.

**findDogBreeds**
```json
{
  "query": "{findAllDogs { id breed } }"
}
```
![Alt text](pictures/findDogBreeds.png?raw=true "Find All Dog Breeds")

**findDogBreedByID**
```json
{
    "query":"{findAllDogs { id breed } }"
}
```
![Alt text](pictures/findDogBreedByID.png?raw=true "Find Dog Breeds By ID")

**findAllDogNames**
```json
{
    "query":"{findAllDogs { id name } }"
}
```
![Alt text](pictures/findAllDogNames.png?raw=true "Find All Dog Names")

**updateDogName**
```json
{
    "query":"mutation {updateDogName(newName:\"Ghost\", id:4) { id name breed } }"
}
```
![Alt text](pictures/updateDogNames.png?raw=true "Find All Dog Names")

**deleteDogBreed**
```json
{
    "query":"mutation {deleteDogBreed(breed:\"Pomeranian\")}"
}
```
![Alt text](pictures/deleteDogBreed.png?raw=true "Find All Dog Names")
