package com.yum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yum.Model.MenuItem;
import com.yum.Repository.Admin_MenuItemRepository;
import com.yum.Repository.CartRepository;
import com.yum.Service.Customer_MenuItemService;

@Controller
public class CustomerController {

	@Autowired
	private Customer_MenuItemService cust_serv;

	
	@Autowired
	private CartRepository cart_repo;

	// IT GIVES REULTS ONLY OF ACTIVE ITEM AS HAVING FILTER IN CART REPOSITORY
	@GetMapping("/show-menu-list-customer")
	public String showMenuItemListCustomer(ModelMap model) throws Exception {
		List<MenuItem> menuItemList = cust_serv.getMenuItemListCustomer();
		model.put("menuItemList", menuItemList);

		// return repo.getMenuItemListCustomer();
		return "menu-item-list-customer";
	}



}
