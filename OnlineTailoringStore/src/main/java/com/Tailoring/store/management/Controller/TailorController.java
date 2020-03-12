package com.Tailoring.store.management.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Tailoring.store.management.Service.TailorService;
import com.Tailoring.store.management.Service.UserService;
import com.Tailoring.store.management.Service.UserService;
import com.Tailoring.store.management.Service.UserServiceImpl;
import com.Tailoring.store.management.Model.Tailor;
import com.Tailoring.store.management.Model.User;
import com.Tailoring.store.management.Model.User;

@Controller
@SessionAttributes("name")
public class TailorController {

	@Autowired
	private TailorService tailorService;

	@RequestMapping(value = "/updateShopDetails", method = RequestMethod.GET)
	public String tailorFront(@ModelAttribute("tailor") Tailor tailorView) {
		return "tailor";
	}
	
	@RequestMapping(value = "/tailorHome", method = RequestMethod.GET)
	public String tailorHome(ModelMap model) {
		return "tailorSuccessLogin";
	}

	@RequestMapping(value="/tailorRegister",method = RequestMethod.POST)
	public String tailorRegistration(@ModelAttribute("tailor")Tailor tailorReg,BindingResult result,ModelMap model){
		System.out.println(model.get("name"));
	tailorReg.setUserId((String)model.get("name"));
		if(tailorService.addTailor(tailorReg)) {
			model.put("updateStatus", "Details updated Successfully");
		}
		else {
			model.put("updateStatus", "Error Occured");
		}
		
		return "tailorSuccessLogin";
	}
	
	@ModelAttribute("categoryList")
	public List<String> readCategoryType(){
		List<String> cat = tailorService.readCat();
		System.out.println(tailorService.readCat().get(0));
		return cat;
	}
	
	@RequestMapping(value = "/updateDressTypes", method = RequestMethod.GET)
	public String getDressTypeJsp(@ModelAttribute("user") User user) {
		
	return "listCategory";
	}
	@RequestMapping(value = "/updateDressTypes", method = RequestMethod.POST)
	public String searchTailor(@ModelAttribute("user") User user,BindingResult result,ModelMap model) {
			if(result.hasErrors())
			{
				return "listCategory";
			} 
		return "listDressType";
	}
	
	
	
	@RequestMapping(value = "/listDressType", method = RequestMethod.GET)
	public String searchDressView(@ModelAttribute("user") User user) {

		return "listDressType";
	}

	@RequestMapping(value = "/listDressType", method = RequestMethod.POST)
	public String searchDress(@ModelAttribute("user") User user,BindingResult result,ModelMap model) {
			if(result.hasErrors())
			{
				return "listDressType";
			}
			
			List<String> dressList = tailorService.readDress(user.getCategoryType());
			
			model.put("dressList",dressList);
		return "listDressType";
	}
	
	
	@RequestMapping(value = "/addTailorDressType", method = RequestMethod.POST)
	public String searchedTailorList(@ModelAttribute("user") User user,ModelMap model) {
		System.out.println("@@@@" +user.getDressType()+"  @  "+(String)model.get("name"));
		if(tailorService.addTailorDressType(user.getDressType(),(String)model.get("name"))){
		model.put("dressstatus", "Dress Type Added Successfully");
		return "tailorSuccessLogin";
		}
		else {
			model.put("dressstatus", "Some Error Occured");
			return "tailorSuccessLogin";
		}
	}
	
	
//	List<Tailor> TailorList = userService.readTailors(user.getCategoryType(), user.getDressType());
//	model.put("TailorList",TailorList);
//	return "tailorList";
	
//	@RequestMapping(value="/tailorLogin", method=RequestMethod.GET)
//	public String tailorLoginDisplay(@ModelAttribute("tailor") Tailor tailor) {
//		return "tailorLogIn";
//	}
//	
//	@RequestMapping(value="/tailorSuccessLogin", method=RequestMethod.POST)
//	public String userLogin(@ModelAttribute("tailor") Tailor tailor,BindingResult result,ModelMap model) {
//		
//		if(result.hasErrors())
//		{
//			return "tailorLogIn";
//		}
//		
//		
//		List<Tailor>tailorList = tailorService.read();
//		for(Tailor tailor1 : tailorList)
//		{
//			if(tailor1.getUserId().equals(tailor1.getUserId()) && tailor1.getPassword().equals(tailor1.getPassword()))
//			{
//				model.put("username", tailor1.getUserId());
//				return "tailorSuccessLogin";
//			}
//		}
//		
//		model.put("error", "Wrong Credentials");
//		return "tailorLogIn";
//	}
//	
	
/*
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping(value="/registration",method=RequestMethod.GET)
	public String userRegistrationDisplay(ModelMap model) {
		model.addAttribute("user", new User());
		System.out.println("Hiiiii");
		return "Registration_page";
	}
	
	@RequestMapping(value="/registration1", method=RequestMethod.POST)
	public String userRegistration(@ModelAttribute("user") User user, ModelMap model) {
		//System.out.println(userDaoImpl.userExist(user.getUser_id()));
		if(userServiceImpl.addUser(user)) {
			model.put("status", "Registeration done Successfully");
		}
		else {
			model.put("status", "User Id is already used");
		}
		System.out.println();
		return "Registration_page";
	}
	
	//take this method from Adesh
	@RequestMapping(value="/User",method=RequestMethod.GET)
	public String UserLogin(@ModelAttribute("User")User User, ModelMap model){
		
		return "login";
	}
	
	
	//this is used for logout
	@RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPageUser(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/";  
     }  
*/	
}
