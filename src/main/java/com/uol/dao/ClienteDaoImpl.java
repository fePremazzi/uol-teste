package com.uol.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.uol.entities.Cliente;
import com.uol.repository.ClienteRepository;

public class ClienteDaoImpl implements ClienteDAO {
	
	@Autowired
	private ClienteRepository clienterepo;

	@Override
	public Iterable<Cliente> listAllClientes() {
		return clienterepo.findAll();
	}

	@Override
	public void addCliente(Cliente cliente) {
		try {
			clienterepo.save(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	


}
