package com.project.JP.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.JP.Model.Category;
import com.project.JP.Model.JoinTable;
import com.project.JP.Model.Product;
import com.project.JP.Repo.CategoryRepo;
import com.project.JP.Repo.ProductRepo;

@RestController
public class ProductRESTControll 
{
	@Autowired
	private ProductRepo PR;
	
	@Autowired
	private CategoryRepo CR;
	
	@RequestMapping("/isLand")
	public String isLand()
	{
		return"Hello";
	}
	@RequestMapping("/ProAdd")
	public String isCreate(@ModelAttribute Product p,@RequestParam int categoryId)
	{
		Product po = new Product();
		po.setP_name(p.getP_name());
		po.setP_price(p.getP_price());
		po.setQut(p.getQut());
		Category ca = CR.findById(categoryId).orElseThrow(()-> new RuntimeException("Not found"));
		po.setCat(ca);
		if(p.getP_name()!=null || p.getP_price()>0 || p.getQut()>0 || p.getCat().getId()>0)
		{
			PR.save(po);
			return "new Product Added successfully..";
		}
		else
		{
			return "please pass parameters..!";
		}
	}
	@RequestMapping("/findPro")
	public List<Product> isFindPro()
	{
		List<Product> lc = PR.findAll();
		System.out.println(lc);
		return lc;
	}
	@RequestMapping("/SearchPro/{id}")
	public Product isSearch(@PathVariable int id)
	{
		Product c = PR.findById(id).orElseThrow(()->new RuntimeException("Data Not found"));
		return c;
	}
	@RequestMapping("/UpdatePro{id}")
	public String isUpdate(@ModelAttribute Product C)
	{
		Product c = PR.findById(C.getP_id()).orElse(null);
		if(C.getP_name()!=null)
		{
			c.setP_name(C.getP_name());
		}
		else
		{
			c.setP_name(c.getP_name());
		}
		if(C.getP_price()>0)
		{
			c.setP_price(C.getP_price());
		}
		else
		{
			c.setP_price(c.getP_price());
		}
		if(C.getQut()>0)
		{
			c.setQut(C.getQut());
		}
		else
		{
			c.setQut(c.getQut());
		}
		PR.save(c);
		return "Product Successfully Updated..!";
	}
	@RequestMapping("/delPro/{id}")
	public String isDel(@PathVariable int id)
	{
		PR.deleteById(id);
		return "Product Deleted successfully.";
	}
	@RequestMapping("/joinTbl")
	public List<JoinTable> isJT()
	{
		List<JoinTable> j = PR.isJoin();
		return j;
	}
}
