package ar.edu.unlam.pb2.parcial;

import java.util.*;

public class Alarma {

	private Integer idAlarma;
	private String codActivacion;
	private String codConfiguracion;
	private String nombreAlarma;
	private Set<Usuario> listaUsuarios;
	private Set<Accion> listaAcciones;
	private List<Sensores> listaSensores;

	public Alarma(Integer idAlarma, String codActivacion, String codConfiguracion, String nombreAlarma) {
		super();
		this.idAlarma = idAlarma;
		this.codActivacion = codActivacion;
		this.codConfiguracion = codConfiguracion;
		this.nombreAlarma = nombreAlarma;
		this.listaUsuarios = new HashSet<>();
		this.listaAcciones = new TreeSet<>();
		this.listaSensores = new ArrayList<>();
	}

	public Integer getIdAlarma() {
		return idAlarma;
	}

	public void setIdAlarma(Integer idAlarma) {
		this.idAlarma = idAlarma;
	}

	public String getCodActivacion() {
		return codActivacion;
	}

	public void setCodActivacion(String codActivacion) {
		this.codActivacion = codActivacion;
	}

	public String getCodConfiguracion() {
		return codConfiguracion;
	}

	public void setCodConfiguracion(String codConfiguracion) {
		this.codConfiguracion = codConfiguracion;
	}

	public String getNombreAlarma() {
		return nombreAlarma;
	}

	public void setNombreAlarma(String nombreAlarma) {
		this.nombreAlarma = nombreAlarma;
	}

	public Set<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(Set<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public Set<Accion> getListaAcciones() {
		return listaAcciones;
	}

	public void setListaAcciones(Set<Accion> listaAcciones) {
		this.listaAcciones = listaAcciones;
	}

	public List<Sensores> getListaSensores() {
		return listaSensores;
	}

	public void setListaSensores(List<Sensores> listaSensores) {
		this.listaSensores = listaSensores;
	}

	public Boolean agregarUsuario(Usuario u) {
		this.listaUsuarios.add(u);
		return true;
	}

	public Boolean agregarSensor(Sensores sen) throws SensorDuplicadoException {
		for (Sensores s : listaSensores) {
			if (s.getId().equals(sen.getId())){
				
				throw new SensorDuplicadoException("Sensor Duplicado, no se puede agregar");
			}
		}
		this.listaSensores.add(sen);
		return true;
	}

	public boolean activacionDeAlarma() {
		boolean activacionAlarma = false;
		for (Sensores s : listaSensores) {
			if(s.getEstado() == false) {
				activacionAlarma = false;
			}else {
		           activacionAlarma = true;
			}
		}
		return activacionAlarma;
		
	}

	public void agregarAccion(Accion a) {
		this.listaAcciones.add(a);
		
	}
}