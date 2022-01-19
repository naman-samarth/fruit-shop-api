# Fruit Shop API

A Spring Boot RESTful API modelled after the http://predic8.de API example, executing the standard set of CRUD operations on a set of data around the concept of a fruit shop.

Unit tests are written with JUnit 5 and JacCoCo is used to provide test coverage information for the unit tests.

## Requirements

* Java 11
* Spring Boot 2.6.2
* Gradle 7.3.2
* H2 1.4.2
* JUnit 5

## Getting started

* Fork or clone the project.
* Start the project server by running the command `gradle bootRun`.
* The API can be called with any of the following cURL CRUD-based requests (in either JSON or XML formats):

    * GET/READ:

        * ```curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/v1/categories/'```
        * ```curl -X GET --header 'Accept: application/xml' 'http://localhost:8080/api/v1/categories/'```
        * ```curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/v1/customers/'```
        * ```curl -X GET --header 'Accept: application/xml' 'http://localhost:8080/api/v1/customers/'```
        * ```curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/v1/vendors/'```
        * ```curl -X GET --header 'Accept: application/xml' 'http://localhost:8080/api/v1/vendors/'```

    * CREATE/ADD:

        * ```curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"name": "Exotic"}' 'http://localhost:8080/api/v1/categories/'```
        * ```curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"name": "Western Tasty Fruits Ltd."}' ''http://localhost:8080/api/v1/vendors/'```
        * ```curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"firstname": "Jake", "lastname": "Peralta"}' ''http://localhost:8080/api/v1/customers/'```

*  Check code coverage with the command `gradle test jacocoTestReport`.
## API Documentation

API documentation is provided by means of OpenAPI3.0, which can be opened in the browser with the following urls:

* http://localhost:8080/v3/api-docs
* http://localhost:8080/swagger-ui.html