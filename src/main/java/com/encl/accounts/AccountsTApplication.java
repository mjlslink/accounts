package com.encl.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {com.encl.accounts.dto.AccountsContactInfoDto.class})
@EnableFeignClients
@OpenAPIDefinition(
        info = @Info(title = "Accounts REST Service API Documentation",
        description = "Microservice documentation",
        version = "v1",
        contact = @Contact(name = "Michael Larsen", email = "", url=""),
                license = @License(name="Aoache 2.0", url="")

        )

)
public class AccountsTApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsTApplication.class, args);
	}

}
