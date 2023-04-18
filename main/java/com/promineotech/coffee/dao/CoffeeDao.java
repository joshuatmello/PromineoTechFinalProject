package com.promineotech.coffee.dao;

import java.util.List;
import com.promineotech.coffee.entity.Coffee;

public interface CoffeeDao {

  List<Coffee> fetchAllCoffees();

}
