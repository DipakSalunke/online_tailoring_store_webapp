package com.Tailoring.store.management.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Tailoring.store.management.Model.Admin;

@Service
public interface AdminService {
	
	public List<Admin> read();
	public boolean addCategory(String categorytype);
	public boolean addDressType(String category,String dressType);

}