package com.promineotech.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrders {

  private Integer orderId;
  private Integer coffeeId;
  
}
