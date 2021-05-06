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
  ```

- Expose structured, resource-based URLs
- Use HTTP methods (verbs)
- Send data as JSON (usually)
- Be Stateless
