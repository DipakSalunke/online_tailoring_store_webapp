package com.Tailoring.store.management.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Tailoring.store.management.Model.Admin;
import com.Tailoring.store.management.Model.CardDetails;
import com.Tailoring.store.management.Model.Measurements;
import com.Tailoring.store.management.Model.PatternAndCost;
import com.Tailoring.store.management.Model.Tailor;
import com.Tailoring.store.management.Model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// --------------------------------------------------------
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// --------------------------------------------------------
	public boolean addUser(User register) {
		
		
		String sql = "insert into user_table(firstname,lastname,dateofbirth,gender,contact_number,category,username,password) values(?,?,?,?,?,?,?,?)";
			
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { register.getFirstName(), register.getLastName(), register.getDateOfBirth(),
							register.getSex(), register.getContactNumber(), register.getCategory(),
							register.getUserId(), register.getPassword()});

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// -----------------------------------------------
	@Override
	public List<User> read() {
		List<User> userList = jdbcTemplate.query("select * from user_table", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet set, int rowNum) throws SQLException {
				User user = new User();

				user.setUserId(set.getString("username"));
				user.setPassword(set.getString("password"));
				user.setCategory(set.getString("category"));
				return user;
			}
		});
		return userList;
	}
	
	public List<String> readTailor() {
		List<String> userList = jdbcTemplate.query("select distinct(user_table.username) from tailor_table, user_table where tailor_table.user_id= user_table.id", new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet set, int rowNum) throws SQLException {

				String user = set.getString("username");
				
				return user;
			}
		});
		return userList;
	}
	
	public List<Tailor> viewTailorDetails(){
		Tailor tailor= new Tailor();
		User user= new User();
		List<String> id= jdbcTemplate.query("select id from user_table where username='sai' ;" ,new RowMapper<String>(){
			
			@Override
			public String mapRow(ResultSet set, int rowNum) throws SQLException {

				String user_id = set.getString("id");
				return user_id;
			}
		});
		String id1=id.get(0);
		List<Tailor> tailor_details=jdbcTemplate.query("select * from tailor_table where tailor_table.user_id="+"'"+id1+"'"+";" ,new RowMapper<Tailor>(){
			@Override
			public Tailor mapRow(ResultSet set, int rowNum) throws SQLException {

				tailor.setUserId(set.getString("id"));
				tailor.setShopName(set.getString("shop_name"));
				tailor.setAddress(set.getString("address"));
				tailor.setContactNumber(set.getString("contact_number"));
				tailor.setWorkingHours(set.getString("working_hours"));
				tailor.setCourier(set.getString("courier"));
				
				return tailor;
			}
		});
		
		return tailor_details;
	}
	
	public List<String> viewdresstype(){
		List<String> dresstype= jdbcTemplate.query("select dress_type from dress_type;",new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet set, int rowNum) throws SQLException {
				return set.getString("dress_type");
			}
			
		});
		return dresstype;
	}
	
	public List<String> viewpattern(){
		List<String> pattern= jdbcTemplate.query("select pat from pattern;",new RowMapper<String>() {
			@Override
			public String mapRow(ResultSet set, int rowNum) throws SQLException {
				return set.getString("pat");
			}
			
		});
		return pattern;
	}
	
public boolean addmeasurements(Measurements measurements) {
		
		
		String sql = "insert into measurements(dress_type,top_fabric,top_material,top_duration,top_length,top_quantity,neck,waist,chest,shoulder_length,bottom_fabric,bottom_material,bottom_duration,bottom_length,bottom_quantity,hip,knee_length) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { measurements.getDressType(),measurements.getTop_fabric(),measurements.getTop_material(),measurements.getTop_duration(),measurements.getToplength(),measurements.getTop_quantity(), measurements.getNeck(),
							       measurements.getTopwaist(), measurements.getChest(),measurements.getShoulderLength() , measurements.getBottom_fabric(),measurements.getBottom_material(),measurements.getBottom_duration(),
							       measurements.getBottomlength(),measurements.getBottom_quantity(),measurements.getHip(),measurements.getKneelength()});

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

public boolean addCardDetails(CardDetails cardDetails) {
	
	
	String sql = "insert into card_details(card_number) values(?)";
		
	try {
		int counter = jdbcTemplate.update(sql,
				new Object[] { cardDetails.getCardNumber()});

		return true;

	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}
}



CREATE  TABLE IF NOT EXISTS `onlinetailoringsystem`.`card_details` (
  `card_number` VARCHAR(16) NOT NULL ,
  PRIMARY KEY (`card_number`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
