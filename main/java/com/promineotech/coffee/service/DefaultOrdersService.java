package com.promineotech.coffee.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.coffee.dao.OrdersDao;
import com.promineotech.coffee.entity.Orders;

@Service
public class DefaultOrdersService implements OrdersService {

  @Autowired
  private OrdersDao orderDao;
  
  //GET or Read All orders
  @Transactional (readOnly = true)
  @Override
  public List<Orders> fetchAllOrders() {
    List<Orders> orders = orderDao.fetchAllOrders();
    return orders;
  }

  //GET or Read Orders by Customer Id
  @Transactional(readOnly = true)
  @Override
  public List<Orders> fetchOrderByCustomerId(String customerId) {
    List<Orders> orders = orderDao.fetchOrderByCustomerId(customerId);
    return orders;
  }

  //POST or Create Order
  @Override
  public Orders createOrder(Integer customerId, Date orderDate) {
    return orderDao.createOrder(customerId, orderDate);
  }

  //PUT or Update Order
  @Override
  public Orders updateOrder(Integer customerId, Date orderDate, Integer orderId) {
    return orderDao.updateOrder(customerId, orderDate, orderId);
  }

  //Delete order
  @Override
  public void deleteOrder(Integer orderId) {
    orderDao.deleteOrder(orderId);
    
  }

}
