package com.yum.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.yum.Model.Cart;
import com.yum.Model.MenuItem;


@Service
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	//@Query("select c from Cart c left join fetch c.user u where u.id= :id")
	//public List<Cart> findById(@Param("id") int id);
}
