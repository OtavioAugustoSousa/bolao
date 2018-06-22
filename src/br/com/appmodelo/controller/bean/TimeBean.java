package br.com.appmodelo.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.appmodelo.model.entity.Time;

@ManagedBean
@SessionScoped
public class TimeBean {

	private Time time;
	private List<Time> times;

	public TimeBean() {
		times = new ArrayList<Time>();
		Time t = new Time();
		t.setEstado("ce");
		t.setNome("Ceará");
		times.add(t);
	}

	public String listar() {
		return "/time/timeList";
	}

	public String slavar() {
		return "/time/timeForm";
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

}
