package br.com.appmodelo.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.core.env.Environment;

import br.com.appmodelo.model.entity.Rodada;

@ManagedBean
@SessionScoped
public class RodadaBean {

	//@ManagedProperty("#{rodadaService}")
	//private ClienteService rodadaService;

	@ManagedProperty("#{environment}")
	private Environment environment;

	private Rodada rodada;

	private List<Rodada> rodadas;

/*	public void setRodadaService(RodadaService rodadaService) {
		this.rodadaService = rodadaService;
	}*/

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String listar() {
		//rodadas = rodadaService.buscarTodos();
		return "/rodada/rodadaList";
	}

	public String prepararInserir() {
		rodada = new Rodada();
		return "/rodada/rodadaForm";
	}

	public String prepararEditar() {
		//rodada = rodadaService.buscarPorId(rodada.getId());
		return "/rodada/rodadaForm";
	}

	public String salvar() {
		//rodadaService.salvar(rodada);
		adicionarMenssagemSalvoSucesso();
		return listar();
	}

	public String excluir() {
		//rodadaService.excluir(rodada);
		adicionarMenssagemExcluidoSalvoSucesso();
		return listar();
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

	public List<Rodada> getRodadas() {
		return rodadas;
	}

	public void setRodadas(List<Rodada> rodadas) {
		this.rodadas = rodadas;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

}
