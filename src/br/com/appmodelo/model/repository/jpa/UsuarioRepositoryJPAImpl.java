package br.com.appmodelo.model.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.appmodelo.model.entity.Estado;
import br.com.appmodelo.model.entity.Usuario;
import br.com.appmodelo.model.repository.LoginRepository;

@Repository
public class UsuarioRepositoryJPAImpl implements LoginRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public boolean login(String login, String senha) {
		entityManager.find(Usuario.class, login);
		return true;
	}

}
