# BeanCreationEasyWay

This project is a Spring learning workspace that demonstrates multiple ways to create, wire, scope, and register beans using Java-based configuration.

## Tech Stack

- Java 10
- Maven
- Spring Context 7.0.0
- Jakarta Annotations

## What Is Implemented

### 1. Basic Bean Creation with Component Scanning
Package: `org.example.ex1`

Implemented concepts:
- `@Configuration` with `@ComponentScan`
- `@Component` bean discovery
- Bean lifecycle callbacks
- Bean destruction callback

Details:
- `Vehicle` is registered as a Spring bean using `@Component`
- `ProjectConfig` scans the `beans` package
- Bean initialization is demonstrated with `InitializingBean#afterPropertiesSet()`
- `@PostConstruct` is also shown in comments as an alternative approach
- Bean cleanup is demonstrated with `@PreDestroy`
- `App` loads the context, reads the bean, and invokes a method on it

### 2. Manual Bean Wiring with `@Bean`
Package: `org.example.ManualWiring`

Implemented concepts:
- Explicit bean creation using `@Bean`
- Dependency wiring in configuration
- Java configuration instead of component scanning

Details:
- `Vehicle` and `Person` are created manually in `ProjectConfig`
- `Person` depends on `Vehicle`
- Two manual wiring styles are shown:
- direct method call
- method parameter injection
- The active implementation uses method parameter injection, which lets Spring resolve the dependency cleanly
- `Main` retrieves both beans and prints their values

### 3. Autowiring Dependencies
Package: `org.example.AutoWiring`

Implemented concepts:
- Automatic dependency injection
- Constructor injection
- Field injection and setter injection examples
- `@PostConstruct` initialization

Details:
- `Car` and `Engine` are discovered using component scanning
- `Car` depends on `Engine`
- Constructor injection is the active implementation and marked as preferred
- Field injection and setter injection are included in comments for comparison
- `Car` and `Engine` both initialize internal state after creation
- `Main` shows that Spring injects the `Engine` bean into `Car`

### 4. Bean Scope and Lazy Initialization
Package: `org.example.ScopeOfBean`

Implemented concepts:
- Singleton scope
- Prototype scope
- Lazy bean creation

Details:
- `MyService` is marked as `@Scope("singleton")`
- `MyService` is also marked `@Lazy`, so it is created only when first requested
- `UserSession` is marked as `@Scope("prototype")`
- Each `UserSession` instance generates a unique `sessionId`
- `Main` requests multiple beans and prints hash codes to show the difference between singleton and prototype behavior

### 5. Dynamic Bean Registration
Package: `org.example.DynamicBeanRegistration`

Implemented concepts:
- Programmatic bean registration
- Conditional registration at startup
- Custom `BeanRegistrar`
- Supplier-based bean creation

Details:
- `ProjectConfig` imports `MyBeanRegistrar`
- `MyBeanRegistrar` implements `BeanRegistrar`
- At startup, a random number is generated
- If the number is even:
- an `Engine` bean is registered
- a `Vehicle` bean is registered and wired with `Engine`
- If the number is odd:
- a `Bike` bean is registered
- `Main` checks bean availability with `context.containsBean(...)` before accessing them

This module demonstrates dynamic container behavior rather than fixed annotation-based registration.

## Key Spring Concepts Covered

- Component scanning
- Stereotype annotations
- Java-based configuration
- Manual bean creation with `@Bean`
- Constructor-based dependency injection
- Bean lifecycle methods
- Bean scopes: singleton and prototype
- Lazy initialization
- Dynamic bean registration
- Conditional access to registered beans

## Learning Outcome

This project shows the progression from basic annotation-based bean creation to manual wiring, autowiring, scope management, and fully dynamic bean registration in Spring.
