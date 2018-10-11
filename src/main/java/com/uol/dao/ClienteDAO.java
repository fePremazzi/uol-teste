package com.uol.dao;

import org.springframework.data.jpa.repository.Query;

import com.uol.entities.Cliente;

public interface ClienteDAO {
	
	
	Iterable<Cliente> listAllClientes();
	
	void addCliente(Cliente cliente);
	void deleteCliente(Long id);
	String updateCliente(Cliente cliente, Long id);
	
	
	Cliente findById(Long id);

}
