package br.com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.web.models.Concessionaria;

public interface ConcessionariaRepository extends CrudRepository<Concessionaria, Long> {

	Concessionaria findById(long id);
	Concessionaria findByNome(String nome);
}
