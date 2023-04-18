package com.promineotech.coffee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.coffee.dao.CustomerDao;
import com.promineotech.coffee.entity.Customer;

@Service
public class DefaultCustomerService implements CustomerService {

  @Autowired
  private CustomerDao customerDao;
  
  //Get
  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchAllCustomer() {
    List<Customer> customer = customerDao.fetchAllCustomer();
    return customer;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Customer> fetchCustomerByLastName(String customerLastName) {
    List<Customer> customer = customerDao.fetchCustomerByLastName(customerLastName);
    return customer;
  }

  //Post
  @Override
  public Customer createCustomer(String firstName, String lastName, String phoneNumber) {
    return customerDao.createCustomer(firstName, lastName, phoneNumber);
  }

  //Put
//  @Override
//  public Customer updateCustomer(int customerId, Customer updatedCustomer) {
//   return customerDao.updateCustomer(customerId, updatedCustomer);
//  }

  @Override
  public Customer updateCustomer(Integer customerId, String firstName, String lastName,
      String phoneNumber) {
    return customerDao.updateCustomer(customerId, firstName, lastName, phoneNumber);
  }
  
//Delete
  @Override
  public void deleteCustomer(int customerId) {
    customerDao.deleteCustomer(customerId);
    
  }

}
