package com.promineotech.coffee.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {

  private Integer coffeeId;
  private CoffeeFlavor flavor;
  private CoffeeGrind grind;
  private CoffeeSize size;
  private BigDecimal price;
}
