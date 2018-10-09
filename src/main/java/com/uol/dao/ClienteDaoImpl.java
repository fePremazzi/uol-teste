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
	private ClienteRepository clienteRepo;
	
	@Override
	public Iterable<Cliente> listAllClientes() {
		return clienteRepo.findAll();
	}

	@Override
	public void addCliente(Cliente cliente) {
		try {
			clienteRepo.save(cliente);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepo.deleteById(id);
	}

	@Override
	public String updateCliente(Cliente cliente, Long id) {
		try {
			Cliente cl = clienteRepo.findById(id).get();
			if (cl != null) {
				cliente.setId(id);
				clienteRepo.save(cliente);
				return "Client " + id + " updated";
			}
			return "Client does not exist";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public Cliente findById(Long id) {
		return clienteRepo.findById(id).get();
	}

}
