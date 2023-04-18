package com.promineotech.coffee.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.coffee.controller.model.CustomerDto;
import com.promineotech.coffee.entity.Customer;
import com.promineotech.coffee.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController {

  @Autowired
  private CustomerService customerService;
  
  //Gets ALL customers
  @Override
  public List<Customer> fetchAllCustomer() {
    return customerService.fetchAllCustomer();
  }

  //Gets customer by last name
  @Override
  public List<Customer> fetchCustomerByLastName(String customerLastName) {
    return customerService.fetchCustomerByLastName(customerLastName);
  }

  //Posts-Creates customer using no parameters
  @Override
  public Customer createCustomer(@Valid CustomerDto customerDto) {
    return customerService.createCustomer(customerDto.getFirstName(), 
        customerDto.getLastName(), customerDto.getPhoneNumber());
  }
  
//Posts-Creates customer
//  @Override
//  public Customer createCustomer(String firstName, String lastName, String phoneNumber) {
//    return customerService.createCustomer(firstName, lastName, phoneNumber);
//  }

  //Puts- Updates customer using no parameters
  @Override
  public Customer updateCustomer(@Valid CustomerDto customerDto) {
    return customerService.updateCustomer(customerDto.getCustomerId(), customerDto.getFirstName(), 
        customerDto.getLastName(), customerDto.getPhoneNumber());
  }

//Puts- Updates customer
//  @Override
//  public Customer updateCustomer(int customerId, Customer updatedCustomer) {
//    return customerService.updateCustomer(customerId, updatedCustomer);
//    }
    
  //Deletes Customer 
  @Override
  public void deleteCustomer(@Valid CustomerDto customerDto) {
    log.debug("Customer ID Deleted = {}", customerDto.getCustomerId());
    customerService.deleteCustomer(customerDto.getCustomerId());
  }  

  //Deletes Customer with no parameters
//  @Override
//  public void deleteCustomer(int customerId) {
//    log.debug("Customer ID Deleted = {}", customerId);
//    customerService.deleteCustomer(customerId);
//    
//  }

}
