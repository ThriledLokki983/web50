# Why Architecture
    It helps us to organize our code 
    To implement change in the future easily
    To make it possible to add new features in the future 

### Architecture Patterns
- MVP
- MVC
- Flux, etc
- Use Framework to take care of the Architecture
    > React
    > Angular
    > Vue
    > Svelte, etc 


### Components of an A Good Architecture
- Business Logic
    > All the code that solves the actual business problem. This is directly related to what the business does and it needs.

- State
    > Essentially stores all the data about the application. It should be the "single source of truth". Thus, UI should be kept in sync with the state 

- HTTP Library
    > Responsible for making and receiving AJAX request. Optionale but almost always neccessary in real-world apps.

- Application Logic (Router)
    > Code that is only concerned about the implementaion of the application itself. It handles the navigation and the UI events

- Presentation Logic (UI Layer);
    > Code that is concerned about the visible part of the application. Essentially displays appliaction state 


# MODEL VIEW CONTROLER - (MVC)
- MODEL
    > Business Logic
    > State
    > HTTP Library

- CONTROLER
    > Application Logic
    - Bridge between model and views (which don't know about one another)🌁
    - handles UI events and dispatches tasks to model and view 

- VIEW
    > Presentation Logic 