/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.EligibilityResponse;
import io.swagger.model.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-14T16:39:06.461Z[GMT]")
@Validated
public interface EligibilityApi {

    @Operation(summary = "Rerieves Eligibility status", description = "Gives the status of customers with respect to the subscription. Ccontract and payment information are checked.", security = {
        @SecurityRequirement(name = "ApiKey"),
@SecurityRequirement(name = "OAuth2", scopes = {
            "read",
"write",
"admin"        })    }, tags={ "PHASE 1", "Eligibility" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "SUCCESS - Returns list of status", content = @Content(mediaType = "application/json", schema = @Schema(implementation = EligibilityResponse.class))),
        
        @ApiResponse(responseCode = "401", description = "ERROR - Not authenticated", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "403", description = "ERROR - Access token does not have the required scope", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
        
        @ApiResponse(responseCode = "500", description = "ERROR - Internal Server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @RequestMapping(value = "/eligibility/{customerRef}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<EligibilityResponse> readEligibility(@Parameter(in = ParameterIn.PATH, description = "External reference of the buyer", required=true, schema=@Schema()) @PathVariable("customerRef") String customerRef);

}

