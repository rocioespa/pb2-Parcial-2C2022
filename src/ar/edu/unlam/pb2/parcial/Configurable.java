package ar.edu.unlam.pb2.parcial;

public interface Configurable {
	
	public boolean elUsuarioConfiguradorPuedeAgregarSensor(Alarma a,Sensores s) throws SensorDuplicadoException;
	
	public Boolean codigoAlarmaIncorrecto(String s, Alarma a) throws codigoAlarmaIncorrecto;

}
