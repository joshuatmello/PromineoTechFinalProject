package com.promineotech.coffee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.coffee.dao.DefaultCustomerDao.SqlParams;
import com.promineotech.coffee.entity.Customer;
import com.promineotech.coffee.entity.Orders;

@Component
public class DefaultOrdersDao implements OrdersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  //GET all orders
  @Override
  public List<Orders> fetchAllOrders() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM orders";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<Orders>() {

      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Orders.builder()
           .orderId(rs.getInt("order_id"))
           .customerId(rs.getInt("customer_id"))
           .orderDate(rs.getDate("order_date"))
           .build();
        //@formatter:on
      }
    });
  }

  //GET orders by customer Id
  @Override
  public List<Orders> fetchOrderByCustomerId(String customerId) {
  //formatter:off
    String sql = ""
        +"SELECT * FROM orders "
        +"WHERE customer_id = :customer_id";
    //formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    
    return jdbcTemplate.query(sql, params, 
        new RowMapper<>() {
      @Override
      public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Orders.builder()
           .customerId(rs.getInt("customer_id"))
           .orderId(rs.getInt("order_id"))
           .orderDate(rs.getDate("order_date"))
           .build();
        //@formatter:on
      }
    });
  }

  //POST order
  @Override
  public Orders createOrder(Integer customerId, Date orderDate) {
    SqlParams params = new SqlParams();
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    //@formatter:off
    params.sql= ""
        +"INSERT INTO orders "
        +"(customer_id, order_date) "
        +"VALUES (:customer_id, :order_date)";
    //@formatter:on
    
    params.source.addValue("customer_id", customerId);
    params.source.addValue("order_date", orderDate);
    
    jdbcTemplate.update(params.sql, params.source, keyHolder);
    
    int orderId = keyHolder.getKey().intValue();
    
    // @formatter:off
    return Orders.builder()
        .orderId(orderId)
        .customerId(customerId)
        .orderDate(orderDate)
        .build();
     //@formatter:on
  }

//Need this to implement the create method
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }
  
  //PUT or update order
  @Override
  public Orders updateOrder(Integer customerId, Date orderDate, Integer orderId) {
  //@formatter:off
    String sql = ""
        +"UPDATE orders "
        +"SET "
        +"customer_id = :customer_id, "
        +"order_date = :order_date "
        +"WHERE order_id = :order_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("customer_id", customerId);
    params.put("order_date", orderDate);
    params.put("order_id", orderId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not update customer");
    }
    
    //@formatter:off
    return Orders.builder()
        .customerId(customerId)
        .orderId(orderId)
        .orderDate(orderDate)
        .build();
    //@formatter:on
  }

  //Delete order
  @Override
  public void deleteOrder(Integer orderId) {
    //@formatter:off
    String sql = ""
        +"DELETE FROM orders "
        +"WHERE order_id = :order_id";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("order_id", orderId);
    
    if(jdbcTemplate.update(sql, params) == 0) {
      throw new NoSuchElementException("Could not delete order");
    }
    
  }

}
