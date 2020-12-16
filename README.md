# Spring boot CQRS - Single database
CQRS suggests dividing the Application Layer into two sides, the commands side, and the queries side.
- The queries side should be responsible and optimized for reading data. 
- The commands side should be responsible and optimized for writing data.

Single Database CQRS design has not a formal name, so Mattew Renze in his Pluralsight course Clean Architecture called it the Single Database CQRS

The POC is to clearly separate both the service and the controller layers to deal with Reads – Queries and Writes – Commands coming into the system separately.

###Created two endpoints:

#####1. CustomerCommandRestController - Add new customer (CURL Request):

```
POST /customers HTTP/1.1
Host: localhost:8080
Content-Type: application/json
cache-control: no-cache
Postman-Token: 1de609ab-9116-43d9-b57c-86b7f0e775d4
{
	"firstName":"Vinod",
	"lastName":"Pillai",
	"emailId":"vinod@yopmail.com",
	"password":"vinod"
}------WebKitFormBoundary7MA4YWxkTrZu0gW--
```

#####2. CustomerQueryRestController - Get customer by ID (CURL Request):

```
GET /customers/1 HTTP/1.1
 Host: localhost:8080
 cache-control: no-cache
 Postman-Token: d17c8bcb-21d1-4e5b-8387-47e369c19913
```
