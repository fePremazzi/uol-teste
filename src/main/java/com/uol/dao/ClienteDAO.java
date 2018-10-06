package com.uol.dao;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.uol.entities.Cliente;

public interface ClienteDao {
	
	Iterable<Cliente> listAllClientes();
	void addCliente(Cliente cliente);
	void deleteCliente(Long id);

}
