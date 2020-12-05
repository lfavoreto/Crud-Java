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

import com.trab.model.Movimentacao;
import com.trab.model.MovimentacaoService;


@Controller
public class MovimentacaoUpdController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/Mov/upd/{id}")
	public String updateForm(@PathVariable("id") int id, Model model) {
		MovimentacaoService mdao = context.getBean(MovimentacaoService.class);
		Map<String, Object> antigo = mdao.getMovimentacao(id);
		Movimentacao mov = new Movimentacao((String)antigo.get("nm_Navio"), (String)antigo.get("ds_Movimentacao"), (String)antigo.get("dt_Inicio"), (String)antigo.get("dt_Final"));
		model.addAttribute("antigo", mov);
		model.addAttribute("id", id);
		return "formmovupd";
	}
	
	@PostMapping("/Mov/upd/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Movimentacao mov, Model model) {
		MovimentacaoService mdao = context.getBean(MovimentacaoService.class);
		mdao.updateMovimentacao(id, mov);
		return "redirect:/Movimentacoes";
	}
}