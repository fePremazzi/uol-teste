package com.uol.repository;


import org.springframework.data.repository.CrudRepository;

import com.uol.entities.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	

}
