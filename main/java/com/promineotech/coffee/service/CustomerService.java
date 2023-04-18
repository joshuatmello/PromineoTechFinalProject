package com.promineotech.coffee.service;

import java.util.List;
import com.promineotech.coffee.entity.Customer;

public interface CustomerService {

  //GET or READ 
  List<Customer> fetchAllCustomer();

  List<Customer> fetchCustomerByLastName(String customerLastName);

  //POST or CREATE
  Customer createCustomer(String firstName, String lastName, String phoneNumber);

  //PUT or UPDATE
  //Customer updateCustomer(int customerId, Customer updatedCustomer);
  Customer updateCustomer(Integer customerId, String firstName, String lastName,
      String phoneNumber);
  
  //DELETE
  void deleteCustomer(int customerId);





}
