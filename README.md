# __Project setup steps__
___
* ```git clone <username>/upme-task.git ```
* go to the folder ```cd 'your project folder'```
* paste project url from the first step
* open the project in your IDE ```File->Open->'your project folder'```

# __To ```run``` application you need:__

* open folder with project in the terminal ```cd 'your project folder'```
* run command ```docker compose up -d --build```

# __To ```stop``` application you need:__

* run command ```docker compose down -v```

# Endpoints for Furniture:

* #### Create Furniture

Request body:
  ```
{
    "height": 5
}
```
* #### Get all furniture `GET http://localhost:8080/api/v1/furniture`
* #### Get furniture by id `GET http://localhost:8080/api/v1/furniture/<id>`
* #### Update furniture by id `PUT http://localhost:8080/api/v1/furniture/update/<id>`
Request body:
  ```
{
    "height": 6
}
```
* #### Delete furniture by id `DELETE http://localhost:8080/api/v1/furniture/<id>`

# Endpoints for Holes:

* #### Create Hole `POST http://localhost:8080/api/v1/hole`

Request body:
  ```
{
  "diameter": 1,
  "depth": 1,
  "entrySpeed": 2,
  "exitSpeed": 3,
  "pattern": "L/2 + B*0.5 + H/3",
  "variables": {
    "L": 100.0,
    "B": 50.0,
    "H": 30.0
  },
  "furnitureDetailId": 2
}
```
* #### Calculate coordinates `POST http://localhost:8080/api/v1/hole/coordinates`

Request body:
  ```
{
  "diameter": 1,
  "depth": 1,
  "entrySpeed": 2,
  "exitSpeed": 3,
  "pattern": "L/2 + B*0.5 + H/3",
  "variables": {
    "L": 100.0,
    "B": 50.0,
    "H": 30.0
  },
  "furnitureDetailId": 2
}
```
* #### Get all holes `http://localhost:8080/api/v1/hole`
* #### Get hole by id `GET http://localhost:8080/api/v1/hole/<id>`
* #### Update hole by id `PUT http://localhost:8080/api/v1/hole/update/<id>`
Request body:
  ```
{
  "diameter": 5,
  "depth": 3,
  "entrySpeed": 2,
  "exitSpeed": 4,
  "coordinates": "1/2/3/4",
  "furnitureDetailId": 1
}
```
* #### Delete hole by id `DELETE http://localhost:8080/api/v1/hole/<id>`


## License

This project is licensed under the Apache License Version 2.0 - see the [LICENSE](LICENSE) file for details.