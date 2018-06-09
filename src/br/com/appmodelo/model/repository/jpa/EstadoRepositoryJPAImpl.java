package br.com.appmodelo.model.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.appmodelo.model.entity.Estado;
import br.com.appmodelo.model.repository.EstadoRepository;

@Repository
public class EstadoRepositoryJPAImpl implements EstadoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Estado> buscarTodos() {
		return entityManager.createQuery("SELECT est FROM Estado est", Estado.class)
				    .getResultList();
		
	}

	@Override
	@Transactional
	public void salvar(Estado estado) {
		if(estado.getId() == null) {
			entityManager.persist(estado);
		}else {
			entityManager.merge(estado);
		}
	}

	@Override
	@Transactional
	public void excluir(Estado estado) {
		entityManager.remove(estado);
	}

	@Override
	public Estado buscarPorId(Long id) {
		return entityManager.find(Estado.class, id);
	}

}
