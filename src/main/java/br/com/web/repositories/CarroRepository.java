package br.com.web.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.web.models.Carro;
import br.com.web.models.Concessionaria;

public interface CarroRepository extends CrudRepository<Carro, Long> {

	Carro findById(long id);
	Carro findByModelo(String modelo);
	Carro findByAno(int ano);
	Carro findByValor(double valor);
	Iterable <Carro> findByConcessionaria(Concessionaria concessionaria);
	
}
