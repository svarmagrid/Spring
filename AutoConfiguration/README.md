# Spring Boot Configuration and Auto-Configuration – Q&A

## 1. What is the difference between regular configuration and auto-configuration?

**Regular Configuration:**

* Defined explicitly by the developer using `@Configuration` classes.
* Beans are manually declared using `@Bean` methods.
* Provides full control over application setup.
* Requires the developer to know what components need to be configured.

**Auto-Configuration:**

* Provided by Spring Boot to automatically configure beans based on classpath dependencies, properties, and environment.
* Enabled using `@EnableAutoConfiguration` (implicitly included in `@SpringBootApplication`).
* Reduces boilerplate configuration.
* Uses conditional annotations to decide whether to configure a bean or not.

**Key Difference:**
Regular configuration is manual and explicit, while auto-configuration is automatic and conditional, based on the application's context.

---

## 2. Would all conditional annotations on bean definitions work in regular configuration classes? Elaborate.

Yes, conditional annotations can also be used in regular configuration classes.

**Explanation:**

* Spring provides several conditional annotations such as:

    * `@Conditional`
    * `@ConditionalOnClass`
    * `@ConditionalOnMissingBean`
    * `@ConditionalOnProperty`
* These annotations are not limited to auto-configuration; they work in any `@Configuration` class.

**However:**

* They are more commonly used in auto-configuration classes because those classes are designed to adapt dynamically.
* In regular configuration, developers usually define beans explicitly, so conditional logic is less frequently required.

**Conclusion:**
All conditional annotations will work in regular configuration classes, but their primary use case is in auto-configuration scenarios.

---

## 3. How can we customize the auto-configuration process?

Auto-configuration can be customized in several ways:

1. **Excluding Auto-Configuration Classes:**

    * Use:

        * `@SpringBootApplication(exclude = {ClassName.class})`
        * or `spring.autoconfigure.exclude` in `application.properties`

2. **Overriding Beans:**

    * Define your own `@Bean` of the same type.
    * Use `@Primary` or bean naming to take precedence.

3. **Using Properties:**

    * Configure behavior via `application.properties` or `application.yml`.

4. **Conditional Custom Beans:**

    * Use `@ConditionalOnMissingBean` to define beans only when not already present.

5. **Custom Auto-Configuration:**

    * Create your own auto-configuration class.
    * Register it using `spring.factories` (Spring Boot 2) or `AutoConfiguration.imports` (Spring Boot 3).

---

## 4. What is the condition that causes a Tomcat server to start on port 8080 when the application starts?

The embedded Tomcat server starts on port 8080 when the following conditions are met:

1. **Spring Web Dependency Present:**

    * The application includes `spring-boot-starter-web` (or similar), which brings in Tomcat.

2. **No Explicit Server Configuration:**

    * No custom server is defined.
    * No override of `server.port` property.

3. **Auto-Configuration Triggered:**

    * `SpringBootApplication` enables auto-configuration.
    * `EmbeddedServletContainerAutoConfiguration` (or its modern equivalent) configures Tomcat.

4. **Default Port Setting:**

    * If `server.port` is not set, Spring Boot defaults to port **8080**.

---

## Summary

* Regular configuration is manual; auto-configuration is automatic and conditional.
* Conditional annotations work in both, but are mainly used in auto-configuration.
* Auto-configuration can be customized through exclusions, overrides, and properties.
* Tomcat runs on port 8080 by default when web dependencies are present and no custom port is specified.
