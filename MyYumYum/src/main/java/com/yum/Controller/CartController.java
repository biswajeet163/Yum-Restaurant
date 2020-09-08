package com.yum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yum.Model.Cart;
import com.yum.Model.MenuItem;
import com.yum.Repository.Admin_MenuItemRepository;
import com.yum.Service.Cart_Service;
import com.yum.Service.Customer_MenuItemService;

@Controller
public class CartController {
	@Autowired
	private Admin_MenuItemRepository menu_repo;

	@Autowired
	private Customer_MenuItemService cust_serv;
	
	@Autowired
	private Cart_Service cart_serv;

	// WHEN USER CLICKS "ADD TO CART" THEN BY TAKING THE ID OF THAT MENU-ITEM
	// IT COMES HERE AND ADD THE ITEM TO CART MODEL
	@GetMapping("/add-to-cart")
	public String addToCart(@RequestParam int menuItemId, ModelMap map) {

		List<MenuItem> menuItemList = menu_repo.getMenuItemListCustomer();
		map.put("menuItemList", menuItemList);

		cust_serv.addToCart(menuItemId);
		// return "index";
		return "menu-item-list-customer-notification";
	}

	//WHEN CART IS CLICKED IT SHOWS ALL THE ITEMS ADDED AND 
	// TOTAL PRICE ADDED AND ALSO OPTION OF DELETING ANYONE
	@GetMapping("/cart")
	public String cart(ModelMap model) throws Exception {
		// HERE 123 IS YHE USERID ID WHO HAVE LOGGED IN
		List<Cart> carts = cart_serv.getCart(123);
		int total = 0;
		
		System.out.println(total+"<--------------------------------------");
		
		if (carts.size() == 0)
			return "cart-empty";
		for (Cart cart : carts) {
			total += cart.getMenuItem().getPrice();
		}
		model.put("cart", carts);
		model.put("total", total);
		//return carts;
		return "cart";
	}
	
	@GetMapping("/delete")
	public String deleteItem(@RequestParam int productId, ModelMap model) {
		cart_serv.deleteItem(productId);
		// HERE 123 IS YHE USERID ID WHO HAVE LOGGED IN
		List<Cart> carts = cart_serv.getCart(123);
		int total=0;
		if(carts.size()==0)
			return "cart-empty";
		for (Cart cart : carts) {
			total+=cart.getMenuItem().getPrice();
		}
		model.put("cart", carts);
		model.put("total", total);
		return "cart-notification";
	}
	
	
	
}
