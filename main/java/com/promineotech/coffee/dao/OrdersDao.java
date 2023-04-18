package com.promineotech.coffee.dao;

import java.util.Date;
import java.util.List;
import com.promineotech.coffee.entity.Orders;

public interface OrdersDao {

  //GET
  List<Orders> fetchAllOrders();

  //GET
  List<Orders> fetchOrderByCustomerId(String customerId);

  //POST
  Orders createOrder(Integer customerId, Date orderDate);

  //PUT
  Orders updateOrder(Integer customerId, Date orderDate, Integer orderId);
  
  //DELETE
  void deleteOrder(Integer orderId);

}
