package com.promineotech.coffee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.coffee.entity.Coffee;
import com.promineotech.coffee.service.CoffeeService;

@RestController
public class DefaultCoffeeController implements CoffeeController {

  @Autowired
  private CoffeeService coffeeService;
  
  //GET all coffees
  @Override
  public List<Coffee> fetchAllCoffees() {
    return coffeeService.fetchAllCoffees();
  }

}
