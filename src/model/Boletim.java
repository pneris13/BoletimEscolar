package model;

import java.util.HashMap;
import java.util.Map;


public class Boletim {
	public String nome;
	public String serie;
//	private Map<materia, fase> notas; //DEVEMOS FAZER UM MAP PARA ALOCAR NOTAS
		//fase: nota 1, nota 2, nota 3 e media final
		//materia:portugues, matematica, ingles, ciencias  
	
	public Boletim(String nome, String serie) {
		this.nome = nome;
		this.serie = serie;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}

}
