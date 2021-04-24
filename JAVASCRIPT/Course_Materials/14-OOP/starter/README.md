# OOP -- WHAT IS OBJECT-ORIENTED PROGRAMMING - JavaScript (JS)

**Definition:**

> This is a programming paradigm based on the concepts of objects -- We use objects to _Model_ / _Describe_ real-world or abstract features;

**Point-1:** Objects may contain data(properties and code (methods)). By using objects, we pack **_data and the correspond behavior_** into one block;

**Point-2:** In OOP, objects are _Self-Contained_ pieces/blocks of code:

**Point-3:** Objects are _building blocks_ of applications, and interact with one another

**Point-4:** Interactions happen through a **Public Interface (API)** methods that the code **outside** of the object can access and use to communicate with the object

#### Why does OOP exist ?

**Answer:** OOP was developed with the goal of organizing code, to make it **more flexible and easier to maintain** (avoid "spaghetti code");

# CLASSES & INSTANCES

**Class:**

> A blueprint from which we can create _new objects_ / not yet a real object to be used. However, it can be used to create multiple instances that are readily available to be used.

**Instance:** All objects created though a _class_ / a real object which can be used

### How do we model a real case into classes ?

This is not a single straightforward answer to this. However we thus have **4** Fundamental principles to guide us create good classes:

### Fundamental ==> 1: ABSTRACTION

- **Abstraction:** Ignoring or hiding details that _don't matter_, allowing us to get an _overview_ perspective of the thing we're implementing, instead of messing with details that don't really matter to our implementation

### Fundamental ==> 2: ENCAPSULATION

- **Encapsulation:** Keeping properties and methods _private_ inside the class, so that they are **not accessible from outside the class**. SOme methods can be **exposed** as public interface (API).
  **WHY** Prevent external _code_/_users_ from accidentally manipulating the internal state/properties.

### Fundamental ==> 3: INHERITANCE

- **Inheritance:** Making all properties and methods of a certain class **available to a child class**, forming a hierarchical relationship between classes. This allows us to **reuse common logic** and to model real-world relationships.

### Fundamental ==> 4: POLYMORPHISM

- **Polymorphism:** A child class can **overwrite** a method it inherited from a parent class [it's more complex than that, but this is enough coming a Java]

# PROTOTYPES

**Instantiation:** Objects (instances) are instantiated from a class, which functions like a blueprint

> Objects are **linked** to a prototype object ==> **Prototypal Inheritance:** The prototype contains methods (behavior) _that are accessible to all objects linked to that prototype_

**Creating and Linking Objects to Prototypes -- Create new objects without having classes**

- **Constructor Functions:**

  - Creates objects from functions
  - Thi sis how built-in objects like Arrays, Maps or Sets are actually implemented

- **ES6 Classes:**
  - Modern alternative to constructor functions syntax;
  - "Syntactic sugar": behind the scenes, ES6 classes works _exactly_ like constructor functions;
  - They do **NOT** behave like classes in "classical OOP" (last lecture).
- **Object.create()**

  - this is the easiest and most straightforward way of linking an object to a prototype object.

  ####POINTS TO NOT

  - Arrow function will not work as a function constructor bcos it does not have its own **THIS** keyword
  - Never create a method inside a constructor function - if not, every instance will be carrying around this method with this as soon as they are created

  ##### What Happens when a new Constructor is created

  1.  New {} is created
  2.  function is called, this = {}
  3.  {} linked to a prototype
  4.  function automatically returns the {} from the beginning
