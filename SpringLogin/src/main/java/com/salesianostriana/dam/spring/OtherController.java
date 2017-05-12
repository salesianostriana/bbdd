package com.salesianostriana.dam.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class OtherController {
	
	@GetMapping("/welcome")
	public String welcome(Model model) {
		return "welcome";
	}

}
