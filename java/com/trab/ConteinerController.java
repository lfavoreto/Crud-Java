package com.trab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trab.model.Conteiner;
import com.trab.model.ConteinerService;

@Controller
public class ConteinerController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/conteiner")
	public String cadastrar(Model model) {
		model.addAttribute("cont", new Conteiner());
		return "formcont";
	}
	
	@PostMapping("/conteiner")
	public String acao(@ModelAttribute Conteiner cont, Model model) {
		model.addAttribute("cont", cont);
		ConteinerService cdao = context.getBean(ConteinerService.class);
		cdao.insert(cont);
		return "conteinersucesso";
	}
}