package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO cdao = new CorsoDAO();
	StudenteDAO sdao = new StudenteDAO();
	
	public List<String> corsiNomeAll(){
		List<String> corsi = new LinkedList<String>();
		for(Corso c:cdao.getTuttiICorsi()) {
			corsi.add(c.getNome());
		}
		return corsi;
	}
	
	public String nomeStudente(int matricola) {
		return sdao.nomeStudenteMatricola(matricola);
	}
	
	public String cognomeStudente(int matricola) {
		return sdao.cognomeStudenteMatricola(matricola);
	}
	
	public String studentiDaCorso(String corso){
		String result="";
		for(Studente stemp:sdao.studentiCorso(corso)) {
			result+=stemp.getMatricola()+" "+stemp.getCognome()+" "+stemp.getNome()+" "+stemp.getCDS()+"1\n";
		}
		return result;
	}
	
	public String corsiSeguitiDaStudente(int matricola) {
		return sdao.corsiCheSegueUnoStudente(matricola);
	}
	
	public boolean trovaStudente(int matricola) {
		return sdao.studentePresente(matricola);
	}
	
	public boolean studenteIscrittoACorso(int matricola, String nomeCorso) {
		return sdao.studenteIscrittoACorso(matricola, nomeCorso);
	}

}
