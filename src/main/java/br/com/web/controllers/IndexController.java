package br.com.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.web.models.Concessionaria;
import br.com.web.repositories.ConcessionariaRepository;

@Controller
public class IndexController {
	
	@Autowired
	private ConcessionariaRepository cr;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView listaConcessionarias() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Concessionaria> concessionarias = cr.findAll();
		mv.addObject("concessionarias", concessionarias);
		return mv;
	}
	
	@RequestMapping(value="/{id}")
	public ModelAndView detalharConcessionaria(@PathVariable("id") long id) {
		Concessionaria concessionaria = cr.findById(id);
		ModelAndView mv = new ModelAndView("detalheConcessionaria");
		mv.addObject("concessionaria", concessionaria);
		return mv;
		
	}
	
	@RequestMapping(value="/cli/{id}")
	public ModelAndView cliConcessionaria(@PathVariable("id") long id) {
		Concessionaria concessionaria = cr.findById(id);
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("concessionaria", concessionaria);
		return mv;
		
	}
	
	@RequestMapping(value="/car/{id}")
	public ModelAndView carConcessionaria(@PathVariable("id") long id) {
		Concessionaria concessionaria = cr.findById(id);
		ModelAndView mv = new ModelAndView("carro");
		mv.addObject("concessionaria", concessionaria);
		return mv;
		
	}
	
}
