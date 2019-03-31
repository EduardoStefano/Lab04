package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbCorsi; 
    
    @FXML
    private Button btnCercaIscritti;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtStudente;
    
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;
    
    @FXML
    private CheckBox chkMatricola;

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscritti(ActionEvent event) {

    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }
    
    @FXML
    void doCompleta(ActionEvent event) {
    	int matricola = 0;
    	try {
    		matricola = Integer.parseInt(txtStudente.getText());
    	}
    	catch(NumberFormatException e) {
    		
    	}
    	
    	if(model.nomeStudente(matricola)!=null && model.cognomeStudente(matricola)!=null) {
    		txtNome.appendText(model.nomeStudente(matricola));
    		txtCognome.appendText(model.cognomeStudente(matricola));
    	}
    		
    }

    @FXML
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtStudente != null : "fx:id=\"txtStudente\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert chkMatricola != null : "fx:id=\"chkMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model=model;
    	List<String> list = new ArrayList<String>(model.corsiNomeAll());
    	cmbCorsi.getItems().add("nessun corso");
    	cmbCorsi.getItems().addAll(list);
    }
}