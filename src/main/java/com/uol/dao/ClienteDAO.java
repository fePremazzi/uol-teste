package com.uol.dao;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.uol.entities.Cliente;

@Scope(value = "singleton")
@Component
public interface ClienteDao {
	
	Iterable<Cliente> listAllClientes();
	void addCliente(Cliente cliente);

}
