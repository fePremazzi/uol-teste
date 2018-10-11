package com.uol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.uol.entities.Cliente;
import com.uol.entities.Temperatura;
import com.uol.geolocaliza.TemperaturaAPI;
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
			Temperatura minMax = TemperaturaAPI.getMinMax();
			Temperatura temp = new Temperatura();
			temp.setTempMin(minMax.getTempMin());
			temp.setTempMax(minMax.getTempMax());
			
			cliente.setTemp(temp);
				
			
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
				
				if (cliente.getIdade() == null) {
					cliente.setIdade(cl.getIdade());
				}
				if (cliente.getNome() == null) {
					cliente.setNome(cl.getNome());
				}
				cliente.setId(id);
				cliente.setTemp(cl.getTemp());
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
