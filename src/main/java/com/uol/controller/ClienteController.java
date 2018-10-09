package com.uol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping("/")
	public String home(){
		return "Clientes API - Ler documentação junto da aplicação para entendimento dos endpoints";
	}
	
	@GetMapping("/all")
	public Iterable<Cliente> list(){
		return clientes.listAllClientes();
	}
	
	@GetMapping("/find/{id}")
	public Cliente findById(@PathVariable("id") Long id){		
		return clientes.findById(id);
	}
	
	@PostMapping("/add")
	public String adicionarCliente(@RequestBody Cliente cl) {
		try {
			clientes.addCliente(cl);		
			return "Client added";
		} catch (Exception e) {
			return e.getMessage();
		}		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		try {
			clientes.deleteCliente(id);
			return "Client "+id+" deleted";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PutMapping("/update/{id}")
	public String updateById(@RequestBody Cliente cl, @PathVariable("id") Long id) {
		try {
			return clientes.updateCliente(cl, id);								
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
