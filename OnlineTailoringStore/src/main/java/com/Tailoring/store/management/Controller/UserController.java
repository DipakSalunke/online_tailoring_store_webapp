package com.Tailoring.store.management.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Tailoring.store.management.Service.UserService;
import com.Tailoring.store.management.Service.UserService;
import com.Tailoring.store.management.Service.UserServiceImpl;
import com.Tailoring.store.management.OnlineTailoringStoreApplication;
import com.Tailoring.store.management.Model.Tailor;
import com.Tailoring.store.management.Model.User;
import com.Tailoring.store.management.Model.User;

@Controller
@SessionAttributes("name")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	   
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String UserFront(@ModelAttribute("user") User userView) {
		return "user";
	}
	
	@RequestMapping(value="/userRegister",method = RequestMethod.POST)
	public String UserRegistration(@ModelAttribute("user")User userReg,ModelMap model){
		if(userService.addUser(userReg)) {
			model.put("status", "Registeration done Successfully");
		}
		else {
			model.put("status", "User Id is already used");
		}
		
		return "user";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String userLoginDisplay(@ModelAttribute("user") User user) {
		return "index";
	}
	
	
	@RequestMapping(value="/userSuccessLogin", method=RequestMethod.GET)
	public String userLoginSuccessDisplay(@ModelAttribute("user") User user) {
		return "userSuccessLogin";
	}
	
	@RequestMapping(value="/userSuccessLogin", method=RequestMethod.POST)
	public String userLogin(HttpServletRequest request,@ModelAttribute("user") User user,BindingResult result,ModelMap model) {
		
		if(result.hasErrors())
		{
			return "index";
		}
		
		
		List<User>userList = userService.read();
		for(User user1 : userList)
		{
			if(user1.getUserId().equals(user.getUserId()) && user1.getPassword().equals(user.getPassword()))
			{ 	model.put("name", user.getUserId());
				if(user1.getCategory().equals("T")) {
				return "tailorSuccessLogin";
			}else {
				return "userSuccessLogin";
			}
		}
		
		
	}
		model.put("error", "Wrong Credentials");
		return "index";
	}
	@RequestMapping(value = "/searchTailor", method = RequestMethod.GET)
	public String searchTailorView(@ModelAttribute("user") User user) {

		return "searchCategory";
	}

	@RequestMapping(value = "/searchTailor", method = RequestMethod.POST)
	public String searchTailor(@ModelAttribute("user") User user,BindingResult result,ModelMap model) {
			if(result.hasErrors())
			{
				return "searchCategory";
			} 
		return "searchCategory";
	}
	
	@RequestMapping(value = "/searchDressType", method = RequestMethod.GET)
	public String searchDressView(@ModelAttribute("user") User user) {

		return "searchDress";
	}

	@RequestMapping(value = "/searchDressType", method = RequestMethod.POST)
	public String searchDress(@ModelAttribute("user") User user,BindingResult result,ModelMap model) {
			if(result.hasErrors())
			{
				return "searchDress";
			}
			List<String> dressList = userService.readDress(user.getCategoryType());
						
			model.put("dressList",dressList);
			
		return "searchDress";
	}
	
	@RequestMapping(value = "/searchTailorList", method = RequestMethod.POST)
	public String searchedTailorList(@ModelAttribute("user") User user,ModelMap model) {

		List<Tailor> TailorList = userService.readTailors(user.getCategoryType(), user.getDressType());
		model.put("TailorList",TailorList);
		return "tailorList";
	}
	
	@ModelAttribute("categoryList")
	public List<String> readCategoryType() {

		List<String> categoryTypeList = userService.readCategory();
		return categoryTypeList;
	}
	

	}

