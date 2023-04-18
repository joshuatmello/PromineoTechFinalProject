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
import com.promineotech.coffee.controller.model.OrdersDto;
import com.promineotech.coffee.entity.Orders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/orders")
//Add OpenAPI Definition here?? 
//@OpenAPIDefinition(info = @Info(title = "Coffee Subscription Service"),
//servers = {@Server(url = "http://localhost:8080", description = "Local server.")})
public interface OrdersController {
//@formatter:off
  
  //GETS the full order list 
  @Operation(
      summary = "Returns a list of all orders", 
      description = "Returns the list of orders",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of orders gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Orders.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No orders were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  @GetMapping("/getsAllOrders")
  @ResponseStatus(code= HttpStatus.OK)
  List<Orders> fetchAllOrders();
  
  //GETS order by customerId
  @Operation(
      summary = "Returns a list of orders by Customer Id", 
      description = "Returns the list of orders by Customer Id",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of orders gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Orders.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No orders were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }  , 
      parameters = {
          @Parameter(
              name = "Customer Id", 
              allowEmptyValue = false,
              required = false,
              description = "The customer ID to be found")
      }
      )
  @GetMapping("/getsOrderByCustomerId")
  @ResponseStatus(code= HttpStatus.OK)
  List<Orders> fetchOrderByCustomerId(String customerId);
  
    
  //POST/ CREATE new order
  @Operation(
      summary = "Creates a new order", 
      description = "Returns the created order",
      responses = {
          @ApiResponse(
              responseCode= "201", 
              description= "An order was created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Orders.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to create a new order with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
  @PostMapping("/createOrder")
  @ResponseStatus(code= HttpStatus.CREATED)
  Orders createOrder(@Valid @RequestBody OrdersDto orderDto);
  
  
  //Update/PUT an order
  @Operation(
      summary = "Updates an order", 
      description = "Returns the updated order",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "An order was updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Orders.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to update order with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
  @PutMapping("/updateOrder")
  @ResponseStatus(code= HttpStatus.OK)
Orders updateOrder(@Valid @RequestBody OrdersDto orderDto);
  
  //DELETE an order
  @Operation(
      summary = "Deletes an order", 
      description = "Deletes an order",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "An order was deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Orders.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "Unable to delete order with the given input", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          } 
      )
  @DeleteMapping("/deleteOrder")
  @ResponseStatus(code= HttpStatus.OK)
  void deleteOrder(@Valid @RequestBody OrdersDto orderDto);
  
  
//@formatter:on
} //closes interface method

