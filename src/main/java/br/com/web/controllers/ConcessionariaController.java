package br.com.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.models.Cliente;
import br.com.web.models.Concessionaria;
import br.com.web.repositories.ClienteRepository;
import br.com.web.repositories.ConcessionariaRepository;


@Controller
public class ConcessionariaController {

	@Autowired
	private ConcessionariaRepository cr;
	
	@Autowired
	private ClienteRepository clr;
	
	@RequestMapping(value="/concessionaria", method=RequestMethod.POST)
	public String form(@Valid Concessionaria concessionaria, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/concessionaria";
		}
		cr.save(concessionaria);
		attributes.addFlashAttribute("mensagem", "Concessionaria adicionado com sucesso");
		return "redirect:/concessionaria";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") long id) {
		Concessionaria concessionaria= cr.findById(id);
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("concessionaria", concessionaria);
		Iterable<Cliente> clientes = clr.findByConcessionaria(concessionaria);
		mv.addObject("cliente", clientes);
		return mv;
	}
}
