# SYNCHRONOUS Javascript

- Code is run/executed line by line

- Each line waits for the previous line to finish

- Long running operations block the code form executions

# ASYNCHRONOUS Javascript

    setTimout(()=> {p.textContent = 'My name is asynchronous'}, 5000)

- Code is executed after a task that runs in the 'background' finishes.

- asynchronous code is **non-blocking**

- Execution doesn't wait for an asynchronous task to finish work

- Coordinating behavior of a program over a period of time.

- Callback functions does not automatically make a code asynchronous! \*you have to know which one do (e.g. setTimeout(), src attribute) and which one does not (e.g. map())

- EventListners does NOT make automatically make code asynchronous

## AJAX Calls

    Asynchronous Javascript And XML:
    It allows us to communicate with remote servers in an asynchronous way. With AJAX calls, we can request data from web servers dynamically.

    Most popular API data format: JSON data format - a Javascript object converted to a string

    API Lists

    https://github.com/public-apis/public-apis
    CORS ==> Yes / Unknown : Cross Origin Resource Sharing
    API Endpoint : another name for the URL that we need.

> API:

- Piece of software tha can be used by another pice of software, in order to allow **applications to talk to each other** e.g. DOM API, Geolocation API, Own Class API

> Online API: Application running on a server, that receives requests for a data, and sends data back as response. Building our own Online API (requires back-end development, e.g. with Node.js) or use 3rd-party API's
>
> - Weather data
> - Data about countries
> - Flights data
> - Currency conversion data
> - APIs for sending emails
> - Google Maps
> - Millions of possibilities

**What happens when we access the Web Server:**

> - DNS Lookup
> - TCP/IP Socket Connection
> - HTTP request
> - HTTP Response

**Callback Hell:** In order to solve this, you will have to create a sequence for which one call runs after the first one is done.

> When there is a lot of nested callbacks in orther to execute asynchronous tasks in sequence.

```
hello => function();
```
