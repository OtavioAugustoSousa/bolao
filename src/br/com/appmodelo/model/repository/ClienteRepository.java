package br.com.appmodelo.model.repository;

import java.util.List;

import br.com.appmodelo.model.entity.Cliente;

public interface ClienteRepository {
	
	List<Cliente> buscarTodos();

	void salvar(Cliente estado);

	void excluir(Cliente estado);

	Cliente buscarPorId(Long id);

}
