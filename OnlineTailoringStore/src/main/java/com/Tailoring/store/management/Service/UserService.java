package com.Tailoring.store.management.Service;



import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Tailoring.store.management.Model.Admin;
import com.Tailoring.store.management.Model.Tailor;
import com.Tailoring.store.management.Model.User;

@Service
public interface UserService {
	//this method is used for to add user data in Database(OnlineTailoring System)
	public boolean addUser(User user);
	
	//this method is used to fetch User data from Database(OnlineTailoring System)
	public List<User> read();
	
public List<String> readCategory();
	
	//public List<String> readDressType(String categoryType);
	
	public List<String> readDress(String categoryType);
	
	public List<Tailor> readTailors(String categoryType, String dressType); 
}
