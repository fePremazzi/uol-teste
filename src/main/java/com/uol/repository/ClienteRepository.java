package com.uol.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uol.entities.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
//	@Query("SELECT id, idade, nome, temperatura.temp_max, temperatura.temp_min FROM cliente INNER JOIN temperatura ON cliente.id_temp = temperatura.id_temp")
//	Iterable<Cliente> findAll();
}
