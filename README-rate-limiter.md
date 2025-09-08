Spring Boot Rate Limiter Module
==================================
This module provides rate limiting capabilities for the AccountsT application, allowing you to control
the number of requests made to your services within a specified time frame. It leverages Spring Cloud
Gateway's built-in rate limiting features to help protect your application from excessive traffic and
potential abuse.
Getting Started
-------------------
To use the Rate Limiter module, follow these steps:
1. Add the Rate Limiter module as a dependency in your project's build configuration (e.g., Maven or Gradle).
2. Configure the rate limiting settings in the application.properties or application.yml file.
3. Define the routes that require rate limiting in the gateway configuration.
4. Run your application, and the rate limiting will be applied to the specified routes.
Configuration
-------------------
The Rate Limiter module can be configured using the following properties in your application.properties
or application.yml file:
- spring.cloud.gateway.routes: Define the routes for the gateway, including the path, destination URI,
  and any filters or predicates to apply.
- spring.cloud.gateway.default-filters: Specify default filters to apply to all routes (e.g., 
  authentication, rate limiting).
- spring.cloud.gateway.filter.request-rate-limiter.enabled: Enable or disable the rate limiting filter
  (default: true).
- spring.cloud.gateway.filter.request-rate-limiter.redis.enabled: Enable or disable Redis-based rate
  limiting (default: false).
- spring.cloud.gateway.filter.request-rate-limiter.redis.host: Specify the Redis server host for
  rate limiting (default: localhost).
- spring.cloud.gateway.filter.request-rate-limiter.redis.port: Specify the Redis server port for
  rate limiting (default: 6379).
- spring.cloud.gateway.filter.request-rate-limiter.redis.password: Specify the Redis server password
  for rate limiting (default: null).
- spring.cloud.gateway.filter.request-rate-limiter.redis.database: Specify the Redis database index
  for rate limiting (default: 0).
- spring.cloud.gateway.filter.request-rate-limiter.redis.key-prefix: Define a prefix for the Redis
  keys used for rate limiting (default: "gateway:ratelimiter").
- spring.cloud.gateway.filter.request-rate-limiter.redis.replenish-rate: Set the number of requests
  allowed per second (default: 10).
- spring.cloud.gateway.filter.request-rate-limiter.redis.burst-capacity: Define the maximum burst
  capacity for rate limiting (default: 20).
Customization
-------------------
You can customize the Rate Limiter module by implementing your own KeyResolver to define how requests
are identified for rate limiting. This allows you to apply different rate limits based on user, IP
address, or other criteria.
You can also extend the rate limiting functionality by integrating with other Spring Cloud components,
such as Spring Cloud Security for authentication and authorization, or Spring Cloud Sleuth for
distributed tracing.
License
-------------------
This project is licensed under the MIT License. See the LICENSE file for details.