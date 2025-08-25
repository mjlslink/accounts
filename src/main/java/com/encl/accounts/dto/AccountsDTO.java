package com.encl.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Accounts holds the customer's account details"
)
public class AccountsDTO {

    @Schema(
            description = "Account number of the customer",
            example = "1234567890",
            required = true
    )
    @NotEmpty
    @Pattern(regexp = "$|[0-9]{10}", message = "Number must have 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the customer",
            example = "SAVINGS",
            allowableValues = {"SAVINGS", "CURRENT", "FIXED"},
            required = true
    )
    @NotEmpty(message = "Account type cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Bank address",
            example = "123 Main St, Springfield",
            required = true
    )
    @NotEmpty(message = "Brnach address cannot be null or empty")
    private String branchAddress;
}
