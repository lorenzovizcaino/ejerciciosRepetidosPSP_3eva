package boletin2_ej1_ByNuria;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Asignatura implements Serializable {
	int id;
	String nombreasig;

	public Asignatura(int id, String nombreasig) {
		super();
		this.id = id;
		this.nombreasig = nombreasig;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreasig() {
		return nombreasig;
	}

	public void setNombreasig(String nombreasig) {
		this.nombreasig = nombreasig;
	}

}
