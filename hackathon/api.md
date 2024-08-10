## API documentation

#   User REST AIP Documentation :
-   user login :
    -   `POST / http://ip:8080/back/data/users/authentication`
      - status code: 
        - `200` (success) or `403`(wrong inputs)
    
-   get all users :
    -  `GET / http://ip:8080/back/data/users`
    - return type : 
      - status code: `200`
        - body: list of users
          - Exemple :
          ```
          [
            {
              "uname" : "...",
              "userName": "...",
              "email" : "...",
              "password" : "******",
              "toDoListDtos" = []
            }
          ]

-   get a user by id :
    -  `GET / http://ip:8080/back/data/users/username`
    - return type :
      - status code : `200`
        - body :
          ```
          {
            "uname" : "...",
            "userName": "...",
            "email" : "...",
            "password" : "******",
            "toDoListDtos" = []
          }
    
-   create a user :
    -  `POST / http://ip:8080/back/data/users/add`
    - status code : `201`
    - body type :
      ```
           {
              "uname" : "John Doe",
              "userName": "Doe",
              "email" : "john@doe.com",
              "password" : "johndoe"
           }

-   update a user information :
    -  `PUT / http://ip:8080/back/data/users/update/username`
    - status code : `200`
    - body type :
    ```
            {
              "uname" : "...",
              "userName": "...",
              "email" : "...",
              "password" : "******",
              "toDoListDtos" = []
            }

-   delete a user :
    -   `DELETE / http://ip:8080/back/data/users/delete/username`
    - return type : `string`

#   To do lists :

-   all to do lists : 
    -   `GET / http://ip:8080/back/data/todoLists`
    - status code : `200`
    - return type : List of to do list.
      - Example :
    ```
    [
        {
            "id" : "...",
            "signature": "...",
            "name" : "...",
            "userName" : "..."
        }
    ]
    

-   get a specific to do list by its id :
    -   `GET / http://ip:8080/back/data/todoLists/id`
    - status code : `200`
    - return type :
    ```
    {
        "id" : "...",
        "signature": "...",
        "name" : "...",
        "userName" : "..."
    }

-   add a new to do list to a user :
    -   `GET / http://ip:8080/back/data/todoLists/add`
    - status code : `201`
    - body type :
    ```
    {
        "id" : "...",
        "signature": "...",
        "name" : "...",
        "userName" : "..."
    }
    

-   update a to do list by its id :
    -   `PUT / http://ip:8080/back/data/todoLists/update/id`
    - status code : `200`
    - body type :
    ```
    {
        "id" : "...",
        "signature": "...",
        "name" : "...",
        "userName" : "..."
    }

-   delete a specific to do list by its id :
    -    `DELETE / http://ip:8080/back/data/todoLists/delete/id`