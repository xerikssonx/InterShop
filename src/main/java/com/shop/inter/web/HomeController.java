package com.shop.inter.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shop.inter.entity.Type;
import com.shop.inter.entity.User;
import com.shop.inter.service.IProductService;
import com.shop.inter.service.ITypeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ITypeService typeService;
	@Autowired
	IProductService productService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<Type> types = typeService.getAllTypes();
		model.addAttribute("products", productService.findAll());
		model.addAttribute("types", types);
		model.addAttribute("user", new User());
		return "home";
	}


}
