package com.promineotech.coffee.controller.model;

import java.math.BigDecimal;
import com.promineotech.coffee.entity.CoffeeFlavor;
import com.promineotech.coffee.entity.CoffeeGrind;
import com.promineotech.coffee.entity.CoffeeSize;

public class CoffeeDto {

private Integer coffeeId;
private CoffeeFlavor flavor;
private CoffeeGrind grind;
private CoffeeSize size;
private BigDecimal price;

public Integer getCoffeeId() {
  return coffeeId;
}
public CoffeeFlavor getFlavor() {
  return flavor;
}
public CoffeeGrind getGrind() {
  return grind;
}
public CoffeeSize getSize() {
  return size;
}
public BigDecimal getPrice() {
  return price;
}
  
  
}
