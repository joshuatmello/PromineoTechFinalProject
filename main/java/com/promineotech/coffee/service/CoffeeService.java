package com.promineotech.coffee.service;

import java.util.List;
import com.promineotech.coffee.entity.Coffee;

public interface CoffeeService {

  //GET all coffees
  List<Coffee> fetchAllCoffees();

}
