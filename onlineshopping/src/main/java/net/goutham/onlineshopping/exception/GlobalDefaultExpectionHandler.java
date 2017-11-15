package net.goutham.onlineshopping.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import net.goutham.onlineshopping.controller.PageController;

@ControllerAdvice
public class GlobalDefaultExpectionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalDefaultExpectionHandler.class);
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","The page is not constructed!");
		mv.addObject("errorDescription","The page you are looking for is not available now!");
		mv.addObject("title","404 Error Page");
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException() {
		
		ModelAndView mv = new ModelAndView("error");
		logger.info("Inside ProductNotFoundException index method - INFO");
		mv.addObject("errorTitle","Product not available!");
		mv.addObject("errorDescription","The product you are looking for is not available right now!");
		mv.addObject("title","Product Unavailable");
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		
		ModelAndView mv = new ModelAndView("error");
		logger.info("Inside ProductNotFoundException index method - INFO");
		mv.addObject("errorTitle","Contact your Administrator");
		mv.addObject("errorDescription",ex.toString());
		mv.addObject("title","Error!");
		return mv;
	}
}
