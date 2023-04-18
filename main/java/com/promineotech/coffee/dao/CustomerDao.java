package com.promineotech.coffee.dao;

import java.util.List;
import com.promineotech.coffee.entity.Customer;

public interface CustomerDao {

  //Get
  List<Customer> fetchAllCustomer();

  //Get
  List<Customer> fetchCustomerByLastName(String customerLastName);

  //Post
  Customer createCustomer(String firstName, String lastName, String phoneNumber);

  //Put
  //Customer updateCustomer(int customerId, Customer updatedCustomer);
  Customer updateCustomer(Integer customerId, String firstName, String lastName,
      String phoneNumber);
  
  //Delete
  void deleteCustomer(int customerId);



}
