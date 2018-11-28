package br.com.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.models.Cliente;
import br.com.web.repositories.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository cr;
	
	@RequestMapping("/cliente")
	public String cliente() {
		return "cliente";
	}
	
	@RequestMapping(value="/cliente", method=RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cliente";
		}
		cr.save(cliente);
		attributes.addFlashAttribute("mensagem", "Evento adicionado com sucesso");
		return "redirect:/cliente";
	}
	
}
