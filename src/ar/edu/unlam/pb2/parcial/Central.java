package ar.edu.unlam.pb2.parcial;

import java.util.*;

public class Central {
	
	private Set <Alarma> alarma;
	

	public Central() {
		this.alarma = new HashSet<>();
		
	}

	public Boolean agregarAlarma(Alarma al) throws AlarmaExistente {
		for (Alarma alarma2 : alarma) {
			if(alarma2.getIdAlarma().equals(al.getIdAlarma())) {
				 throw new AlarmaExistente("Alamar inexistente");
			}
			this.alarma.add(al);
			
		}
		return true;
	}
	
	
	

}
