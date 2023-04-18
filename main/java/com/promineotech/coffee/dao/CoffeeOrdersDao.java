package com.promineotech.coffee.dao;

import java.util.List;
import com.promineotech.coffee.entity.CoffeeOrders;

public interface CoffeeOrdersDao {

  List<CoffeeOrders> fetchAllCoffeeOrders();

}
