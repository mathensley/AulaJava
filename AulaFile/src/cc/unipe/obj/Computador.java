package cc.unipe.obj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Computador implements Serializable{
	private static final long serialVersionUID = 1L;
	private String marca;
	private String modelo;
	List<Computador> pc = new ArrayList<Computador>();
	
	
	
	public Computador() {
		super();
	}
	
	public Computador(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String toString(){
		return "\nMarca: " + this.marca + "\nModelo: " + this.modelo;
	}
}
