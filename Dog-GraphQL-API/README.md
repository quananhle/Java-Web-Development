First, using a ```POST``` request, then add graphQL URL [url]http://localhost:8080/graphql to the app. Then, add a Header with ```Content-Type``` as ```application/json```.

![Alt text](pictures/login.png?raw=true "Login Page")
Adding a ```POST``` request to the ```GraphQL API```

For each of the request, enter into *"Body"* in Postman and then *"Send"* the request.

**findDogBreeds**
```json
{
  "query": "{findAllDogs { id breed } }"
}
```
![Alt text](pictures/findDogBreed.png?raw=true "Find All Dog Breeds")

**findDogBreedByID**


