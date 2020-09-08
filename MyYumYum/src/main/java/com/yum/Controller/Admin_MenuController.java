package com.yum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yum.Model.MenuItem;
import com.yum.Repository.Admin_MenuItemRepository;
import com.yum.Service.Admin_MenuItemService;

@Controller
public class Admin_MenuController {

	@Autowired
	private Admin_MenuItemService serv;

	@Autowired
	private Admin_MenuItemRepository repo;

	// MAIN PAGE CALLING ADMIN--------------1
	// IF EDIT CALLED
	@GetMapping("/show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) throws Exception {

		List<MenuItem> menuItemList = serv.getMenuItemListAdmin();
		model.put("menuItemList", menuItemList);

		// return repo.findAll();
		return "menu-item-list-admin";
	}

//	// IF EDITED THEN EDIT PAGE IS SHOWN------2
//	@GetMapping("/add-new-item-menu")
//	public String addNewMenuItem(ModelMap model, @RequestParam("menuItemId") int id) {
//		return "edit-menu-item";
//	}

	// IF EDITED THEN EDIT PAGE IS SHOWN------2
	@GetMapping("/show-edit-menu-item")
	public String showEditMenuItem(ModelMap model, @RequestParam("menuItemId") int id) throws ClassNotFoundException {
		if(id==0) {
			MenuItem item =new MenuItem();
			//return "index";
			model.put("menuItem", item);
			return "edit-menu-item";
		}
		MenuItem item = serv.getMenuItem(id);
		model.put("menuItem", item);
		return "edit-menu-item";
	}

	// ON RETURN THE EDIT MODIFIED DATA IS SENT HERE AND ALSO DONE THE
	// VALIDATION----3
	// THIS IS SENT BACK TO ANOTHER PAGE FOR SUCCESS MESSAGE
	@PostMapping("/edit-menu-item")
	public String editMenuItem(@ModelAttribute MenuItem menuItem, BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.debug("{}", bindingResult.getFieldErrors());
//		}
		
		if(menuItem.getId()==0) {
			System.out.println(menuItem+"<----------------------foundddddddddd");
			MenuItem new_item= new MenuItem(menuItem.getName(),menuItem.getPrice(), menuItem.getActive(), menuItem.getDateOfLaunch(), menuItem.getCategory(), menuItem.getFreeDelivery(), menuItem.getCarts());
			serv.editMenuItems(new_item);
			return "edit-menu-item-status";
		}
		
		
		
		
		
		if (menuItem.getFreeDelivery() == null)
			menuItem.setFreeDelivery("No");
		serv.editMenuItem(menuItem);
		return "edit-menu-item-status";
	}

}
