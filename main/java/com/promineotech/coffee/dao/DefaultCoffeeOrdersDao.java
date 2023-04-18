package com.promineotech.coffee.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.coffee.entity.CoffeeOrders;
import com.promineotech.coffee.entity.Orders;

@Component
public class DefaultCoffeeOrdersDao implements CoffeeOrdersDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<CoffeeOrders> fetchAllCoffeeOrders() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM coffee_orders";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<CoffeeOrders>() {

      @Override
      public CoffeeOrders mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return CoffeeOrders.builder()
           .orderId(rs.getInt("order_id"))
           .coffeeId(rs.getInt("coffee_id"))
           .build();
        //@formatter:on
      }
    });
  }

}
