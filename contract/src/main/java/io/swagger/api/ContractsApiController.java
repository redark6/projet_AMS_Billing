package io.swagger.api;

import io.swagger.kafka_model.ContractKafka;
import io.swagger.model.ContractActionRequest;
import io.swagger.model.ContractRequest;
import io.swagger.model.ContractResponse;
import io.swagger.model.ContractsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.producer_kafka.ProducerContract;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-10T15:26:49.987Z[GMT]")
@RestController
public class ContractsApiController implements ContractsApi {

    private static final Logger log = LoggerFactory.getLogger(ContractsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ProducerContract producerContract;

    @org.springframework.beans.factory.annotation.Autowired
    public ContractsApiController(ObjectMapper objectMapper, HttpServletRequest request, ProducerContract producerContract) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.producerContract = producerContract;
    }

    public ResponseEntity<ContractResponse> getContract(@Parameter(in = ParameterIn.PATH, description = "External identifier of the contract", required=true, schema=@Schema()) @PathVariable("contractRef") String contractRef) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ContractResponse>(objectMapper.readValue("{\n  \"ContractRequest\" : {\n    \"$ref\" : \"#/components/examples/ContractRequest\"\n  }\n}", ContractResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ContractResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ContractResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> patchContract(@Parameter(in = ParameterIn.PATH, description = "External identifier of the contract", required=true, schema=@Schema()) @PathVariable("contractRef") String contractRef,@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody ContractActionRequest body) {
        String accept = request.getHeader("Accept");
        producerContract.sendMessage(new ContractKafka("idtest", "DEFERRED_BILLING", LocalDate.now().minusDays(10).toString(), LocalDate.now().plusDays(10).toString(), "ACTIVE"));
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ContractResponse> postContract(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody ContractRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ContractResponse>(objectMapper.readValue("{\n  \"ContractRequest\" : {\n    \"$ref\" : \"#/components/examples/ContractRequest\"\n  }\n}", ContractResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ContractResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        producerContract.sendMessage(new ContractKafka(body.getProductRef().toString(), body.getContractType().toString(), body.getCreatedAt().toString(), body.getExpireAt().toString(), body.getStatus().toString()));
        return new ResponseEntity<ContractResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ContractsResponse> searchContracts(@Parameter(in = ParameterIn.QUERY, description = "External identifier of the subscriber" ,schema=@Schema()) @Valid @RequestParam(value = "subscriberRef", required = false) String subscriberRef,@Parameter(in = ParameterIn.QUERY, description = "Contract Status" ,schema=@Schema()) @Valid @RequestParam(value = "contractStatus", required = false) String contractStatus,@Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,@Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the list to be displayed" ,schema=@Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ContractsResponse>(objectMapper.readValue("{\n  \"ContractsResponse\" : {\n    \"$ref\" : \"#/components/examples/ContractsResponse\"\n  }\n}", ContractsResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ContractsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ContractsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
