package com.uol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.uol.entities.Cliente;
import com.uol.repository.ClienteRepository;


@Scope(value = "singleton")
@Component
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

	@Override
	public void deleteCliente(Long id) {
		clienterepo.deleteById(id);		
	}


}
