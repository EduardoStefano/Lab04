package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */
		//model.corsiPerNome();
		for(String s:model.corsiNomeAll()) {
			System.out.println(s);
		}

	}

}
