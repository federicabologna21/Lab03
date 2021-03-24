package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	List <String> dizionario = new LinkedList<>();
	
	public void loadDictionary(String language) {
		
	 this.dizionario.clear();
		if (language.equals("Italian")) {
			
			try {
				
				FileReader fr = new FileReader ("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					dizionario.add(word);
					
				}
				
				br.close();
			}catch (IOException e) {
				System.out.println("Errore nella lettura da file");
			}
		}
		
		else if (language.equals("English")) {
			
			try {
				
				FileReader fr = new FileReader ("src/main/resources/English.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					dizionario.add(word);
					
				}
				
				br.close();
			}catch (IOException e) {
				System.out.println("Errore nella lettura da file");
			}
			
		}
	}
	
	// CREO UN METODO CHE CREA UNA LISTA CON TUTTE LE PAROLE 
	// SCRITTE DALL'UTENTE, SIA GIUSTE (true) CHE SBAGLIATE (false)
	public List <RichWord> spellCheckText(List<String> inputTextList){
		
		List<RichWord> paroleScritte = new LinkedList<>();
		
		for (String s : inputTextList) {
			if (this.dizionario.contains(s)) {
				RichWord r = new RichWord (s, true);
				paroleScritte.add(r);
				
			}
			else {
				RichWord r = new RichWord (s, false);
				paroleScritte.add(r);
			}
		}
		return paroleScritte;
		
	}
	
	// CREO UN METODO CHE MI RESTITUISCE LE PAROLE SBAGLIATE
	// A PARTIRE DALLE PAROLE SCRITTE DALL'UTENTE
	public List <String> controlloParoleSbagliate(List<RichWord> paroleScritte){
		
		List <String> listaParoleSbagliate = new LinkedList<>(); 
		
		for (RichWord r : paroleScritte) {
			if (r.isCorretta() == false) {
				listaParoleSbagliate.add(r.getParola());
			}
		}
		return listaParoleSbagliate;
	}

}
