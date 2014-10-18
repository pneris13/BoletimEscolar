package model;
import java.util.ArrayList;
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
			this.boletins.add(new Boletim("Maria","3"));
			this.boletins.add(new Boletim("Joao", "7"));
			this.boletins.add(new Boletim("Pedro","2"));
			this.boletins.add(new Boletim("Ana", "8"));			
		}

	}

	public List<Boletim> getBoletins() {
		return boletins;
	}

	public void setBoletins(List<Boletim> boletins){
		this.boletins = boletins; 
	}

}
