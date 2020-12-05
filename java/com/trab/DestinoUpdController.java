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

import com.trab.model.Destino;
import com.trab.model.DestinoService;

@Controller
public class DestinoUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/Des/upd/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		DestinoService ddao = context.getBean(DestinoService.class);
		Map<String, Object> antigo = ddao.getDestino(id);
		Destino dest = new Destino((String)antigo.get("nm_Carga"), (String)antigo.get("nm_Bandeira"), (String)antigo.get("ds_Origem"), (String)antigo.get("ds_Destino"));
		model.addAttribute("antigo", dest);
		model.addAttribute("id", id);
		return "formdestupd";
	}
	
	@PostMapping("/Des/upd/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Destino dest, Model model) {
		DestinoService ddao = context.getBean(DestinoService.class);
		ddao.updateDestino(id, dest);
		return "redirect:/destinos";
	}
}