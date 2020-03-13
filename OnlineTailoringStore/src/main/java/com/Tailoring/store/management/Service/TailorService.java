package com.Tailoring.store.management.Service;



import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Tailoring.store.management.Model.Admin;
import com.Tailoring.store.management.Model.PatternAndCost;
import com.Tailoring.store.management.Model.Tailor;
import com.Tailoring.store.management.Model.User;

@Service
public interface TailorService {
	//this method is used for to add tailor data in Database(OnlineTailoring System)
	public boolean addTailor(Tailor tailor);
	
	public List<String> readDressType();
	public boolean addPatternAndCost(PatternAndCost pattern,String name);
	//this method is used to fetch Tailor data from Database(OnlineTailoring System)
	public List<Tailor> read();
	
	public List<String> readCat();
	
	public List<String> readDress(String categoryType);
	
	public boolean addDressType(String dt);
	
	public boolean addTailorDressType(String dt,String uid);
}
