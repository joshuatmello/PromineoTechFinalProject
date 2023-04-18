package com.promineotech.coffee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.coffee.dao.CoffeeOrdersDao;
import com.promineotech.coffee.entity.CoffeeOrders;

@Service
public class DefaultCoffeeOrdersService implements CoffeeOrdersService {

  @Autowired
  private CoffeeOrdersDao coffeeOrdersDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<CoffeeOrders> fetchAllCoffeeOrders() {
    List<CoffeeOrders> coffeeOrders = coffeeOrdersDao.fetchAllCoffeeOrders();
    return coffeeOrders;
  }

}
