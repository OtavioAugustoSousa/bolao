package br.com.appmodelo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appmodelo.model.entity.Cliente;
import br.com.appmodelo.model.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.buscarTodos();
	}

	public void salvar(Cliente cliente) {
		clienteRepository.salvar(cliente);
	}

	public void excluir(Cliente cliente) {
		clienteRepository.excluir(cliente);
	}

	public Cliente buscarPorId(Long id) {
		return clienteRepository.buscarPorId(id);
	}

}