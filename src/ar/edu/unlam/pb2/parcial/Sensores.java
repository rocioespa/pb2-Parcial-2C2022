package ar.edu.unlam.pb2.parcial;

public class Sensores {
	
	private Integer id;
	private Boolean estado;
	public Sensores(Integer id, Boolean estado) {
		super();
		this.id = id;
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	

}
