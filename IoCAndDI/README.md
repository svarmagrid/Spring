# Spring Core Concepts

## 1. What is ApplicationContext?

ApplicationContext is the central interface in Spring for managing the lifecycle and configuration of application components (beans).

### Key Responsibilities:

* Creates and manages beans
* Handles Dependency Injection (DI)
* Supports configuration via annotations, XML, or Java config
* Provides features like:
    * Bean scopes (singleton, prototype, etc.)
    * Internationalization (i18n)
    * Event propagation
    * AOP integration

### In Simple Terms:

 It is the Spring container that holds and manages all your objects (beans).

---

## 2. Tradeoffs of Different Bean Injection Approaches

###  Constructor Injection (Recommended)

```java
public class Service {
    private final Dependency dep;

    public Service(Dependency dep) {
        this.dep = dep;
    }
}
```

**Pros:**

* Ensures immutability
* Mandatory dependencies are enforced
* Easier unit testing
* No risk of partially initialized objects

**Cons:**

* Can become verbose with many dependencies

---

###  Setter Injection

```java
public void setDependency(Dependency dep) {
    this.dep = dep;
}
```

**Pros:**

* Good for optional dependencies
* More flexible

**Cons:**

* Object can exist in incomplete state
* Harder to reason about required dependencies

---

###  Field Injection

```java
@Autowired
private Dependency dep;
```

**Pros:**

* Less boilerplate
* Quick to write

**Cons:**

* Hard to test (requires reflection)
* Breaks encapsulation
* Not recommended for production code

---

###  Summary

| Approach    | Recommended | Use Case               |
| ----------- | --------- | ---------------------- |
| Constructor |  Yes      | Mandatory dependencies |
| Setter      |  Sometimes | Optional dependencies  |
| Field       |  No       | Avoid                  |

---

## 3. Why Use `@Qualifier`?

When multiple beans of the same type exist, Spring gets confused:

```java
@Autowired
private Foo foo; //  Which Foo?
```

Example:

* `FooImplA`
* `FooImplB`

 Spring throws `NoUniqueBeanDefinitionException`

### Solution: Use `@Qualifier`

```java
@Autowired
@Qualifier("fooA")
private Foo foo;
```

### Alternative: `@Primary`

```java
@Primary
@Component
public class FooImplB implements Foo {}
```

 If no qualifier is specified, Spring injects the `@Primary` bean.

### Summary:

* `@Qualifier` → Explicit selection
* `@Primary` → Default fallback

---

## 4. Avoid Loading Heavy Beans at Startup

Heavy beans (e.g., caches, external connections) slow down startup.

###  Use `@Lazy`

```java
@Lazy
@Component
public class HeavyService {}
```

Or at injection point:

```java
public Service(@Lazy HeavyService heavyService) { }
```

 Bean is created **only when first used**

---

###  Use `@PostConstruct` Carefully

Avoid heavy logic inside:

```java
@PostConstruct
public void init() {
    // slows startup
}
```

---

###  Use Async Initialization

```java
@Async
@PostConstruct
public void initAsync() { }
```

 Runs in background

---

###  Best Practice:

* Use `@Lazy` for rarely used beans
* Avoid heavy work during startup
* Defer initialization where possible

---

## 5. Spring Bean Lifecycle

###  Lifecycle Stages

1. **Bean Instantiation**

    * Object is created

2. **Dependency Injection**

    * Dependencies are injected

3. **Aware Interfaces (Optional)**

    * `BeanNameAware`
    * `ApplicationContextAware`

4. **Pre-Initialization**

    * `BeanPostProcessor #postProcessBeforeInitialization`

5. **Initialization**

    * `@PostConstruct`
    * `InitializingBean #afterPropertiesSet()`
    * Custom `initMethod`

6. **Post-Initialization**

    * `BeanPostProcessor#postProcessAfterInitialization`

7. **Bean Ready for Use**

---

### Destruction Phase

Triggered when context is closed:

* `@PreDestroy`
* `DisposableBean#destroy()`
* Custom `destroyMethod`

---

###  Lifecycle Flow Summary

```
Instantiate → Inject → Aware → PreProcess →
@PostConstruct → Ready → Destroy (@PreDestroy)
```

---

##  Final Notes

* `ApplicationContext` = Spring container
* Prefer constructor injection
* Use `@Qualifier` when multiple beans exist
* Use `@Lazy` to improve startup performance
* Understand lifecycle for advanced control

---
