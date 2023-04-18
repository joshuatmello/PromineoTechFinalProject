package com.promineotech.coffee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.coffee.entity.CoffeeOrders;
import com.promineotech.coffee.service.CoffeeOrdersService;

@RestController
public class DefaultCoffeeOrdersController implements CoffeeOrdersController {

  @Autowired
  private CoffeeOrdersService coffeeOrdersService;
  
  @Override
  public List<CoffeeOrders> fetchAllCoffeeOrders() {
    return coffeeOrdersService.fetchAllCoffeeOrders();
  }

}
