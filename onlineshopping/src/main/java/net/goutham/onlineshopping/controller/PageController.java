package net.goutham.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.goutham.shoppingbackend.dao.CategoryDao;
import net.goutham.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value= {"/" , "/index" , "/home"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		/*mv.addObject("greeting", "Welcome to spring web mvc");*/
		mv.addObject("categories",categoryDao.list());
		
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
		 
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		/*mv.addObject("greeting", "Welcome to spring web mvc");*/
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
		
	}
	
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		/*mv.addObject("greeting", "Welcome to spring web mvc");*/
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true); 
		return mv;
		
	}
	
	@RequestMapping(value= {"show/all/products"})
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("categories",categoryDao.list());
		
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
		
	}
	
	@RequestMapping(value= {"show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id")int id){
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		
		category = categoryDao.get(id);
		
		mv.addObject("title", category.getName());
		
		mv.addObject("categories",categoryDao.list());
		
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
}
















/*@RequestMapping(value="/test")
public ModelAndView test(@RequestParam(value ="greeting", required=false)String greeting){
	if(greeting == null){
		greeting = "Static value";
	}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
}*/

/*@RequestMapping(value="/test/{greeting}")
public ModelAndView test(@PathVariable("greeting")String greeting){
	if(greeting == null){
		greeting = "Static value";
	}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
}*/
