package com.shop.inter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.inter.entity.User;
import com.shop.inter.exception.RegistrationException;
import com.shop.inter.service.ITypeService;
import com.shop.inter.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	IUserService userService;
	@Autowired
	ITypeService typeService;

	/*
	 * @RequestMapping(value = "/registration", method = RequestMethod.GET)
	 * public String registration(Model model) { model.addAttribute("user", new
	 * User()); return "registration"; }
	 */

	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String createuser(User user, Model model) {
		try {
			userService.saveAndValidNewRegistredUser(user);
		} catch (RegistrationException e) {
			model.addAttribute("user", new User());
			model.addAttribute("types", typeService.getAllTypes());
			model.addAttribute("user", new User());
			model.addAttribute("msg", e.getMessage());
			return "resault";
		}
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("msg", "success registration");
		return "resault";
	}

	@RequestMapping(value = "/wrong", method = RequestMethod.GET)
	public String wrong(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("msg", "wrong username or passsword");
		return "resault";
	}

	@RequestMapping(value = "/namevalid", method = RequestMethod.POST)
	@ResponseBody
	public String nameValid(@RequestParam String name) {
		return name;

	}

	@RequestMapping(value = "/usernamevalid", method = RequestMethod.POST)
	@ResponseBody
	public String usernamevalid(@RequestParam String username) {
		return username;
	}
}
