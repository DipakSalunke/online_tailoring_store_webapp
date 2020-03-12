package com.Tailoring.store.management.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Tailoring.store.management.Model.Tailor;

@Service("tailorService")
public class TailorServiceImpl implements TailorService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// --------------------------------------------------------
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// --------------------------------------------------------
	public boolean addTailor(Tailor register) {
		String sql = "insert into tailor_table(shop_name,address,contact_number,working_hours,available_services,courier,user_id) values(?,?,?,?,?,?,?)";
		int id = 0;
		try { 
			String sql1 = "SELECT id FROM user_table WHERE username ='"+ register.getUserId()+ "'";
	     id= jdbcTemplate.queryForObject(sql1, Integer.class);
			int counter = jdbcTemplate.update(sql,
					new Object[] { register.getShopName(), register.getAddress(), register.getContactNumber(),
							register.getWorkingHours(), register.getAvailableServices(), Integer.parseInt(register.getCourier()),id});

			 return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// -----------------------------------------------
	@Override
	public List<Tailor> read() {
		List<Tailor> userList = jdbcTemplate.query("select * from tailor_table", new RowMapper<Tailor>() {

			@Override
			public Tailor mapRow(ResultSet set, int rowNum) throws SQLException {
				Tailor tailor = new Tailor();

				
				return tailor;
			}
		});
		return userList;
	}

	@Override
	public boolean addDressType(String dt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> readCat() {
		String queryString = "SELECT category FROM category;";
		List<String> data =jdbcTemplate.query(queryString, new RowMapper<String>(){
            public String mapRow(ResultSet rs, int rowNum) 
                                         throws SQLException {
                    return rs.getString(1);
            }
       });
		
		return data;
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
			//String sql1 = "SELECT id FROM user_table WHERE username ='"+ register.getUserId()+ "'";
			@Override
			public boolean addTailorDressType(String dt,String uid) {
				// TODO Auto-generated method stub
				int t_id = 0;
				int dt_id = 0;
				try {
					String sql = "Select id from tailor_table where user_id in(SELECT id FROM user_table WHERE username ='"+ uid+ "')";
					 t_id= jdbcTemplate.queryForObject(sql, Integer.class);
					 System.out.println(t_id);
					 String sql1 = "select id from dress_type where dress_type = '"+dt+"'";
					 System.out.println(dt_id);
					 dt_id= jdbcTemplate.queryForObject(sql1, Integer.class);
					 jdbcTemplate.update("insert into tailordresstypes (dress_type_id,tailor_id) values('"+dt_id+"','"+t_id+"')");
					 return true;
				}catch(Exception e){
					e.printStackTrace();
					return false;
					
				}
			
			}

}
