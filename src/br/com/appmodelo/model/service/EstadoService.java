package br.com.appmodelo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appmodelo.model.entity.Estado;
import br.com.appmodelo.model.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> buscarTodos(){
		return estadoRepository.buscarTodos();
	}

	public void salvar(Estado estado) {
		estadoRepository.salvar(estado);
	}

	public void excluir(Estado estado) {
		estadoRepository.excluir(estado);
	}

	public Estado buscarPorId(Long id) {
		return estadoRepository.buscarPorId(id);
	}

}
