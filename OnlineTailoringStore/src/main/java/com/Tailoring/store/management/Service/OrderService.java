package com.Tailoring.store.management.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Tailoring.store.management.Model.Admin;
import com.Tailoring.store.management.Model.Orders;

@Service
public interface OrderService {
	
	public List<Orders> readNewOrders(String uid,String cat);
	
	public List<Orders> readActiveOrders(String uid,String cat);
	
	public List<Orders> readCompletedOrders(String uid,String cat);

}