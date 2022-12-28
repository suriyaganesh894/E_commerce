package com.webapp.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.ecommerce.Ecommerce;


import jakarta.transaction.Transactional;

public interface ECommerceDao extends JpaRepository<Ecommerce, Integer> {
	
	
	@Query(value="select * from ecommerce where type=?1",nativeQuery = true)
	public List<Ecommerce> byType(String type);
	
	
	@Modifying
	@Transactional
	@Query(value="delete from ecommerce where product_id=?1",nativeQuery = true)
	void delete(String id);
	
	@Query(value="select * from ecommerce where product_id=?1",nativeQuery = true)
	List<Ecommerce> byId(String id);
}
