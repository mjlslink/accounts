package com.encl.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Response",
        description = "Response holds the status code and message for the API response"
)
@Data @AllArgsConstructor @NoArgsConstructor
public class ResponseDTO {
    @Schema(
            description = "Status code of the API response",
            example = "200",
            required = true
    )
    private String statusCode;

    @Schema(
            description = "Status message of the API response",
            example = "Success",
            required = true
    )
    private String statusMsg;
}
