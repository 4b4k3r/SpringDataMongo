#SPRING DATA MONGO

This is an example of a simple mapping of data to mongo by spring in rest api

##Properties required

|Name|Value|Example|
|----|-----|-------|
|spring.data.mongodb.uri|A uri of dabase connection (direct authentication with a base)|mongodb://user:password@host:port/AuthBaseName| |spring.data.mongodb.database|A base to read/write a data|baseName|

##Endpoint

A single save at uri `host:port/product` as `PUT`

Body request: 

```json
{
	"nombre" : "Leche lala",
	"descripcion" : "Leche lala descricion",
	"precio" : 15.50,
	"caducidad" : "2021/02/01",
	"cantidad" : 5
}
```

Find all products at uri `host:port/product` as `GET` or find a single product at uri `host:port/product/{id}` as `GET`



