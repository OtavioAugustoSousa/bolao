package br.com.appmodelo.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.core.env.Environment;

import br.com.appmodelo.model.entity.Usuario;

@ManagedBean
@SessionScoped
public class JogadorBean {

	@ManagedProperty("#{environment}")
	private Environment environment;

	private Usuario jogador = new Usuario();

	private List<Usuario> clientes;

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String salvar() {
		return "/index/login";
	}

	public Usuario getJogador() {
		return jogador;
	}

	public void setJogador(Usuario jogador) {
		this.jogador = jogador;
	}

	private void adicionarMenssagemSalvoSucesso() {
		String mensagem = environment.getProperty("messagem.registro.salvo");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(mensagem));
	}

	private void adicionarMenssagemExcluidoSalvoSucesso() {
		String mensagem = environment.getProperty("messagem.registro.excluido");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(mensagem));
	}

}
