package com.promineotech.coffee.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

  private Integer orderId;
  private Integer customerId;
  private Date orderDate;
}
