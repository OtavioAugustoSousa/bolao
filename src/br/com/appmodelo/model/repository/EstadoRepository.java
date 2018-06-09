package br.com.appmodelo.model.repository;

import java.util.List;

import br.com.appmodelo.model.entity.Estado;

public interface EstadoRepository {
	
	List<Estado> buscarTodos();

	void salvar(Estado estado);

	void excluir(Estado estado);

	Estado buscarPorId(Long id);

}
