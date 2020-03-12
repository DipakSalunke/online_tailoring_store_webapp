package com.Tailoring.store.management.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tailoring.store.management.Service.AdminService;
import com.Tailoring.store.management.Model.Admin;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminDao;

	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String adminsignin(@ModelAttribute("admin") Admin adminSignIn) {
		return "adminLogIn";
	}
	
	@RequestMapping(value = "/adminSuccessLogin", method = RequestMethod.GET)
	public String adminfoulattempt(@ModelAttribute("admin") Admin adminSignIn) {
		return "adminSuccessLogin";
	}
	@RequestMapping(value = "/adminSuccessLogin", method = RequestMethod.POST)
	public String userView(@ModelAttribute("admin") Admin adminSignin, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "adminLogIn";
		}
		List<Admin> list = adminDao.read();
		for (Admin register : list) {
			if (register.getUsername().equals(adminSignin.getUsername())
					&& register.getPassword().equals(adminSignin.getPassword())) {
				
				return "adminSuccessLogin";
			}
		}
		model.put("error", "Wrong Credentials");
		return "adminLogIn";
	}

//	@ModelAttribute("categoryTypeList")
//	public List<String> populateCategoryType() {
//
//		List<String> categoryTypeList = new ArrayList<String>();
//		categoryTypeList.add("Male");
//		categoryTypeList.add("Woman");
//		categoryTypeList.add("Boys");
//		categoryTypeList.add("Girls");
//
//		return categoryTypeList;
//	}
//	
	//////////////////////////////////////////////////////////////////
	
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public String adCategory(ModelMap model ) {
		return "adminAddCategory";
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String adCategory(ModelMap model ,@RequestParam String category) {
		if(adminDao.addCategory(category)) {
		model.put("statusc", "category added successfully");
		
		return "adminSuccessLogin";
	}
		else{
			model.put("statusc", "some error occured");
			
			return "adminSuccessLogin";
		}

}
	
	
	///////////////////////////////////////////////////////
	@RequestMapping(value = "/addDressType", method = RequestMethod.GET)
	public String adDressType(ModelMap model ) {
		return "adminAddDressType";
	}
	
	@RequestMapping(value = "/addDressType", method = RequestMethod.POST)
	public String adDressType(ModelMap model ,@RequestParam String category, @RequestParam String dressType) {
		if(adminDao.addDressType(category,dressType)) {
		model.put("statusd", "DressType added successfully");
		
		return "adminSuccessLogin";
	}
		else{
			model.put("statusd", "some error occured");
			
			return "adminSuccessLogin";
		}

}
	
	
}
