package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {

	// Ab hum apna CategoryDAO interface ko yha specify karenga

	// 2 Request mapping add karenga
	// 1. Sare products ko display karena ka liya
	// 2. Based on caregory product ko display karana ka liya

	@Autowired
	private CategoryDAO categoryDAO;

	// 1. Method to load index page

	@RequestMapping(value = {"/", "/home", "/index"})

	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Home");	
		
		mv.addObject("userClickHome", true);
		
		mv.addObject("categories", categoryDAO.list());

		return mv;

	}

	// 2. Method to load all the products based on category

	@RequestMapping(value = "/show/all/products")

	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");

		// Passing the list of categories

		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);

		return mv;

	}

	// 3. To show category- id: ya id dynamic hoge jo humna add ke sidebar.jsp ma-
	// Ab hum dekhenga iss id ko kaise access kar sakta hai

	@RequestMapping(value = "/show/category/{id}/products")

	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		// Hum simply ek category variable create karenga

		Category category = null;

		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());

		// Passing the list of categories

		mv.addObject("categories", categoryDAO.list());

		// Passing the single category object

		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);

		return mv;

	}

	// 4. Adding request mapping for about

	@RequestMapping(value = "/about")

	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About Us");

		mv.addObject("userClickAbout", true);

		return mv;

	}

	// 5. Adding request mapping for contact

	@RequestMapping(value = "/contact")

	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Contact Us");

		mv.addObject("userClickContact", true);

		return mv;

	}

}
