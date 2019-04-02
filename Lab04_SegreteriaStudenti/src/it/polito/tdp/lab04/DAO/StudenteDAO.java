package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente> StudentilistAll(){
		String sql = "SELECT * FROM studente";
		List<Studente> result = new LinkedList<Studente>();
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Studente c = new Studente(rs.getInt("matricola"), 
						            rs.getString("cognome"),
						            rs.getString("nome"),
						            rs.getString("CDS"));
				result.add(c);
			}
			conn.close();
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	public String nomeStudenteMatricola(int matricola) {
		String sql = "SELECT nome FROM studente WHERE matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			String nome=null;
			while(rs.next()) {
				nome=rs.getString("nome");
			}
			return nome;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public String cognomeStudenteMatricola(int matricola) {
		String sql = "SELECT cognome FROM studente WHERE matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			String cognome=null;
			while(rs.next()) {
				cognome=rs.getString("cognome");
			}
			return cognome;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Integer> matricoleIscrittiAlCorso(String corsoSel){
		String sql = "SELECT matricola FROM studente WHERE matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corsoSel);
			ResultSet rs = st.executeQuery();
			List<Integer> iscritti = new ArrayList<Integer>();
			while(rs.next()) {
				iscritti.add(rs.getInt("matricola"));
			}
			return iscritti;
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}
	
	public List<Studente> StudenteDaMatricola(int matricola){
		List<Studente> result = new LinkedList<Studente>();
			String sql = "SELECT * FROM studente WHERE matricola=?";
			try {
				Connection conn = ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1, matricola);
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					Studente c = new Studente(rs.getInt("matricola"), 
							            rs.getString("cognome"),
							            rs.getString("nome"),
							            rs.getString("CDS"));
					result.add(c);
				}
			}
			catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			return result;
	}
	
	public List<Studente> studentiCorso(String corso){
		List<Studente> result = new LinkedList<Studente>();
		String sql = "SELECT studente.* FROM iscrizione, corso, studente " + 
				     "WHERE iscrizione.matricola = studente.matricola " + 
				     "AND iscrizione.codins = corso.codins " + 
				     "AND corso.nome=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Studente c = new Studente(rs.getInt("matricola"), 
			            rs.getString("cognome"),
			            rs.getString("nome"),
			            rs.getString("CDS"));
				result.add(c);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/*SELECT corso.nome FROM iscrizione, studente, corso
	WHERE iscrizione.matricola=studente.matricola
	AND corso.codins=iscrizione.codins
	AND iscrizione.matricola='146101'*/
	public String corsiCheSegueUnoStudente(int matricola){
		String corsiSeguiti="";
		String sql = "SELECT corso.nome FROM iscrizione, studente, corso " + 
					 "WHERE iscrizione.matricola=studente.matricola " + 
			     	 "AND corso.codins=iscrizione.codins " + 
				     "AND iscrizione.matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				corsiSeguiti+=rs.getString(1).trim()+"\n";
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return corsiSeguiti;
	}
	
	/*SELECT matricola FROM studente 
	WHERE studente.matricola='5'*/
	public boolean studentePresente(int matricola) {
		boolean trovato=false;
		String sql = "SELECT matricola FROM studente " + 
					 "WHERE studente.matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				trovato=true;
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return trovato;
		
	}
	
	/*SELECT studente.matricola, corso.codins FROM studente, iscrizione, corso
	WHERE studente.matricola=iscrizione.matricola
	AND corso.codins=iscrizione.codins
	AND corso.nome='Economia aziendale'
	AND studente.matricola='146101'*/
	public boolean studenteIscrittoACorso(int matricola, String nomeCorso) {
		boolean trovato=false;
		String sql = "SELECT studente.matricola, corso.codins FROM studente, iscrizione, corso " + 
		       	     "WHERE studente.matricola=iscrizione.matricola " + 
				     "AND corso.codins=iscrizione.codins " + 
				     "AND corso.nome=? " + 
				     "AND studente.matricola=? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nomeCorso);
			st.setInt(2, matricola);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				trovato=true;
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return trovato;
		
	}
	
	
}
