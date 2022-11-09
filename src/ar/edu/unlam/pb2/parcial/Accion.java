package ar.edu.unlam.pb2.parcial;

public class Accion implements Comparable<Accion>{
	
	private Integer idAccion;
	private Alarma alarma;
	private Usuario usuario;
	private String fecha;
	private Tipo tipoDeOperacion;
	public Accion(Integer idAccion, Alarma alarma, Usuario usuario, String fecha, Tipo tipoDeOperacion) {
		super();
		this.idAccion = idAccion;
		this.alarma = alarma;
		this.usuario = usuario;
		this.fecha = fecha;
		this.tipoDeOperacion = tipoDeOperacion;
	}
	public Integer getIdAccion() {
		return idAccion;
	}
	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}
	public Alarma getAlarma() {
		return alarma;
	}
	public void setAlarma(Alarma alarma) {
		this.alarma = alarma;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Tipo getTipoDeOperacion() {
		return tipoDeOperacion;
	}
	public void setTipoDeOperacion(Tipo tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}
	@Override
	public int compareTo(Accion o) {
		if(this.tipoDeOperacion.equals(Tipo.CONFIGURACION)) {
			return this.idAccion.compareTo(o.idAccion);
		}else{
		return tipoDeOperacion.compareTo(o.tipoDeOperacion);
		}
	}
	
	@Override
	public String toString() {
		return "Accion [idAccion=" + idAccion + ", fecha=" + fecha
				+ ", tipoDeOperacion=" + tipoDeOperacion + "]";
	}
	
	

}
