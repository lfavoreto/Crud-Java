package com.trab;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trab.model.Conteiner;
import com.trab.model.ConteinerService;

@Controller
public class ConteinerUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/Dest/upd/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		ConteinerService cdao = context.getBean(ConteinerService.class);
		Map<String, Object> antigo = cdao.getConteiner(id);
		Conteiner cont = new Conteiner((String)antigo.get("nm_Cliente"), (String)antigo.get("cd_Conteiner"), (int)antigo.get("ic_Tipo"), (String)antigo.get("ic_Status"), (String)antigo.get("ic_Categoria"));
		model.addAttribute("antigo", cont);
		model.addAttribute("id", id);
		return "formcontupd";
	}
	
	@PostMapping("/Dest/upd/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Conteiner cont, Model model) {
		ConteinerService cdao = context.getBean(ConteinerService.class);
		cdao.updateConteiner(id, cont);
		return "redirect:/conteiners";
	}
}