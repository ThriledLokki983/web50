# TYPES OF STREAMS

    Streams are instances of the EventEmitter class!

-   **Readable Streams:**

    > Streams that can be read (consume) data. e.g. http requests, fs read streams. (events: data, end) -- important functions: pipe(), read()

-   **Writable Streams:**

    > Streams to which we can write data e.g. http requests, fs write streams. (events: drain, finish) -- important functions: end(), write()

-   **Duplex Streams:**

    > Streams that are both readable and writable e.g. net web socket

-   **Transform Streams:**

    > Streams that are both duplex streams and at the same time transform data as it is written or read e.g. zlib Gzip creation
