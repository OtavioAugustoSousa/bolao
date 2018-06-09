package br.com.appmodelo.model.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.appmodelo.model.entity.Cliente;
import br.com.appmodelo.model.repository.ClienteRepository;

@Repository
public class CLienteRepositoryJPAImpl implements ClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cliente> buscarTodos() {
		return entityManager.createQuery("SELECT cliente FROM Cliente cliente", Cliente.class)
				    .getResultList();
		
	}

	@Override
	@Transactional
	public void salvar(Cliente cliente) {
		if(cliente.getId() == null) {
			entityManager.persist(cliente);
		}else {
			entityManager.merge(cliente);
		}
	}

	@Override
	@Transactional
	public void excluir(Cliente cliente) {
		entityManager.remove(cliente);
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

}
