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
