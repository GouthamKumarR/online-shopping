package net.goutham.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.goutham.onlineshopping.exception.ProductNotFoundException;
import net.goutham.shoppingbackend.dao.CategoryDao;
import net.goutham.shoppingbackend.dao.ProductDAO;
import net.goutham.shoppingbackend.dto.Category;
import net.goutham.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/" , "/index" , "/home"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		/*mv.addObject("greeting", "Welcome to spring web mvc");*/
		mv.addObject("categories",categoryDao.list());
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
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
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) throws ProductNotFoundException{
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		
		category = categoryDao.get(id);
		
		if(category == null){
			throw new ProductNotFoundException();
		}
		
		
		mv.addObject("title", category.getName());
		
		mv.addObject("categories",categoryDao.list());
		
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;
		
	}
	
	/*
	 * Viewing a single product
	 * */
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException  {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		if(product == null){
			throw new ProductNotFoundException();
		}
		
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
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
