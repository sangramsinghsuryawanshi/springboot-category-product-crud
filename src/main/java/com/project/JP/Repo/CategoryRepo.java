package com.project.JP.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.JP.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> 
{
	
}
