package com.example.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.UserTest;
import com.example.demo.repository.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;


@Controller
@Component
public class DangKyController {
	@Autowired
	UserRepository userRS;

	
	@GetMapping(value = "/dangky")
	public String dangky() {
		return "dangky";
	}
	@PostMapping(value = "/dangky")
//	@ResponseBody
	public String dangkytk(@ModelAttribute UserTest user,Model m) {
		String passhash = org.mindrot.bcrypt.BCrypt.hashpw(user.getPass(), org.mindrot.bcrypt.BCrypt.gensalt());
		user.setPass(passhash);
		String error = "dang ky thanh cong";
		try {
			userRS.save(user);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			error = "dang ky fail";
		}
		m.addAttribute("error", error);
		return "index";
	}
	
}
