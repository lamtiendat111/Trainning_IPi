package com.example.demo.api;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.ProductTest2;
import com.example.demo.Repository.ProductRepository;

@RestController
public class Api {

	@Autowired
	ProductRepository product;

	@GetMapping(value = "/api/product")
	public JSONObject getList() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", product.findAll());
		System.out.println(jsonObject.toString());
		return jsonObject;
	}

	@GetMapping(value = "/api/product2")
	public JSONObject add(@ModelAttribute ProductTest2 pro) {
		JSONObject jsonObject = new JSONObject();
		try {
			product.save(pro);
			jsonObject.put("status", "okay");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			jsonObject.put("status", "fail");
		}

		return jsonObject;
	}
	
	@GetMapping(value = "/api/xoa")
	public JSONObject xoa(@ModelAttribute ProductTest2 pro) {
		JSONObject jsonObject = new JSONObject();
		try {
			product.delete(pro);
			jsonObject.put("status", "okay");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			jsonObject.put("status", "fail");
		}
		return jsonObject;
	}

}
