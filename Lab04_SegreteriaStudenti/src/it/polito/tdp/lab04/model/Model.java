package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	
	CorsoDAO cdao = new CorsoDAO();
	
	public void corsi() {
		cdao.getTuttiICorsi();
	}
	
	public void corsiPerNome() {
		for(Corso c:cdao.getTuttiICorsi()) {
			System.out.println(c.getNome());
		}
	}
	
	public List<String> corsiNomeAll(){
		List<String> corsi = new LinkedList<String>();
		for(Corso c:cdao.getTuttiICorsi()) {
			corsi.add(c.getNome());
		}
		return corsi;
	}

}
