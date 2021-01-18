/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package taller1;

public class V_estudiante_matricula {
	public V_estudiante_matricula() {
	}
	
	private int ci;
	
	private String nombre;
	
	private String ap;
	
	private String am;
	
	private String correo;
	
	private String telefono;
	
	private Long nromatriculaciones;
	
	private void setCi(int value) {
		this.ci = value;
	}
	
	public int getCi() {
		return ci;
	}
	
	public int getORMID() {
		return getCi();
	}
	
	private void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setAp(String value) {
		this.ap = value;
	}
	
	public String getAp() {
		return ap;
	}
	
	private void setAm(String value) {
		this.am = value;
	}
	
	public String getAm() {
		return am;
	}
	
	private void setCorreo(String value) {
		this.correo = value;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	private void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	private void setNromatriculaciones(long value) {
		setNromatriculaciones(new Long(value));
	}
	
	private void setNromatriculaciones(Long value) {
		this.nromatriculaciones = value;
	}
	
	public Long getNromatriculaciones() {
		return nromatriculaciones;
	}
	
	public String toString() {
		return String.valueOf(getCi());
	}
	
}
