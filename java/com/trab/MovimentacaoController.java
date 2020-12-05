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

import com.trab.model.Movimentacao;
import com.trab.model.MovimentacaoService;

	@Controller
	public class MovimentacaoController {
		
		@Autowired
		private ApplicationContext context;
		
		@GetMapping("/Movimentacao")
		public String cadastrar(Model model) {
			model.addAttribute("mov", new Movimentacao());
			return "formmov";
		}
		
		@PostMapping("/Movimentacao")
		public String acao(@ModelAttribute Movimentacao mov, Model model) {
			model.addAttribute("mov", mov);
			MovimentacaoService mdao = context.getBean(MovimentacaoService.class);
			mdao.insert(mov);
			return "movimentacaosucesso";
		}
		
		@GetMapping("mov/descr/{id}")
		public String read(@PathVariable("id") int id, Model model) {
			MovimentacaoService mdao = context.getBean(MovimentacaoService.class);
			Map<String, Object> movimentacao = mdao.getMovimentacao(id);
			Movimentacao mov = new Movimentacao((String)movimentacao.get("nm_Navio"), (String)movimentacao.get("ds_Movimentacao"), (String)movimentacao.get("dt_Inicio"), (String)movimentacao.get("dt_Final"));
			model.addAttribute("mov", mov);
			return "movimentacaosucesso";
		}
		
		@GetMapping("/Movimentacoes")
		public String listar(Model model) {
			MovimentacaoService mdao = context.getBean(MovimentacaoService.class);
			List<Map<String, Object>> movimentacoes = mdao.getMovimentacoes();
			model.addAttribute("movimentacoes", movimentacoes);
			return "formlistam";
		}
}
