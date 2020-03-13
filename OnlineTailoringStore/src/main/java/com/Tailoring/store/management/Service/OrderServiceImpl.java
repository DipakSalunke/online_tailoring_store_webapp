package com.Tailoring.store.management.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.Tailoring.store.management.Model.Admin;
import com.Tailoring.store.management.Model.Orders;
import com.Tailoring.store.management.Model.Tailor;

@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public OrderServiceImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Orders> readNewOrders(String uid,String cat) {
		String sql1="select id from user_table where username='"+uid+"'";
		int id= jdbcTemplate.queryForObject(sql1, Integer.class);
		String sql = "";
		if(cat.equals("T"))
			sql = "select * from orders where order_status = 'N' and tailor_id = '"+id+"'";
		else
			sql = "select * from orders where order_status = 'N' and user_id = '"+id+"'";
		List<Orders> newOrderList = jdbcTemplate.query(sql,
				new RowMapper<Orders>() {

					@Override
					public Orders mapRow(ResultSet set, int rowNum) throws SQLException {
						Orders order = new Orders();
						
						order.setOrder_id(set.getInt(1));
						
                        order.setPlaced_date(set.getDate(2));
                        order.setExp_delivery_date(set.getDate(3));
                        order.setDelivered_date(set.getDate(4));
                        order.setOrder_status(set.getString(5));
                        order.setAmount(set.getFloat(6));
                       

						return order;
					}
				});
		return newOrderList;
	}

	public List<Orders> readActiveOrders(String uid,String cat) {
		String sql1="select id from user_table where username='"+uid+"'";
		System.out.println(uid+" "+cat);
		
		int id= jdbcTemplate.queryForObject(sql1, Integer.class);
		System.out.println(id);
		String sql = "";
		if(cat.equals("T"))
			sql = "select * from orders where order_status = 'A' and tailor_id = '"+id+"'";
		else
			sql = "select * from orders where order_status = 'A' and user_id = '"+id+"'";
		List<Orders> newOrderList = jdbcTemplate.query(sql,
				new RowMapper<Orders>() {

					@Override
					public Orders mapRow(ResultSet set, int rowNum) throws SQLException {
						Orders order = new Orders();
                        order.setOrder_id(set.getInt(1));
						order.setPlaced_date(set.getDate(2));
                        order.setExp_delivery_date(set.getDate(3));
                        order.setDelivered_date(set.getDate(4));
                        order.setOrder_status(set.getString(5));
                        order.setAmount(set.getFloat(6));
						return order;
					}
				});
		return newOrderList;
	};

	public List<Orders> readCompletedOrders(String uid,String cat) {
		String sql1="select id from user_table where username='"+uid+"'";
		int id= jdbcTemplate.queryForObject(sql1, Integer.class);
		String sql = "";
		System.out.println("@@ " + uid + "   '"+cat+"'  "+ id);
		if(cat.equals("T"))
			sql = "select * from orders where order_status = 'C' and tailor_id = '"+id+"'";
		else
			sql = "select * from orders where order_status = 'C' and user_id = '"+id+"'";
		List<Orders> newOrderList = jdbcTemplate.query(sql,
				new RowMapper<Orders>() {

					@Override
					public Orders mapRow(ResultSet set, int rowNum) throws SQLException {
						Orders order = new Orders();
						 order.setOrder_id(set.getInt(1));
							order.setPlaced_date(set.getDate(2));
	                        order.setExp_delivery_date(set.getDate(3));
	                        order.setDelivered_date(set.getDate(4));
	                        order.setOrder_status(set.getString(5));
	                        order.setAmount(set.getFloat(6));
						return order;
					}
				});
		return newOrderList;
	};

}