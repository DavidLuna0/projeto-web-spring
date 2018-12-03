package br.com.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.web.models.Carro;
import br.com.web.models.Concessionaria;
import br.com.web.models.Endereco;
import br.com.web.repositories.CarroRepository;
import br.com.web.repositories.ConcessionariaRepository;
import br.com.web.repositories.EnderecoRepository;


@Controller
public class ConcessionariaController {
	
	@Autowired
	private CarroRepository car;

	@Autowired
	private ConcessionariaRepository cr;
	
	@Autowired
	private EnderecoRepository end;
	
	@RequestMapping(value="/concessionaria", method=RequestMethod.GET)
	public String concessionaria() {
		return "concessionaria";
	}
	
	
	@RequestMapping(value="/concessionaria", method=RequestMethod.POST)
	public String cadConcessionaria(@Valid Concessionaria concessionaria, @Valid Endereco endereco, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/concessionaria";
		}
		end.save(endereco);
		Endereco enderecoCad = end.findById(end.count());
		concessionaria.setEndereco(enderecoCad);
		cr.save(concessionaria);
		attributes.addFlashAttribute("mensagem", "Concessionaria adicionado com sucesso");
		return "redirect:/concessionaria";
	}
	
	
	@RequestMapping(value="/car/{id}",method=RequestMethod.POST)
	public String detalhesConcessionariaPost(@PathVariable("id") long id, @Valid Carro carro, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
			return "redirect:/car/{id}";
		}
		Concessionaria concessionaria = cr.findById(id);
		carro.setConcessionaria(concessionaria);
		car.save(carro);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");
		return "redirect:/car/{id}";
	}
	
	
	
	//Metodo para listar todos os clientes e carros cadastrado em uma concessionaria
	/*
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesConcessionariaClientes(@PathVariable("id") long id) {
		Concessionaria concessionaria= cr.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("concessionaria", concessionaria);
		Iterable<Carro> carros = car.findByConcessionaria(concessionaria);
		Iterable<Cliente> clientes = clr.findByConcessionaria(concessionaria);
		mv.addObject("carro", carros);
		mv.addObject("cliente", clientes);
		return mv;
		
	}*/
	/*
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesConcessionariaCarros(@PathVariable("id") long id) {
		Concessionaria concessionaria= cr.findById(id);
		ModelAndView mv = new ModelAndView("cliente");
		mv.addObject("concessionaria", concessionaria);
		Iterable<Cliente> clientes = clr.findByConcessionaria(concessionaria);
		mv.addObject("cliente", clientes);
		return mv;
	}
	*/
}
