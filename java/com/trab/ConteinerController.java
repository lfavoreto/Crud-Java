package com.trab;

import java.util.List;
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
	
	@GetMapping("conteiner/descr/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		ConteinerService cdao = context.getBean(ConteinerService.class);
		Map<String, Object> conteiner = cdao.getConteiner(id);
		Conteiner cont = new Conteiner((String)conteiner.get("nm_Cliente"), (String)conteiner.get("cd_Conteiner"), (int)conteiner.get("ic_Tipo"), (String)conteiner.get("ic_Status"), (String)conteiner.get("ic_Categoria"));
		model.addAttribute("cont", cont);
		return "conteinersucesso";
	}
	
	@GetMapping("/conteiners")
	public String listar(Model model) {
		ConteinerService cdao = context.getBean(ConteinerService.class);
		List<Map<String, Object>> conteiners = cdao.getConteiners();
		model.addAttribute("conteiners", conteiners);
		return "formlista";
	}
	
	@PostMapping("conteiner/apagar/{id}")
	public String deletar(@PathVariable("id") int id, Model model) {
		ConteinerService cdao = context.getBean(ConteinerService.class);
		cdao.deleteConteiner(id);
		return "redirect:/conteiners";
	}
}