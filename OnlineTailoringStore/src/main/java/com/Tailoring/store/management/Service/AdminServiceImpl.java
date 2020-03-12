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

@Component("adminServiceImpl")
public  class AdminServiceImpl implements AdminService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public AdminServiceImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public List<Admin> read() {
		List<Admin> RegisterList = jdbcTemplate.query("SELECT * FROM admin_table", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin = new Admin();

			
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				

				return admin;
			}

		});

		return RegisterList;
	}
	
	@Override
	public boolean addCategory(String categorytype) {
		try {
		jdbcTemplate.update("insert into category (category) values (?);",categorytype);
		return true;
		}catch(Exception e) {
			return false;
		}

		}

	@Override
	public boolean addDressType(String category, String dressType) {
		int id=0;
	try {
		     String sql = "SELECT id FROM category WHERE category ='"+ category+ "'";
		     id= jdbcTemplate.queryForObject(sql, Integer.class);
		jdbcTemplate.update("insert into dress_type (dress_type,category_id) values (?,?);",dressType,id);
		return true;
	}
	catch(Exception e) {
		return false;
	}		
	}

}