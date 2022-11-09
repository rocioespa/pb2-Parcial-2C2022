package ar.edu.unlam.pb2.parcial;

public class UsuarioActivador extends Usuario implements Activable{

	public UsuarioActivador(Integer dni, String nombre) {
		super(dni, nombre);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean activacionDeAlarmaDelUsuarioActivador(Alarma a) {
		if(a.activacionDeAlarma()==false) {
			return false;
		}
		return true;
	}

	
}
