package br.com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.web.models.Cliente;
import br.com.web.models.Concessionaria;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Cliente findById(long id);
	Cliente findByNome(String nome);
	Cliente findByCpf(String cpf);
	Iterable <Cliente> findByConcessionaria(Concessionaria concessionaria);
}
