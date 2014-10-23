package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Boletim;

/*Classe que simula um banco de dados*/

public class BaseDados {
	private static BaseDados instancia;
	private List<Boletim> boletins = new ArrayList<Boletim>();
	
	private BaseDados()
	{
		this.configura();
	}
	
	public static BaseDados getInstancia(){
		if(instancia == null){
			instancia = new BaseDados();
		}

		return instancia;
	}
	
	public void configura() {

		if(this.boletins.size() == 0){
			//ADICIONAR BOLETINS
			HashMap<String, String[]> notas = new HashMap<>();
			notas.put("Matemática", new String[] {"5,9","4,8","3,9","5,0"});
			notas.put("História", new String[] {"7,0","9,0","8,5","8,5"});
			notas.put("Georgrafia", new String[] {"6,5","7,0","6,7","6,9"});
			
			Boletim boletim = new Boletim("Maria","3");
			boletim.setNotas(notas);
			this.boletins.add(boletim);
			boletim = new Boletim("Joao", "7");
			boletim.setNotas(notas);
			this.boletins.add(boletim);
			boletim = new Boletim("Pedro","2");
			boletim.setNotas(notas);
			this.boletins.add(boletim);
			boletim = new Boletim("Ana", "8");
			boletim.setNotas(notas);
			this.boletins.add(boletim);	
		}

	}

	public List<Boletim> getBoletins() {
		return boletins;
	}

	public void setBoletins(List<Boletim> boletins){
		this.boletins = boletins; 
	}

}
