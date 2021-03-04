package com.example.demo.api;

import java.util.Map;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.mindrot.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class Api {
	@Autowired
	RestTemplate rest;

	@Autowired
	private RedisTemplate template;

	@GetMapping(value = "/api/product")
	@ResponseBody
	public JSONObject getList() {
		JSONObject jsonObject = new JSONObject();
		jsonObject = rest.getForObject("http://localhost:8083/api/product", JSONObject.class);

		return jsonObject;
	}

	@GetMapping(value = "/api/product2")
	public String add(@ModelAttribute com.example.demo.entity.slave.ProductTest2 pro, Model m) {
		JSONObject jsonObject = new JSONObject();
//		JSONObject ProductObject = new JSONObject();
//		ProductObject.put("id", null);
//		ProductObject.put("name", pro.getName());
//		ProductObject.put("soluong", pro.getClass());
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> request = 
//			      new HttpEntity<String>(ProductObject.toString(), headers);
//		jsonObject = rest.postForObject("http://localhost:8083/api/product2", request, JSONObject.class);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		String url = "http://localhost:8083/api/product2";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)

				.queryParam("name", pro.getName()).queryParam("soluong", pro.getSoluong());
		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<String> response = rest.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
		org.json.JSONObject j = new org.json.JSONObject(response.getBody());
		if(j.get("status").toString().equalsIgnoreCase("okay")) {
			m.addAttribute("error", "them thanh cong");
		}
		else {
			m.addAttribute("error", "them that bai");
		}
		return "product";
	}

	@GetMapping(value = "/api/check")
	@ResponseBody
	public String check(@Param(value = "pass") String pass) {

		JSONArray array = new JSONArray(template.opsForValue().get("user").toString());
		org.json.JSONObject jsonObject = array.getJSONObject(0);
		;
		System.out.println(jsonObject.getString("pass").toString() );
		if (    BCrypt.checkpw(  pass , jsonObject.getString("pass").toString()  )) {
			return "khop";
		} else {
			System.out.println("khong khop");
		}
		return "khong";
	}

}
