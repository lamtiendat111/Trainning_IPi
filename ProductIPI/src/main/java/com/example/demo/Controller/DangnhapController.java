package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.mindrot.bcrypt.BCrypt;
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

import com.example.demo.entity.UserTest;
import com.example.demo.repository.UserRepository;

@Controller
@Component
public class DangnhapController {

	@Autowired
    private RedisTemplate template;
	
	@Autowired
	UserRepository userRS;

	@GetMapping(name = "/")
	public String dangnhap(ModelMap m) {
		m.addAttribute("error", "yeah");

		return "index";
	}

	@PostMapping(name = "/")
	public String dangnhap1(ModelMap m, @Param(value =  "name") String name,
			@Param(value = "pass") String pass) {
		if (userRS.findByName(name) != null) {
			UserTest u = userRS.findByName(name);
			Boolean status = BCrypt.checkpw(pass, u.getPass());
			if(status) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", u.getName());
				jsonObject.put("pass", u.getPass());
				JSONArray array = new JSONArray();
				array.add(jsonObject);
//				Map<String, Object> n = new HashMap<String, Object>();
//				n.put("1", u.getPass());
				template.opsForValue().set("user", array.toString());
				System.out.println("----" + template.opsForValue().get("user").toString());
				;
				m.addAttribute("error", "dang nhap thanh cong");
				return "product";
				
			}
		}

		m.addAttribute("error", "dang nhap that bai");

		return "index";
	}
}
