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
	
	@GetMapping("destino/descr/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		DestinoService ddao = context.getBean(DestinoService.class);
		Map<String, Object> destino = ddao.getDestino(id);
		Destino dest = new Destino((String)destino.get("nm_Carga"), (String)destino.get("nm_Bandeira"), (String)destino.get("ds_Origem"), (String)destino.get("ds_Destino"));
		model.addAttribute("dest", dest);
		return "destinosucesso";
	}
	
	@GetMapping("/destinos")
	public String listar(Model model) {
		DestinoService ddao = context.getBean(DestinoService.class);
		List<Map<String, Object>> destinos = ddao.getDestinos();
		model.addAttribute("destinos", destinos);
		return "formlistad";
	}
	
	@PostMapping("destino/apagar/{id}")
	public String deletar(@PathVariable("id") int id, Model model) {
		DestinoService ddao = context.getBean(DestinoService.class);
		ddao.deleteDestino(id);
		return "redirect:/destinos";
	}
}