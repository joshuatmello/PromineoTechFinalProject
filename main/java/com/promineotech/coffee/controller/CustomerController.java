package com.promineotech.coffee.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.coffee.controller.model.CustomerDto;
import com.promineotech.coffee.entity.Customer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/customer")
//Add OpenAPI Definition here?? 
@OpenAPIDefinition(info = @Info(title = "Coffee Subscription Service"),
servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface CustomerController {
//@formatter:off
  
  //GETS the full customer list 
  @Operation(
      summary = "Returns a list of all customers", 
      description = "Returns the list of customers",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of customers gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No customers were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  @GetMapping("/getsAllCustomers")
  @ResponseStatus(code= HttpStatus.OK)
  List<Customer> fetchAllCustomer();
  
  //GETS customer by last name 
  @Operation(
      summary = "Returns a list of customers by last name", 
      description = "Returns the list of customers",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of customers gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No customers were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  , 
      parameters = {
          @Parameter(
              name = "customerLastName", 
              allowEmptyValue = false,
              required = false,
              description = "The customer last name to be found")
      }
      )
  @GetMapping("/getsCustomerByLastName")
  @ResponseStatus(code= HttpStatus.OK)
  List<Customer> fetchCustomerByLastName(String customerLastName);
  
    
  //POST/ CREATE new customer
  @Operation(
      summary = "Creates a new customer", 
      description = "Returns the created customer",
      responses = {
          @ApiResponse(
              responseCode= "201", 
              description= "A customer was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to create a new customer with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } //, 
//      parameters = {
//          @Parameter(
//              name = "firstName", //should this name match the SQL database??? first_name
//              allowEmptyValue= false, 
//              required = true, 
//              description = "The customer first name"), 
//          @Parameter(
//              name = "lastName", //SQL database last_name
//              allowEmptyValue = false, 
//              required = true, 
//              description = "The customer last name"),
//          @Parameter(
//              name = "phoneNumber", //SQL database phone_number
//              allowEmptyValue = false, 
//              required = true, 
//              description = "The customer phone number"
//              )
//      }
      )
  @PostMapping("/createCustomer")
  @ResponseStatus(code= HttpStatus.CREATED)
  //????Does this method still work give the parameters above????
  Customer createCustomer(@Valid @RequestBody CustomerDto customerDto);
  //Customer createCustomer(String firstName, String lastName, String phoneNumber);
  
  
  //Update/PUT a customer
  @Operation(
      summary = "Updates a customer", 
      description = "Returns the updated customer",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A customer was updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to update customer with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
//      , 
//      parameters = {
//          @Parameter(
//              name = "customerId", //should this name match the SQL database??? customer_id
//              allowEmptyValue = false,
//              required = true,
//              description = "The customer's ID in the database"
//              )
//      }
      )
  @PutMapping("/updateCustomer")
  @ResponseStatus(code= HttpStatus.OK)
Customer updateCustomer(@Valid @RequestBody CustomerDto customerDto);
//  Customer updateCustomer(int customerId, Customer updatedCustomer);
  
  //DELETE a customer
  @Operation(
      summary = "Deletes a customer", 
      description = "Deletes a customer",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A customer was deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Customer.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to delete customer with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } //, 
//    parameters = {
//    @Parameter(
//        name = "customerId", //should this name match the SQL database??? customer_id
//        allowEmptyValue = false,
//        required = true,
//        description = "The customer's ID within the database"
//        )
//}
      )
  @DeleteMapping("/deleteCustomer")
  @ResponseStatus(code= HttpStatus.OK)
  void deleteCustomer(@Valid @RequestBody CustomerDto customerDto);
// void deleteCustomer(int customerId);
  
  
  
  
//@formatter:on
} //closes interface method
