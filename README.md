# Spring-Framework-EventHandling
Spring Framework Event Handling
**📌 Overview**

Spring Framework provides a powerful event handling mechanism that allows beans to communicate with each other in a loosely coupled way.
An event in Spring is an object that represents something happening inside the application (such as context start, stop, refresh, or close).

**Spring provides:**

**Built-in events (context lifecycle events).

User-defined (custom) events.
**
This project demonstrates both.

**⚙️ Project Structure**

App.xml → Spring configuration file that registers beans and event listeners.

CStartEventHandler.java → Handles context start events.

CStopEventHandler.java → Handles context stop events.

MyApp.java → Main class that loads Spring context and triggers events.

**🏗️ Built-in Spring Context Events**

Spring provides several predefined events that are automatically published during the application lifecycle.

**1. ContextStartedEvent**

Type: Class (extends ApplicationContextEvent)

When triggered: When the context is explicitly started using context.start().

Usage: Perform initialization tasks when the application starts.

Example listener:

public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Context Started Event received");
    }
}

**2. ContextRefreshedEvent**

Type: Class

When triggered: When the context is refreshed (loaded or reloaded).

Usage: Initialize or reinitialize beans, reload configuration.

**3. ContextStoppedEvent**

Type: Class

When triggered: When the context is explicitly stopped using context.stop().

Usage: Release resources, perform cleanup tasks.

Example listener:

public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("Context Stopped Event received");
    }
}

**4. ContextClosedEvent**

Type: Class

When triggered: When the context is closed using context.close().

Usage: Free up resources (like DB connections, threads) before application shutdown.

**🛠️ User-Defined Custom Events**

Apart from built-in events, developers can define their own events.

**Steps:**

Create a custom event class extending ApplicationEvent.

public class CustomEvent extends ApplicationEvent {
    public CustomEvent(Object source) {
        super(source);
    }
    @Override
    public String toString() {
        return "This is a custom event!";
    }
}


Create an event publisher that publishes this event.

@Component
public class CustomEventPublisher {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void publish() {
        CustomEvent event = new CustomEvent(this);
        publisher.publishEvent(event);
    }
}


Create a listener for the custom event.

public class CustomEventHandler implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(event.toString());
    }
}

**🚀 Running the Application**

Load the Spring context from App.xml in MyApp.java.

Start, stop, or close the context:

ConfigurableApplicationContext context =
        new ClassPathXmlApplicationContext("App.xml");

context.start();   // Triggers ContextStartedEvent
context.stop();    // Triggers ContextStoppedEvent
context.close();   // Triggers ContextClosedEvent


For custom events, call the publisher to dispatch your own event.

1. @AutoWired-> It injects the field automatically.
2. @Repository-> This bean contains the data for buisness logic.
3. @Service-> This bean contains the buisness logic.

**📖 Conclusion**

Spring’s event handling system allows loose coupling between components.

Built-in context events help in managing application lifecycle.

Custom events allow developers to create domain-specific notifications.

This makes applications more modular, maintainable, and scalable.
