# MODERN JAVASCRIPT DEVELOPMENT

    Modules - Building - Transpiling/Polyfiling - Javascript Bundle
                (BABEL - compiles our code to ES5 where all browsers can make use of - build tools - WebPack, Parcel);

    IMPORT (dependency) -- MODULE -- EXPORT (Public API)

**Modules:**

- Reusable piece of code that **encapsulates** implementation details

### Why Use Modules

> **Compose software** Modules are small building blocks that we put together to build complex applications
> **Isolate components:** Modules can be developed in isolation without thinking about the entire codebase.
> **Abstract code:** Implement low-level code in modules and import these abstractions into other modules
> **Organized code:** Modules naturally lead to a more organized codebase
> **Reuse code:** Modules allow us to easily reuse the same code, even across multiple projects.

### ES6 MODULES

    Modules stored in files, exactly one module per file.
    Thus:
    > top-level variables and can be used only after exporting
    > Default mode : strict mode
    > Top-level this: undefined
    > imports (hoisted) & exports: YES
    > HTML Linking <script type="module">
    > File downloading: Asynchronous

> **NPM:** Contains open-source packages to include 3rd-party code in our own code (e.g. React, JQuery, Leaflet)

## Using Parcel

    npm i parcel - to install
    npx parcel <entry pnt> - to start using parcel
     - using npm script

```
// will keep the browser in the same state.
if (module.hot) {
  module.hot.accept()
}
```
