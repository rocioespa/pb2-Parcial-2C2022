package ar.edu.unlam.pb2.parcial;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCentral {

	@Test
	public void queSePuedaAgregarUnaAlarmaALaCentral() throws AlarmaExistente {
		Central c = new Central();
		Alarma al = new Alarma(1,"PPRJ","SASO","Incendios");
		assertTrue(c.agregarAlarma(al));
	}
	
	@Test
	public void queSeRegistrarUnNuevoUsuario() throws AlarmaExistente {
		Central c = new Central();
		Alarma al = new Alarma(1,"PPRJ","SASO","Incendios");
		assertTrue(c.agregarAlarma(al));
		UsuarioConfigurador uc = new UsuarioConfigurador(43446347,"Rocio");
		assertTrue(al.agregarUsuario(uc));
		Accion a = new Accion (101,al,uc,"9/11/2022",Tipo.CONFIGURACION);
		al.agregarAccion(a);
		
	}
	
	@Test (expected = codigoAlarmaIncorrecto.class)
	public void queSiAlAgregarUnUsuarioALaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() throws AlarmaExistente, codigoAlarmaIncorrecto {
		Central c = new Central();
		Alarma al = new Alarma(1,"PPRJ","SASO","Incendios");
		assertTrue(c.agregarAlarma(al));
		UsuarioConfigurador uc = new UsuarioConfigurador(43446347,"Rocio");
		assertTrue(al.agregarUsuario(uc));
		assertTrue(uc.codigoAlarmaIncorrecto("pepe",al));
		Accion a = new Accion (101,al,uc,"9/11/2022",Tipo.CONFIGURACION);
		al.agregarAccion(a);
	}
	
	@Test (expected = SensorDuplicadoException.class)
	public void queAlAgregarUnSensorDuplicadoSeLanceUnaSensorDuplicadoException() throws AlarmaExistente, SensorDuplicadoException {
		Central c = new Central();
		Alarma al = new Alarma(1,"PPRJ","SASO","Incendios");
		UsuarioConfigurador uc = new UsuarioConfigurador(43446347,"Rocio");
		assertTrue(c.agregarAlarma(al));
		Sensores s = new Sensores(1,false);
		Sensores s1 = new Sensores(1,false);
		al.agregarSensor(s);
		al.agregarSensor(s1);
		Accion a = new Accion (101,al,uc,"9/11/2022",Tipo.CONFIGURACION);
		al.agregarAccion(a);
		
	}
	
	@Test 
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws AlarmaExistente, SensorDuplicadoException {
		Central c = new Central();
		Alarma al = new Alarma(1,"PPRJ","SASO","Incendios");
		assertTrue(c.agregarAlarma(al));
		UsuarioActivador ua = new UsuarioActivador(32244492,"Dany");
		Sensores s = new Sensores(1,true);
		Sensores s1 = new Sensores(2,false);
		al.agregarSensor(s);
		al.agregarSensor(s1);
		assertFalse(ua.activacionDeAlarmaDelUsuarioActivador(al));
		Accion a = new Accion (101,al,ua,"9/11/2022",Tipo.DESACTIVACION);
		al.agregarAccion(a);
	}
	
	@Test 
	public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAccionEsDeTipoConfiguracionOrdenadaPorIdDeAccion() throws AlarmaExistente, codigoAlarmaIncorrecto, SensorDuplicadoException {
		Central c = new Central();
		Alarma al = new Alarma(1,"PPRJ","SASO","Incendios");
		UsuarioConfigurador uc = new UsuarioConfigurador(43446347,"Rocio");
		Accion ingresarCodigoCorrecto = new Accion (101,al,uc,"9/11/2022",Tipo.CONFIGURACION);
		Accion a = new Accion (103,al,uc,"9/11/2022",Tipo.CONFIGURACION);
		al.agregarAccion(ingresarCodigoCorrecto);
		al.agregarAccion(a);
		
		UsuarioActivador ua = new UsuarioActivador(32244492,"Dany");
		Accion activacionAlarmas = new Accion (102,al,ua,"9/11/2022",Tipo.DESACTIVACION);
		al.agregarAccion(activacionAlarmas);
		
		System.out.println(al.getListaAcciones().toString());
	}

}
