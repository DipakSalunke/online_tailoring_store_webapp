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
	
	// -------------------------------------------------
		@Override
		public List<String> readCategory() {
			List<String> category = jdbcTemplate.query("select category from category", new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {

					return rs.getString(1);

				}
			});
			return category;
		}

		
		//-----------------------------------------------------
		@Override
		public List<String> readDress(String categoryType) {
			List<String> dress = jdbcTemplate.query("select dress_type from dress_type,category where dress_type.category_id = category.id && category.category='"
					+ categoryType + "'",
			new RowMapper<String>() {
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {

					return rs.getString(1);

				}
			});
			return dress;
		}
		
		
		// ---------------------------------------------------
//		@Override
//		public List<String> readDressType(String categoryType) {
	//
//			List<String> dressType = jdbcTemplate.query(
//					"select dress_type from dress_type,category where dress_type.category_id = category.id && category.category='"
//							+ categoryType + "'",
//					new RowMapper<String>() {
//						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//							Tailor tailor = new Tailor();
	//
//							tailor.setShopName(rs.getString(1));
//							tailor.setAddress(rs.getString(2));
//							tailor.setContactNumber(rs.getString(3));
//							tailor.setWorkingHours(rs.getString(4));
//							tailor.setAvailableServices(rs.getString(5));
//							tailor.setCourier(rs.getString(6));
	//
//							return tailor;
//						}
//					});
//			return dressType;
//		}

		// ----------------------------------------------------------------
		@Override
		public List<Tailor> readTailors(String categoryType, String dressType) {
			List<Tailor> tailorList = jdbcTemplate.query(
					"select * from tailor_table where id in (select tailor_id from tailordresstypes where dress_type_id in (select id from dress_type where dress_type ='"
							+ dressType + "'))",
							new RowMapper<Tailor>() {
								public Tailor mapRow(ResultSet rs, int rowNum) throws SQLException {
									Tailor tailor = new Tailor();

									tailor.setShopName(rs.getString(2));
									tailor.setAddress(rs.getString(3));
									tailor.setContactNumber(rs.getString(4));
									tailor.setWorkingHours(rs.getString(5));
									tailor.setAvailableServices(rs.getString(6));
									String courier = rs.getString(7);
									if(courier.equals("1"))
									tailor.setCourier("Yes");
									else
										tailor.setCourier("No");	

									return tailor;
								}
							});
			return tailorList;
		}
}
