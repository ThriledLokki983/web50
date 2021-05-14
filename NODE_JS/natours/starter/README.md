# EXPRESS

    Express is a minimal node.js framework, a higher level of abstraction
    Express contains a very robust set of features: complex routing, easier handling of requests and responses, middleware, server-ide rendering
    Express allows for rapid development of node.js applications:
    Express makes it easier to organize our application into the MVC architecture.
    POSTMAN

# REST API - ARCHITECTURE

- Separate API into logical resources

  > **Resource: ** Object or representation os something, which has data associated to it. Any information that can be **named** can be a resource e.g. tours, users, reviews -- \*Endpoints should contain only resources (noun) and use HTTP methods for actions\*

  ```
  /aadNewTour
  /getTour -- GET /tours
  /updateTour
  /deleteTour

  Create: POST
  Read: GET
  Update: PUT / PATCH
  Delete: DELETE

  /getTourByUser: GET /Users/3/tours
  /deleteToursByUser: DELETE /Users/3/tours/9
  ```

- Expose structured, resource-based URLs
- Use HTTP methods (verbs)
- Send data as JSON (usually)
- Be Stateless
  > Stateless RESTful API: All state is handled on the client. This means that each request much contain all the information necessary to process a certain request. The server should not have to remember previous requests.
  > e.g. LoggedIn, currentPage

#### ESlint + Prettier Config

```
npm i eslint prettier eslint-config-prettier eslint-plugin-prettier eslint-config-airbnb eslint-plugin-node eslint-plugin-import eslint-plugin-jsx-a11y eslint-plugin-react --save-dev
```

> .eslintrc.json

## MONGODB

    CRUD
    - CREATE db.tours.insertOne({...}) / db.tours.insertMany({...})
    - READ db.tours.find(...search condition )
    - UPDATE db.tours.updateOne({...searchItem}, {$set: ...newValue for item-param}) / db.tours.updateMany()
              db.tours.replaceOne() / db.tours.replaceMany()
    - DELETE db.tours.deleteOne({}) / db.tours.deleteMany({})

**Querying:**

> db.tours.find({price: {$lte: 500}})
> db.tours.find({price: {$lte: 500}, rating: 4.7 }) // Two condition query
> db.tours.find({ $or: [ {price: {$lt: 500}}, {rating: {$gte: 4.8}} ] }) // Two condition query
> db.tours.find({ $or: [ {price: {$gt: 500}}, {rating: {$gte: 4.8}} ] }) // OR
> db.tours.find({ $or: [ {price: {$gt: 500}}, {rating: {$gte: 4.8}} ] }, {name: 1}) // Projection. only select this field in the output

**Update:**

> db.tours.updateOne({ name: "The Snow Adventure"}, { $set: {price: 597} })
> db.tours.updateMany({price: {$gt: 500}, rating: {$gte: 4.7}}, { $set: {premium: true}})

**Delete:**

> db.tours.deleteMany({rating: {$lte: 4.8}}) // with the condition specified
> db.tours.deleteMany({}) // delete everything

**Running Import Script**

```
node dev-data/data/import-dev-data.js --import
```

# Mongoose Middleware

- Document
- Query
- Aggregate
- Model

# ERROR HANDLING

**Operational Error:**

> Problems that we can predict will happen at some point, so we just need to handle them in advance

- Invalid path accessed
- Invalid user input
- failed to connect to server
- failed to connect to database
- request timeout

**Programming Errors:**

> Bugs that developers introduce into our code. Difficult to find and handle

- reading properties on undefined
- passing a number where an object is expected
- using await without async
- using req.query instead of req.body
- etc

# DATA MODELING

**Types of Relationship**

> One to One
> One to Many

- One to Few:
  > One movie can win many awards
- One to Many:
  > one movie can have many reviews
- One to Ton
  > logging data from an app

> Many yo Many

- One movie can have many actors and one actor can star in many movies

## Referencing Vs Embedding

> In referencing Form: all the related documents are nicely separated - Child referencing. Easier to query each document on its own. We need 2 queries to get data from referenced document.
> In Embedded Form: all related documents are embedded inside one big data - app make fewer queries leading to better performance. However, it is impossible to query the embedded documents on its own

1. **RELATIONSHIP TYPE**
   > How the datasets are related to each other
   > Recommend Embedding: 1:Few / 1:Many
   > Recommend Referencing: 1:Many / 1:Ton / Many:Many
2. **DATA ACCESS PATTERNS**
   > How often data is read and written. Read/Write Ration
   > Recommend Embedding: **High** read/write ratio -- data is read a lot/mostly
   > Recommend Referencing: **Low** read/write ratio -- data is updated a lot
3. **DATA CLOSENESS**
   > How "much" the data is related, how we want to query
   > Recommend Embedding: Datasets really belong together
   > Recommend Referencing: We frequently need to query both datasets on their own

### Types of Referencing (Sec 11-v02)

1. **Child Referencing:** keep references to the related child document in the parent document, usually stored as an Array. Avoid big arrays. 1:Few
2. **Parent Referencing:** Keep a reference to the parent element/document. Best used for 1:many / 1:Ton
3. **Two-Way Referencing:** keep reference to all documents related to the parent document and in each child document, we keep reference of the parent document/element. therefore, child and parent are both connected two-way

> Structure your data to **match the ways that your application queries and updates data**
> Identify the questions that arise from your **application's use cases** first, and the model your data so that the **questions can get answered** in the m,ost efficient way
> In general, **always favor embedding** unless there is a good reason not to embed. Especially on 1:Few and 1:Many relationships
> A 1:Ton or Many:Many relationship is usually a good reason to reference instead of embedding
> Favor **referencing** when data is updated a lot and if you need to frequently access a dataset on its own
> use **Embedding** when data is mostly read but rarely updated, and when two datasets belong Intrinsically together
> Don't allow arrays to grow indefinitely. Normalize, use **child referencing** for 1:Many relationships, and **parent referencing** for 1:Ton relationship
> Use **Two-Way Referencing** for Many:Many relationships
