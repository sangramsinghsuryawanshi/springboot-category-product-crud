package com.project.JP.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.JP.Model.JoinTable;
import com.project.JP.Model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>
{
	@Query("SELECT new com.project.JP.Model.JoinTable(c.name, p.p_name, p.p_price) " +
		       "FROM Category c JOIN c.products p")
		List<JoinTable> isJoin();
}
