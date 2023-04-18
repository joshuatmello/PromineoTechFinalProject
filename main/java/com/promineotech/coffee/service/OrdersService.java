package com.promineotech.coffee.service;

import java.util.Date;
import java.util.List;
import com.promineotech.coffee.entity.Orders;

public interface OrdersService {

  //GET or Read all orders
  List<Orders> fetchAllOrders();

  //GET or Read orders by Customer Id
  List<Orders> fetchOrderByCustomerId(String customerId);

  //POST or Create order
  Orders createOrder(Integer customerId, Date orderDate);

  //PUT or Update order
  Orders updateOrder(Integer customerId, Date orderDate, Integer orderId);

  //delete Order
  void deleteOrder(Integer orderId);

}
