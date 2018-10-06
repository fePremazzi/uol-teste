package com.uol.dao;

import com.uol.entities.Cliente;

public interface ClienteDAO {
	
	Iterable<Cliente> listAllClientes();
	void addCliente(Cliente cliente);
	void deleteCliente(Long id);

}
