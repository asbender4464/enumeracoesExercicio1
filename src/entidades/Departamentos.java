package entidades;

public class Departamentos {
	
	//Atributo da Classe Departamentos
	private String name;
	
	//Construtor padrão.
	public Departamentos() {
	}

	//Construtor com todas as variáveis.
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
