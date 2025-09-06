Spring Boot MOnitoring Module
===========================
This module provides monitoring capabilities for the AccountsT application, allowing you to track
and visualize application metrics and health status. It leverages Spring Boot Actuator and Micrometer
to expose various endpoints and integrate with monitoring systems like Prometheus and Grafana.
Getting Started
-------------------
To use the Monitoring module, follow these steps:
1. Add the Monitoring module as a dependency in your project's build configuration (e.g., Maven or Gradle).
2. Configure the monitoring settings in the application.properties or application.yml file.
3. Enable the desired Actuator endpoints for metrics and health checks.
4. Run your application, and the monitoring endpoints will be available for tracking application metrics
   and health status.
Configuration
-------------------
The Monitoring module can be configured using the following properties in your application.properties
or application.yml file:
- management.endpoints.web.exposure.include: Specify the Actuator endpoints to expose (e.g., health,
  metrics, prometheus).
- management.endpoint.health.show-details: Define the level of detail to show in the health endpoint
  (e.g., never, when-authorized, always).
- management.metrics.export.prometheus.enabled: Enable or disable Prometheus metrics export (default: true).
- management.metrics.export.prometheus.rsocket.enabled: Enable or disable RSocket support for Prometheus
  (default: false).
- management.metrics.export.prometheus.pushgateway.enabled: Enable or disable Pushgateway support for
  Prometheus (default: false).
- management.metrics.export.prometheus.pushgateway.base-url: Specify the Pushgateway base URL for
  Prometheus (default: http://localhost:9091).
- management.metrics.export.prometheus.pushgateway.push-rate: Define the push rate for Prometheus
  (default: 10 seconds).
- management.metrics.export.prometheus.pushgateway.job: Set the job name for Prometheus Pushgateway
  (default: spring-boot-application).
Customization
-------------------
You can customize the Monitoring module by implementing your own MeterBinder to create custom metrics
specific to your application. This allows you to track additional performance indicators or business
metrics.
You can also extend the monitoring functionality by integrating with other monitoring systems, such as
New Relic, Datadog, or InfluxDB, by adding the appropriate Micrometer dependencies and configuration.
License
-------------------
This project is licensed under the MIT License. See the LICENSE file for details.