package br.com.appmodelo.controller.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.core.env.Environment;

import br.com.appmodelo.model.service.LoginService;

@ManagedBean
public class LoginBean {

	@ManagedProperty("#{environment}")
	private Environment environment;

	@ManagedProperty("#{loginService}")
	private LoginService loginService;

	private String login;

	private String senha;

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String login() {
		boolean loginValido = loginService.login(login, senha);

		if (loginValido) {
			return "home";
		} else {
			adicionarMenssagemLoginInvalido();
			return null;
		}

	}

	private void adicionarMenssagemLoginInvalido() {
		String mensagem = environment.getProperty("messagem.usuario.invalido");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
