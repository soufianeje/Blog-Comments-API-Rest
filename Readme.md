# Spring Boot, Spring Data JPA, Hibernate and MySQL API Rest.

Build  API Rest CRUD for a blog's comments application using Spring Boot, Spring Data JPA, Hibernate and Mysql.

## Environment Requirements

Java - 1.8.x, Mysql - 5.x.x and Maven - 3.x.x. 

## Steps to Make Setup

**1. Clone the application from github**

```bash
git clone https://github.com/callicoder/spring-boot-mysql-rest-api-tutorial.git
```

**2. Create Mysql database using command line or directly using Wamp Server**

```bash
create database blogs_api
```

**3. Change Mysql username and/or password according to your installation**

1- open file `src/main/resources/application.properties`

2- change variables : `spring.datasource.username` and `spring.datasource.password`

**4. Build and Run the application using Maven or Launch it from CommentsBlogApplication class (Run As Java Application)**

```bash
mvn package
java -jar target/blogs-1.0.0.jar
```

**Or you can run it without packaging**

```bash
mvn spring-boot:run
```

The application will start and run at : http://localhost:8080.

## Exposed HTTP Methods in the API Rest.

The application defines the following CRUD HTTP Methods.

    POST /blogs
    
    GET /comments
    
    POST /blogs/{id}/comments
    
    GET /blogs/{id}/comments
    
    PUT /comments/{id}
    
    DELETE /comments/{id}

The methods can be tested using Postman or any Rest Client.
# Blog-Comments-API-Rest
