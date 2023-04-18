package com.promineotech.coffee.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.coffee.controller.model.OrdersDto;
import com.promineotech.coffee.entity.Orders;
import com.promineotech.coffee.service.OrdersService;

@RestController
public class DefaultOrdersController implements OrdersController {

  @Autowired
  private OrdersService orderService;
  
  //GET or Read all Orders
  @Override
  public List<Orders> fetchAllOrders() {
    return orderService.fetchAllOrders();
  }

  //GET or Read Oders by Customer Id
  @Override
  public List<Orders> fetchOrderByCustomerId(String customerId) {
    return orderService.fetchOrderByCustomerId(customerId);
  }

  //Create or POST Order
  @Override
  public Orders createOrder(@Valid OrdersDto orderDto) {
    return orderService.createOrder(orderDto.getCustomerId(), orderDto.getOrderDate());
  }

  //PUT or Update Order
  @Override
  public Orders updateOrder(@Valid OrdersDto orderDto) {
    return orderService.updateOrder(orderDto.getCustomerId(), orderDto.getOrderDate(), 
        orderDto.getOrderId());
  }

  //Delete Order
  @Override
  public void deleteOrder(@Valid OrdersDto orderDto) {
    orderService.deleteOrder(orderDto.getOrderId());
    
  }

}
