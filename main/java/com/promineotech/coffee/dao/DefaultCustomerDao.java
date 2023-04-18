package com.promineotech.coffee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.coffee.entity.Customer;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Customer> fetchAllCustomer() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM customer";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<Customer>() {

      @Override
      public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Customer.builder()
           .customerId(rs.getInt("customer_id"))
           .firstName(rs.getString("first_name"))
           .lastName(rs.getString("last_name"))
           .phoneNumber(rs.getString("phone_number"))
           .build();
       
        //@formatter:on
      }
    });
  }
//  public class CustomerResultSetExtractor implements ResultSetExtractor<Customer>{
//
//    @Override
//    public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {
//      rs.next();
//      //@formatter:off
//      return Customer.builder()
//          .customerId(rs.getInt("customer_id"))
//          .firstName(rs.getString("first_name"))
//          .lastName(rs.getString("last_name"))
//          .phoneNumber(rs.getString("phone_number"))
//          .build();
//      //@formatter:on
//    }
//    
//  }

  @Override
  public List<Customer> fetchCustomerByLastName(String customerLastName) {
    //formatter:off
    String sql = ""
        +"SELECT * FROM customer "
        +"WHERE last_name = :last_name";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("last_name", customerLastName);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Customer.builder()
           .customerId(rs.getInt("customer_id"))
           .firstName(rs.getString("first_name"))
           .lastName(rs.getString("last_name"))
           .phoneNumber(rs.getString("phone_number"))
           .build();
        //@formatter:on
      }
    });
  }

  //CREATE or POST
  @Override
  public Customer createCustomer(String firstName, String lastName, String phoneNumber) {
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //@formatter:off
    params.sql= ""
        +"INSERT INTO customer "
        +"(first_name, last_name, phone_number) "
        +"VALUES (:first_name, :last_name, :phone_number)";
    //@formatter:on
    
    params.source.addValue("first_name", firstName);
    params.source.addValue("last_name", lastName);
    params.source.addValue("phone_number", phoneNumber);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int customerId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return Customer.builder()
        .customerId(customerId)
        .firstName(firstName)
        .lastName(lastName)
        .phoneNumber(phoneNumber)
        .build();
     //@formatter:on
    
  }
  
  //Need this to implement the create method
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  //PUT or Update 
//  @Override
//  public Customer updateCustomer(int customerId, Customer updatedCustomer) {
//    //@formatter:off
//    String sql = ""
//        +"UPDATE customer "
//        +"SET "
//        +"first_name = :first_name, "
//        +"last_name = :last_name, "
//        +"phone_number = :phone_number "
//        +"WHERE customer_id = :customer_id";
//    //@formatter:on
//    
//    Map<String, Object> params = new HashMap<>();
//    params.put("customder_id", customerId);
//    params.put("first_name", updatedCustomer.getFirstName());
//    params.put("last_name", updatedCustomer.getLastName());
//    params.put("phone_number", updatedCustomer.getPhoneNumber());
//    
//    if(jdbcTemplate.update(sql, params) == 0) {
//      throw new NoSuchElementException("Could not update customer");
//    }
//    
//    //@formatter:off
//    return Customer.builder()
//        .customerId(customerId)
//        .firstName(updatedCustomer.getFirstName())
//        .lastName(updatedCustomer.getLastName())
//        .phoneNumber(updatedCustomer.getPhoneNumber())
//        .build();
//    //@formatter:on
//  }
  
  @Override
  public Customer updateCustomer(Integer customerId, String firstName, String lastName,
      String phoneNumber) {
  //@formatter:off
    String sql = ""
        +"UPDATE customer "
        +"SET "
        +"first_name = :first_name, "
        +"last_name = :last_name, "
        +"phone_number = :phone_number "
        +"WHERE customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("first_name", firstName);
    params.put("last_name", lastName);
    params.put("phone_number", phoneNumber);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not update customer");
    }
    
    //@formatter:off
    return Customer.builder()
        .customerId(customerId)
        .firstName(firstName)
        .lastName(lastName)
        .phoneNumber(phoneNumber)
        .build();
    //@formatter:on
  }

  //Delete
  @Override
  public void deleteCustomer(int customerId) {
  //@formatter:off
    String sql = ""
        +"DELETE FROM customer "
        +"WHERE customer_id = :customer_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not delete customer");
    }
  }

  

}
