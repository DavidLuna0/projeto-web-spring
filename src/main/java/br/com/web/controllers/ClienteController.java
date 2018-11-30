package br.com.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.models.Cliente;
import br.com.web.models.Concessionaria;
import br.com.web.repositories.ClienteRepository;
import br.com.web.repositories.ConcessionariaRepository;

@Controller
public class ClienteController {
/*
	@Autowired
	private ClienteRepository clr;

	@Autowired
	private ConcessionariaRepository cr;

	@RequestMapping("/cliente")
	public String cliente() {
		return "cliente";
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/cliente";
		}
		clr.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso");
		return "redirect:/cliente";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String cadClienteConcessionaria(@PathVariable("id") long id, @Valid Cliente cliente, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
			return "redirect:/{id}";
		}
		Concessionaria concessionaria = cr.findById(id);
		cliente.setConcessionaria(concessionaria);
		clr.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente adicionado com sucesso");
		return "redirect:/{id}";

	}*/

}
