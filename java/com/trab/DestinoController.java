package com.trab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trab.model.Destino;
import com.trab.model.DestinoService;

@Controller
public class DestinoController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/destino")
	public String cadastrar(Model model) {
		model.addAttribute("dest", new Destino());
		return "formdest";
	}
	
	@PostMapping("/destino")
	public String acao(@ModelAttribute Destino dest, Model model) {
		model.addAttribute("dest", dest);
		DestinoService ddao = context.getBean(DestinoService.class);
		ddao.insert(dest);
		return "destinosucesso";
	}
}