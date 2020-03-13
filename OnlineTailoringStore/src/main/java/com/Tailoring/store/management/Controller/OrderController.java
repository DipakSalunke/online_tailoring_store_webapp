package com.Tailoring.store.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.Tailoring.store.management.Model.Orders;
import com.Tailoring.store.management.Model.Tailor;
import com.Tailoring.store.management.Service.OrderService;

@Controller
@SessionAttributes({"name","category"})
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/viewOrders", method = RequestMethod.GET)
	public String orderView( ModelMap model) {

		return "viewOrders";
	}

	// ------------------------------------------------------------------------------
	@RequestMapping(value = "/newOrders", method = RequestMethod.GET)
	public String neworderView( ModelMap model) {
		System.out.println((String)model.get("category"));
		List<Orders> newOrder = orderService.readNewOrders((String)model.get("name"),(String)model.get("category"));

		model.put("newOrdersList", newOrder);
		return "newOrders";
	}

	// ------------------------------------------------------------------------------
	@RequestMapping(value = "/activeOrders", method = RequestMethod.GET)
	public String activeorderView(@ModelAttribute("tailor") Tailor tailor, ModelMap model) {

		List<Orders> activeOrder = orderService.readActiveOrders((String)model.get("name"),(String)model.get("category"));

		model.put("activeOrderList", activeOrder);
		return "activeOrders";
	}

	// ------------------------------------------------------------------------------
	@RequestMapping(value = "/completedOrders", method = RequestMethod.GET)
	public String completedorderView(@ModelAttribute("tailor") Tailor tailor, ModelMap model) {

		List<Orders> completedOrder = orderService.readCompletedOrders((String)model.get("name"),(String)model.get("category"));

		model.put("completedOrderList", completedOrder);
		return "completedOrders";
	}

	// ------------------------------------------------------------------------------
}
