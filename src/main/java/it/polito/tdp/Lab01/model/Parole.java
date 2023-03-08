package it.polito.tdp.Lab01.model;

import java.util.*;

public class Parole {
	
	LinkedList<String> listaParole;
		
	public Parole() {
		listaParole = new LinkedList<String>(); 	}
	
	public void addParola(String p) {
		boolean flag = false;
		
		for(String s: listaParole) {
			if(s.compareTo(p)==0) 
				flag = true; }
		
		if(flag == false) {
			listaParole.add(p);  }  }
	
	public List<String> getElenco() {
		Collections.sort(listaParole, String.CASE_INSENSITIVE_ORDER);
		return listaParole;   }
	
	public void reset() {
		listaParole.clear();   }
	
	public void eliminaParola(String parolaDaEliminare) {
		listaParole.remove(parolaDaEliminare);   }
}