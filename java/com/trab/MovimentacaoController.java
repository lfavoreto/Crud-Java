package com.trab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
}
