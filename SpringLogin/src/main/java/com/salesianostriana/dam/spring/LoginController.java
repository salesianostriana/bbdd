package com.salesianostriana.dam.spring;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	HttpSession session;
	
	
	@GetMapping({"/", "/login"})
	public String showLogin(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
				
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model) {
		
		User user = loginService.loginByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		
		if (user != null) {
			
			session.setAttribute("usuarioActual", user);
			return "redirect:/app/welcome";
		} else {
			model.addAttribute("error", "El usuario o contraseña no es válido");
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String doLogout(Model model) {
		session.setAttribute("usuarioActual", null);
		return "redirect:/";
	}
	
	

}
