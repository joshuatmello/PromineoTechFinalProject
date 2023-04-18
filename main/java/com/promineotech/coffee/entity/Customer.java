package com.promineotech.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  private Integer customerId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  
}
