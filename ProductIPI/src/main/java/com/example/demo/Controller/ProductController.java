package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
	@GetMapping(value  = "/product")
	public String product(ModelMap m) {
		m.addAttribute("error", "yeah");

		return "product";
	}

	
}
