		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

Apring boot actuator provides production-ready features to help you monitor and manage your application. 
It includes endpoints for health checks, metrics, and other useful information about the application's 
state.

Readiness:
The readiness probe checks if the application is ready to handle requests. It uses the /actuator/health endpoint
to determine if the application is healthy. If the health status is "UP", the application is considered ready.
This is useful for load balancers to know when to start sending traffic to the application.

Liveness:
The liveness probe checks if the application is still running. It also uses the /actuator/health endpoint. If the health status is "UP", 
the application is considered alive. If the application is not alive, Kubernetes will restart the container.
To enable these probes, you need to add the following configuration to your application.properties or application.yml file:
    management.endpoint.health.probes.enabled=true
    management.health.probes.enabled=true

You can also customize the endpoints used for the probes by setting the following properties:
    management.endpoint.health.readiness-path=/actuator/health/readiness
    management.endpoint.health.liveness-path=/actuator/health/liveness

Once you have added the actuator dependency and configured the probes, you can deploy your application to Kubernetes
and add the readiness and liveness probes to your deployment configuration.

Here is an example of how to add the probes to your deployment.yaml file:
readinessProbe:
  httpGet:
    