package com.uol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uol.dao.ClienteDao;
import com.uol.entities.Cliente;

@RestController
@RequestMapping("/")
public class ClienteController {
	
	@Autowired
	private ClienteDao clientes;
	
	@GetMapping("/all")
	public Iterable<Cliente> list(){
		return clientes.listAllClientes();
	}

}
