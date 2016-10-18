package modelo;

public class Usuario {
	private String nombre,clave;

	public Usuario(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	public Usuario() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", clave=" + clave + "]";
	}
	
	
}
