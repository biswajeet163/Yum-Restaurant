package com.yum.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.Model.MenuItem;
import com.yum.Repository.Admin_MenuItemRepository;


@Service
public class Admin_MenuItemService {
	
	@Autowired
	private Admin_MenuItemRepository repo;
	
	@Transactional									// admin -1
	public List<MenuItem> getMenuItemListAdmin() {
		return repo.findAll();
	}
	
	// AFTER EDIT OPTION ID IS SENT TO GET THE EXACT COMPLTE DATA FROM DB
	@Transactional
	public MenuItem getMenuItem(int menuItemId) {
		return repo.getOne(menuItemId);
	}
	
	
	@Transactional
	public void editMenuItems(MenuItem menuItem) {
		
		repo.save(menuItem);
	}
	
	// AFTER GETTING MODIFIED DATA NEW MODIFIED DATA IS SAVED TO DB
	@Transactional
	public void editMenuItem(MenuItem menuItem) {
		MenuItem item = repo.getOne(menuItem.getId());
		item.setName(menuItem.getName());
		item.setPrice(menuItem.getPrice());
		item.setActive(menuItem.getActive());
		item.setDateOfLaunch(menuItem.getDateOfLaunch());
		item.setCategory(menuItem.getCategory());
		item.setFreeDelivery(menuItem.getFreeDelivery());
		repo.save(item);
	}
	

}
