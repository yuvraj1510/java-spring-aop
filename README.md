# java-spring-aop
* Programming technique based on concept of an Aspect.
* An aspect encapsulate cross-cutting logic - "Cross-Cutting Concerns".
* "Concern" means logic/functionality - like logging, security.
* Apply the Proxy design pattern.

## Aspects
* Aspect can be reused at multiple locations.
* Same aspect/class can be applied on any class based on configuration.

## Benefits
* **Code for Aspect is defined in a single class**
    * Much better than being scattered everywhere.
    * Promoted code reuse and easier to change.
* **Business code in the application is cleaner**
    * Only applied to business functionality.
    * Reduces code complexity.
* **Configurable**
    * Based on configuration, apply Aspects selectively to different parts of the application.
    * No need to make changes to main application code.

## Use Cases
* **Most common**
    * logging, security, transactions
* **Audit logging**
    * who, what, when, where
* **Exception handling**
    * log exception and notify DevOps team via SMS/Email
* **API Management**
    * how many times has a method been called by user.
    * analytics: what are peak times? what is average load? who is top user?

## Advantages
* Reusable modules
* Resolve code tangling
* Resolve code scatter
* Applied selectively based on configuration

## Disadvantages
* Too many aspects and app flow is hard to follow
* Minor performance cost for aspect execution (run-time weaving)

## AOP Terminology
* **Aspect:** module of code for a cross-cutting concern (logging, security etc)
* **Advice:** What action is taken and when it should be applied
    * **Before advice:** run before method
        * [Example](src/main/java/com/ysingh/springaop/aspect/LoggingAspect.java)
    * **After finally advice:** run after the method (finally)
    * **After returning advice:** run after the method (success execution)
    * **After throwing advice:** run after the method (if exception thrown)
    * **Around advice:** run before and after the method
* **Joint Point:** When to apply code during program execution
* **Pointcut:** A predicate expression for where advice should be applied
    * **Expression Language:** execution(modifiers? return-type declaring-type? method-name(param) throws?)
        * ? - They are optional and we can skip if we don't need them.
        * **For Param:**
            * **()** - matches a method with no arguments
            * **(*)** - matches a method with one argument of any return type
            * **(..)** - matches a method with 0 or more arguments of any return type
        * **Example - Match on method names:**
            * Match only addAccount method in AccountDAO class
            ```java
            @Before("execution(public void com.ysingh.springaop.dao.AccountDAO.addAccount())")
            ```
            * Match only addAccount method in any class
            ```java
            @Before("execution(public void addAccount())")
            ```
            * Match methods starting with add in any class
            ```java
            @Before("execution(public void add*())")
            ```
        * **Example - Match on return type:**
            * Match any return type
            ```java
            @Before("execution(public * add*())")
            ```   
        * [Example](src/main/java/com/ysingh/springaop/aspect/LoggingAspect.java)
    * **Declaration**
        * **Benefit**
            * Easily reuse the pointcut expressions
            * Update pointcut in one location
            * Can also share and combine the pointcut expressions 
        * **Example**
            * Match DAO Package
            ```java
            @Pointcut("execution(* com.ysingh.springaop.dao.*.*(..))")
            private void forDaoPackage() {}
            ```
        * [Example](src/main/java/com/ysingh/springaop/aspect/DeclarativeLoggingAspect.java.java)

## Comparing Spring AOP and AspectJ
* Spring AOP only supports
    * Method-level joint points
    * Run-time code weaving (slower than AspectJ)
* AspectJ supports
    * joint points: method-level, constructor, field
    * weaving: compile-time, post compile-time and load-time




