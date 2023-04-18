package com.promineotech.coffee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.coffee.dao.CoffeeDao;
import com.promineotech.coffee.entity.Coffee;

@Service
public class DefaultCoffeeService implements CoffeeService {

  @Autowired
  private CoffeeDao coffeeDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Coffee> fetchAllCoffees() {
    List<Coffee> coffee = coffeeDao.fetchAllCoffees();
    return coffee;
  }

}
