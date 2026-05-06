# Spring Boot Testing – Quick README

## 1. Configuring Application Context with `@SpringBootTest`

When using `@SpringBootTest`, you can configure the application context in several ways:

### a. Specify Configuration Classes

```java
@SpringBootTest(classes = MyTestConfig.class)
```

### b. Use Properties

```java
@SpringBootTest(properties = {
    "app.feature.enabled=true",
    "spring.datasource.url=jdbc:h2:mem:testdb"
})
```

### c. Use Profiles

```java
@ActiveProfiles("test")
@SpringBootTest
```

### d. Web Environment Configuration

```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
```

### e. Override Beans / Add Test Configuration

```java
@TestConfiguration
static class TestConfig {
    @Bean
    public MyService myService() {
        return new MockMyService();
    }
}
```

---

## 2. Excluding Auto-Configuration in Tests

You can exclude auto-configurations in multiple ways:

### a. Using `exclude` in `@SpringBootTest`

```java
@SpringBootTest(exclude = {DataSourceAutoConfiguration.class})
```

### b. Using `@EnableAutoConfiguration`

```java
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
```

### c. Using Properties

```java
@SpringBootTest(properties = {
    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration"
})
```

---

## 3. Application Context Caching

### Default Behavior

* Maximum cached contexts: 32
* Uses Least Recently Used (LRU) eviction policy

### Increasing Cache Size

You can configure:

```bash
-Dspring.test.context.cache.maxSize=64
```

### Side Effects of Increasing Cache Size

* Fewer context reloads, improving performance
* Higher memory consumption
* More open resources such as database connections and threads
* Longer JVM shutdown time due to more contexts being closed

### Side Effects If There Was No Caching

* Very slow test execution
* Repeated context initialization overhead
* Increased CPU and resource usage
* Reduced developer productivity

---

## 4. Using `@MockBean` Without Existing Bean

Yes, `@MockBean` can be used even if the bean is not already defined in the application context.

### Behavior:

* If the bean exists, it is replaced with a mock
* If the bean does not exist, a new mock bean is added to the context

### Example:

```java
@MockBean
private ExternalService externalService;
```

This works even if `ExternalService` is not defined elsewhere.

---

## Summary

* `@SpringBootTest` allows flexible context configuration via classes, properties, and profiles
* Auto-configurations can be excluded using annotations or properties
* Context caching improves performance but requires careful management
* `@MockBean` can both override existing beans and create new ones when needed

---
