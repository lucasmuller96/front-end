package br.edu.unoesc.fdj.coronapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
//	@RequestMapping("/")
//	public String index(Model model) {
//		model.addAttribute("mensagem", "Compartilhando atributos com a tela!");
//		return "index"; // não precisa do sufixo(é jsp)
//	}
	
	@RequestMapping("/mensagem")
	public String exibir(Model model) {
		model.addAttribute("mensagem", "Mensagem exibida através da url exibir!");
		return "index";
	}
	
	@RequestMapping("/parametro/{codigo}")
	public String exibirParametro(@PathVariable int codigo, Model model) {
		model.addAttribute("mensagem", codigo);
		return "index";
	}
	
	
	@RequestMapping("/parametro2")
	public String exibirParametro2(@RequestParam int codigo, Model model) {
		model.addAttribute("mensagem", "testeasdasdasdasdas");
		return "index";
	}
}
