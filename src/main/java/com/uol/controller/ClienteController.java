package com.uol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.dao.ClienteDAO;
import com.uol.entities.Cliente;

@RestController
@RequestMapping("/")
public class ClienteController {
	
	@Autowired
	private ClienteDAO clientes;
	
	@GetMapping("/all")
	public Iterable<Cliente> list(){
		return clientes.listAllClientes();
	}
	
	@PostMapping("/add")
	public void adicionarCliente(@RequestBody Cliente cl) {
		try {
			clientes.addCliente(cl);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		try {
			clientes.deleteCliente(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
