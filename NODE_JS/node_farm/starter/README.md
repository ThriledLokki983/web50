# ASYNCHRONOUS vs SYNCHRONOUS CODE

    Synchronous code is also know as a Blocking code
    Asynchronous code is the direct opposite - Non-blocking code (Non-blocking I/O model)

### How to avoid Blocking code on the Single Thread Node.js Framework
> Do not use **sync** versions of functions in fs, crypto, and zlib modules in your callback
> Do not perform complex calculations (e.g. loops inside loops)
> Be careful with JSON in large objects
> Do not use too complex regular expressions (e.g. nested quantifiers)
