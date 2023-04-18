package com.promineotech.coffee.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.coffee.entity.Coffee;
import com.promineotech.coffee.entity.CoffeeFlavor;
import com.promineotech.coffee.entity.CoffeeGrind;
import com.promineotech.coffee.entity.CoffeeSize;
import com.promineotech.coffee.entity.Orders;

@Component
public class DefaultCoffeeDao implements CoffeeDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Coffee> fetchAllCoffees() {
    // @formatter:off
    String sql = ""
        + "SELECT * FROM coffee";
    //@formatter:on
   
    return jdbcTemplate.query(sql, new RowMapper<Coffee>() {

      @Override
      public Coffee mapRow(ResultSet rs, int rowNum) throws SQLException {
        // @formatter:off
       return Coffee.builder()
           .coffeeId(rs.getInt("coffee_id"))
           .flavor(CoffeeFlavor.valueOf(rs.getString("flavor")))
           .grind(CoffeeGrind.valueOf(rs.getString("grind")))
           .size(CoffeeSize.valueOf(rs.getString("bagsize")))
           .price(new BigDecimal(rs.getString("price")))
           .build();
        //@formatter:on
      }
    });
  }
}
