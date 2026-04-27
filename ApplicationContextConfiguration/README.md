# Spring Framework – Core Concepts

## 1. What is the difference between the `@Configuration`, `@Component`, and `@Service` annotations?

* `@Component`
  A generic stereotype annotation used to declare a Spring-managed bean. It is typically used for classes that do not belong to a specific layer.

* `@Service`
  A specialization of `@Component` that represents the service layer. It is used to define business logic and improves code readability by indicating intent.

* `@Configuration`
  Used to define configuration classes in Spring. These classes contain methods annotated with `@Bean` to explicitly declare and manage beans within the Spring container.

---

## 2. How can we customize the component scanning process?

Component scanning can be customized using the `@ComponentScan` annotation.

```java
@ComponentScan(
    basePackages = "com.example.app",
    includeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Service.class
    ),
    excludeFilters = @ComponentScan.Filter(
        type = FilterType.ANNOTATION,
        classes = Repository.class
    ),
    useDefaultFilters = false
)
```

Key options:

* `basePackages` specifies where Spring should scan for components.
* `includeFilters` allows inclusion of specific classes or annotations.
* `excludeFilters` allows exclusion of certain components.
* `useDefaultFilters` disables default scanning behavior when set to false.

---

## 3. What value will a property have if it is defined in two different profiles both of which are active?

If the same property is defined in multiple active profiles, the value from the profile that is loaded last takes precedence. The order depends on how profiles are activated (e.g., via configuration, environment variables, or command-line arguments).

---

## 4. Why would we use factory beans instead of regular beans?

Factory beans (`FactoryBean<T>`) are used when the object creation process is complex or requires custom logic. They are useful when:

* The instantiation logic is complicated.
* Objects need to be created dynamically.
* Integration with external systems is required.
* Proxies or special objects need to be generated.

Spring exposes the object created by the factory bean, not the factory bean itself.

---

## 5. How can we override any property defined in any `.properties` file?

Properties can be overridden based on a defined precedence order. Higher-priority sources override lower ones.

Order of precedence:

1. Command-line arguments
2. Environment variables
3. `application-{profile}.properties`
4. `application.properties`

Example:

```bash
java -jar app.jar --server.port=9090
```

This command overrides the `server.port` defined in any properties file.

---

## 6. Does `@PreDestroy` get called for a prototype scope bean?

No, `@PreDestroy` is not called for prototype-scoped beans.

Spring only manages the creation and dependency injection of prototype beans. After that, the container does not manage their lifecycle, so destruction callbacks such as `@PreDestroy` are not executed. Developers must handle cleanup manually if needed.

---
