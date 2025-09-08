package com.encl.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "CustomerDetails",
        description = "Schema to hold CustomerDetails information"
)
@Data
public class CustomerDetailsDto {


    @Schema(
            description = "The name of the Customer",
            required = true

    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the name must be between 5 and 30 characters.")
    private String name;

    @Schema(
            description = "The email of the Customer",
            required = true
    )
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address must be a valid value")
    private String email;


    @Schema(
            description = "Customer's phone number"
    )
    @Pattern(regexp = "$|[0-9]{10}", message = "Number must have 10 digits")
    private String mobileNumber;


    @Schema(
            description = "Customer's account details"
    )
    private AccountsDTO accountsDTO;

    @Schema(
            description = "Customer's account details"
    )
    private LoansDto loansDto;

    @Schema(
            description = "Customer's account details"
    )
    private CardsDto cardsDto;


}
