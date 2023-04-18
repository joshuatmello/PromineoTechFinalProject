package com.promineotech.coffee.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.coffee.entity.Coffee;
import com.promineotech.coffee.entity.Orders;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/coffee")
public interface CoffeeController {

//@formatter:off
  
  //GETS the full coffee list 
  @Operation(
      summary = "Returns a list of all coffees", 
      description = "Returns the list of coffees",
      responses = {
          @ApiResponse(
              responseCode= "200", 
              description= "A list of coffees gets returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Coffee.class))), 
          @ApiResponse(
              responseCode= "400", 
              description = "The parameters requested are not valid", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "404", 
              description = "No coffees were found", 
              content= @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode= "500", 
              description = "An unplanned error occurred", 
              content= @Content(mediaType = "application/json"))
          }
      )
  @GetMapping("/getsAllCoffees")
  @ResponseStatus(code= HttpStatus.OK)
  List<Coffee> fetchAllCoffees();
  
 
}
