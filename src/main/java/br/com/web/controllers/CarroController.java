package br.com.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.models.Carro;
import br.com.web.models.Concessionaria;
import br.com.web.repositories.CarroRepository;
import br.com.web.repositories.ConcessionariaRepository;

public class CarroController {


	@Autowired
	private CarroRepository car;

	@Autowired
	private ConcessionariaRepository cr;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String cadCarroConcessionaria(@PathVariable("id") long id, @Valid Carro carro, BindingResult result,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
			return "redirect:/{id}";
		}
		Concessionaria concessionaria = cr.findById(id);
		carro.setConcessionaria(concessionaria);
		car.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro adicionado com sucesso");
		return "redirect:/{id}";

	}
	
}
