package entidades;

public class Departamentos {
	
	//Atributo da Classe Departamentos
	private String name;
	
	//Construtor padr�o.
	public Departamentos() {
	}

	//Construtor com todas as vari�veis.
	public Departamentos(String name) {
		this.name = name;
	}

	//GETs e SETs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
