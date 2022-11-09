package ar.edu.unlam.pb2.parcial;

public class UsuarioConfigurador extends Usuario implements Configurable{

	
	public UsuarioConfigurador(Integer dni, String nombre) {
		super(dni, nombre);
		
	}
	
	@Override
	public Boolean codigoAlarmaIncorrecto(String s, Alarma a) throws codigoAlarmaIncorrecto {
		if(!(s.equals(a.getCodConfiguracion()))){
		     throw new codigoAlarmaIncorrecto("Codigo de alarma incorrecto, no se puede acceder a su configuracion");
		}
		return true;
	}
	
	@Override
	public boolean elUsuarioConfiguradorPuedeAgregarSensor(Alarma a, Sensores s) throws SensorDuplicadoException {
		if(a.agregarSensor(s) == true) {
			return true;
		}
		return false;
		
	}
	
	
	
	

}
