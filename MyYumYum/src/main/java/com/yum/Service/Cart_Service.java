package com.yum.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yum.Model.Cart;
import com.yum.Repository.CartRepository;

@Service
public class Cart_Service {
	
	@Autowired
	private CartRepository cart_repo;
	
	@Transactional
	public List<Cart> getCart(int userId){
		return cart_repo.findAll();
		//return cart_repo.findById(userId);
	}
	
	@Transactional
	public void deleteItem(int id) {
		cart_repo.delete(cart_repo.getOne(id));
	}

}
