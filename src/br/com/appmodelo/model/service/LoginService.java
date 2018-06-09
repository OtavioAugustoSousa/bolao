package br.com.appmodelo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.appmodelo.model.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public boolean login(String login, String senha) {
		return loginRepository.login(login, senha);
	}

}
