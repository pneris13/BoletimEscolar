package controller;

import java.util.List;
import model.Boletim;
import model.BaseDados;

public class BoletimBusiness {
BaseDados bd = BaseDados.getInstancia();
	
	public BoletimBusiness() {
		super();
	}
	
	public Boletim Consulta(String nome, String serie) {

		Boletim consulta = null;
		List<Boletim> be = bd.getBoletins();
		
		
		if(nome != "" && serie != ""){
			for (int j = 0; j < be.size(); j++) {
				if (be.get(j).getNome().equals(nome) && be.get(j).getSerie().equals(serie)){
					consulta = be.get(j);
				}
			}
		}else{
			//mensagem de erro
		}
		
		return consulta;
	}
}
