package com.yum.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.Model.Cart;
import com.yum.Model.MenuItem;
import com.yum.Model.User;
import com.yum.Repository.Admin_MenuItemRepository;
import com.yum.Repository.CartRepository;

@Service
public class Customer_MenuItemService {

	@Autowired
	private CartRepository cart_repo;

	@Autowired
	private Admin_MenuItemRepository menu_repo;

	@Autowired
	private UserService u_serv;

	@Autowired
	private Admin_MenuItemService menu_serv;

	public List<MenuItem> getMenuItemListCustomer() {
		return menu_repo.getMenuItemListCustomer();
	}

	// CONTROLLER SENDS HERE TO ADD THE ITEM USING ITS ID
	// TO CART MODEL
	@Transactional
	public void addToCart(int menuItemId) {
		// GETTING USERS DETAILS USING USER'S-ID
		User user = u_serv.getUser(123);

		// CALLING THAT ITEM USING ID
		MenuItem menuItem = menu_serv.getMenuItem(menuItemId);

		Cart cart= new Cart();
		cart.setUser(user);
		cart.setMenuItem(menuItem);
		cart_repo.save(cart);

	}

}
