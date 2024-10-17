package com.project.JP.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.JP.Model.Category;
import com.project.JP.Repo.CategoryRepo;

@RestController
public class CategoryRESTCont 
{
	@Autowired
	private CategoryRepo CR;
	
	@RequestMapping("/")
	public String isLand()
	{
		return "Welcome To REST API";
	}
	@RequestMapping("/api/categories")
	public String isCreate(Category C)
	{
		if(C.getName()!=null)
		{
			CR.save(C);
			return "created a new category successfully..";
		}
		else
		{
			return "please pass parameters..!";
		}
	}
	@RequestMapping("/findAll")
	public List<Category> isFindAll()
	{
		List<Category> lc = CR.findAll();
		System.out.println(lc);
		return lc;
	}
	@RequestMapping("/Search/{id}")
	public Category isSearch(@PathVariable int id)
	{
		Category c = CR.findById(id).orElseThrow(()->new RuntimeException("Data Not found"));
		return c;
	}
	@RequestMapping("/Update{id}")
	public String isUpdate(@ModelAttribute Category C)
	{
		Category c = CR.findById(C.getId()).orElse(null);
		if(C.getName()!=null)
		{
			c.setName(C.getName());
		}
		else
		{
			c.setName(c.getName());
		}
		if(C.getDescription()!=null)
		{
			c.setDescription(C.getDescription());
		}
		else
		{
			c.setDescription(c.getDescription());
		}
		CR.save(c);
		return "Category Successfully Updated..!";
	}
	@RequestMapping("/del/{id}")
	public String isDel(@PathVariable int id)
	{
		CR.deleteById(id);
		return "Category Deleted successfully.";
	}
}
