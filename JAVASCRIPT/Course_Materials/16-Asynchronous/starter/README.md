# SYNCHRONOUS Javascript
    
-  Code is run/executed line by line

- Each line waits for the previous line to finish 

- Long running operations block the code form executions


# ASYNCHRONOUS Javascript
    setTimout(()=> {p.textContent = 'My name is asynchronous'}, 5000)

- Code is executed after a task that runs in the 'background' finishes.

- asynchronous code is **non-blocking**

- Execution doesn't wait for an asynchronous task to finish work

- Coordinating behavior of a program over a period of time. 

- Callback functions does not automatically make a code asynchronous! *you have to know which one do (e.g. setTimeout(), src attribute) and which one does not (e.g. map())

- EventListners does NOT make automatically make code asynchronous 


## AJAX Calls 
    Asynchronous Javascript And XML: 
    It allows us to communicate with remote servers in an asynchronous way. With AJAX calls, we can request data from web servers dynamically.


