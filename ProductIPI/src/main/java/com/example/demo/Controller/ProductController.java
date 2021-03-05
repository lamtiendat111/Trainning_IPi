package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class ProductController {

	@Autowired
	RestTemplate rest;

	@GetMapping(value = "/product")
	public String product(ModelMap m) {
		m.addAttribute("error", "yeah");

		return "product";
	}

	@GetMapping(value = "/edit")
	public String edit(ModelMap m, @Param(value = "id") int id, @Param(value = "name") String name,
			@Param(value = "soluong") int soluong) {
		m.addAttribute("id", id);
		m.addAttribute("name", name);
		m.addAttribute("soluong", soluong);
		return "edit";
		
	}
	
	@GetMapping(value  = "/delete")
	public String xoa(Model m,@Param(value = "id") int id, @Param(value = "name") String name,@Param(value = "soluong") int soluong) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		String url = "http://localhost:8083/api/xoa";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("id",id)
				.queryParam("name",name)
				.queryParam("soluong", soluong);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<String> response = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		org.json.JSONObject j = new org.json.JSONObject(response.getBody());
		if(j.get("status").toString().equalsIgnoreCase("okay")) {
			m.addAttribute("error", "xoa thanh cong");
		}
		else {
			m.addAttribute("error", "xoa that bai");
			
		}
	

		return "product";
	}

}
