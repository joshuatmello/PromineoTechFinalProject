package com.promineotech.coffee.service;

import java.util.List;
import com.promineotech.coffee.entity.CoffeeOrders;

public interface CoffeeOrdersService {

  List<CoffeeOrders> fetchAllCoffeeOrders();

}
