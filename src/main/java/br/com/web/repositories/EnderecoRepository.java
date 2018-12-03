package br.com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.web.models.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	Endereco findById(long id);
}
