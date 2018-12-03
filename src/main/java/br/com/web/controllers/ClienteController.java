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
import br.com.web.models.Endereco;
import br.com.web.repositories.ClienteRepository;
import br.com.web.repositories.ConcessionariaRepository;
import br.com.web.repositories.EnderecoRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clr;

	@Autowired
	private ConcessionariaRepository cr;
	
	@Autowired
	private EnderecoRepository end;


	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String detalhesConcessionariaPost(@PathVariable("id") long id, @Valid Cliente cliente, @Valid Endereco endereco, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
			return "redirect:/{id}";
		}
		Concessionaria concessionaria = cr.findById(id);
		cliente.setConcessionaria(concessionaria);
		end.save(endereco);
		Endereco enderecoCad = end.findById(end.count());
		cliente.setEndereco(enderecoCad);
		clr.save(cliente);
		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso");
		return "redirect:/{id}";
	}


}
