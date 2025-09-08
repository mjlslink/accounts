Spring Boot Eureka
===========================
This module provides service discovery capabilities for the AccountsT application using Spring Cloud
Eureka. It allows microservices to register themselves with a Eureka server and discover other services
dynamically.
Getting Started
-------------------
To use the Eureka module, follow these steps:
1. Add the Eureka module as a dependency in your project's build configuration (e.g., Maven or Gradle).
2. Configure the Eureka server URL and other properties in the application.properties or application.yml file.
3. Annotate your main application class with @EnableEurekaClient to enable Eureka client functionality.
4. Run your application, and it will register itself with the Eureka server and be able to discover other services.
Configuration
-------------------
The Eureka module can be configured using the following properties in your application.properties or
application.yml file:
- eureka.client.service-url.defaultZone: Specify the URL of the Eureka server for service registration
  and discovery (e.g., http://localhost:8761/eureka/).
- eureka.instance.hostname: Define the hostname of the service instance (default: localhost).
- eureka.instance.prefer-ip-address: Use the IP address instead of the hostname for service
  registration (default: false).
- eureka.instance.lease-renewal-interval-in-seconds: Set the interval for renewing the service lease
  with the Eureka server (default: 30 seconds).
- eureka.instance.lease-expiration-duration-in-seconds: Define the duration after which the service
  instance is considered expired if it fails to renew its lease (default: 90 seconds).
Customization
-------------------
You can customize the Eureka module by implementing your own InstanceInfoTransformer to modify the
service instance information before registration. This allows you to add custom metadata or change the
instance ID.
You can also extend the Eureka functionality by integrating with other Spring Cloud components, such as
Spring Cloud Config for centralized configuration management or Spring Cloud LoadBalancer for client-side
load balancing.
License
-------------------
This project is licensed under the MIT License. See the LICENSE file for details.   