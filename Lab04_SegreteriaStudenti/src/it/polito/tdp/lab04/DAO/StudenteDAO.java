package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
