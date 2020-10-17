package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	 //1. Adding request mapping for home

	@RequestMapping(value = { "/", "/home", "index" })

	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");		
		
        mv.addObject("title", "Home");
		
		mv.addObject("userClickHome", true);

		return mv;

	}
	

		
        //2. Adding request mapping for about
		
		@RequestMapping(value = "/about")

		public ModelAndView about() {			
			
			ModelAndView mv = new ModelAndView("page");

		
			
		    mv.addObject("title", "About Us");
			
			mv.addObject("userClickAbout", true);
			
			return mv;

		}
		
	     //3. Adding request mapping for contact
		
			@RequestMapping(value = "/contact")

			public ModelAndView contact() {			
				
				ModelAndView mv = new ModelAndView("page");

			
				
			    mv.addObject("title", "Contact Us");
				
				mv.addObject("userClickContact", true);
				
				return mv;

			}

}
