package com.yum.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yum.Model.MenuItem;

public interface Admin_MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	@Query("select m from MenuItem m  where active='Yes'  and dateOfLaunch<=sysdate()")
	List<MenuItem> getMenuItemListCustomer();
	
}
