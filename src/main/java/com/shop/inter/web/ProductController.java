package com.shop.inter.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.inter.entity.Basket;
import com.shop.inter.entity.User;
import com.shop.inter.exception.ProductException;
import com.shop.inter.service.IBasketService;
import com.shop.inter.service.IOrderService;
import com.shop.inter.service.IProductService;
import com.shop.inter.service.ITypeService;
import com.shop.inter.service.IUserService;

@Controller
public class ProductController {

	@Autowired
	IProductService productService;
	@Autowired
	ITypeService typeService;
	@Autowired
	IBasketService basketService;
	@Autowired
	IUserService userService;
	@Autowired
	IOrderService orderService;

	@RequestMapping("/choosesingle/{type}")
	public String choosesingle(@PathVariable String type, Model model) {
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user", new User());
		model.addAttribute("products", productService.findProductByType(type));
		return "home";
	}

	@RequestMapping("/choosedouble/{type}/{subtype}")
	public String choosedouble(@PathVariable String type,
			@PathVariable String subtype, Model model) {

		model.addAttribute("products",
				productService.findProductByTypeAndSubtype(type, subtype));
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user", new User());
		return "home";
	}

	@RequestMapping(value = { "/choosesingle/details/{id}", "/details/{id}",
			"/choosedouble/{?}/details/{id}" })
	public String choosedetails(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.findById(id));
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user", new User());
		return "details";
	}

	@RequestMapping(value = { "/choosedouble/{?}/details/tobasket",
			"/details/tobasket", "/choosesingle/details/tobasket" }, method = RequestMethod.POST)
	public String tobasket(@RequestParam("amount") Integer amount,
			@RequestParam("id") Long id, Model model, Principal principal) {
		if (amount == null) {
			amount = 1;
		}

		try {
			basketService.addProductToBasket(id, amount, principal.getName());
			model.addAttribute("types", typeService.getAllTypes());
			model.addAttribute("user", new User());
			model.addAttribute("baskets",
					basketService.findAllBasket(principal.getName()));
			return "basket";
		} catch (ProductException e) {
			model.addAttribute("types", typeService.getAllTypes());
			model.addAttribute("user", new User());
			model.addAttribute("msg", e.getMessage());
			return "resault";
		}

	}

	@RequestMapping(value = { "/details/tobasket", "/details/buyfrombasket" }, method = RequestMethod.GET)
	public String toBasketGet(Model model, Principal principal) {
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user", new User());
		model.addAttribute("baskets",
				basketService.findAllBasket(principal.getName()));
		return "basket";

	}

	@RequestMapping(value = { "/details/deletefrombasket",
			"{?}/details/deletefrombasket", "{?}/{?}/details/deletefrombasket" }, method = RequestMethod.POST)
	@ResponseBody
	public String detelefronbasket(@RequestParam String list) {

		basketService.deleteBasketsFromUser(list);
		return null;
	}

	@RequestMapping(value = "/details/buyfrombasket/{list}", method = RequestMethod.GET)
	public String buyfrombasket(@PathVariable String list, Model model,
			Principal principal) {
		List<Basket> baskets = basketService.findBasketsById(list);
		double totalCost = orderService.getTotalPrice(baskets);
		model.addAttribute("total", totalCost);
		model.addAttribute("baskets", baskets);
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user",
				userService.findByUsername(principal.getName()));
		return "buy";
	}

	@RequestMapping(value = { "/details/buyfrombasket/tofinishbuy" }, method = RequestMethod.POST)
	@ResponseBody
	public String buyfrombasket(@RequestParam String list,
			@RequestParam String payType, @RequestParam String deliveryType,
			Model model, Principal principal) {

		orderService.doBuy(list, payType, deliveryType, principal.getName());

		return null;
	}

	@RequestMapping(value = "/successbuy")
	public String successbuy(Model model) {
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user", new User());
		model.addAttribute("msg", "success buy");
		return "resault";

	}

	@RequestMapping(value = "/details/topurchase")
	public String topurchase(Model model, Principal principal) {
		model.addAttribute("types", typeService.getAllTypes());
		model.addAttribute("user", new User());
		model.addAttribute("products",
				orderService.getAllUsersProduct(principal.getName()));
		return "purchase";
	}

}
