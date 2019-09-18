package entidades;

import java.util.Date;

public class ContratoPorHora {
	
	//Atributos da classe.
	private Date data;
	private Double salarioPorHoras;
	private Integer horas;
	
	//Construtor padrão.
	public ContratoPorHora() {
	}

	//Costrutor com todas as variáveis.
	public ContratoPorHora(Date data, Double salarioPorHoras, Integer horas) {
		this.data = data;
		this.salarioPorHoras = salarioPorHoras;
		this.horas = horas;
	}

	//GETs e SETs
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getSalarioPorHoras() {
		return salarioPorHoras;
	}

	public void setSalarioPorHoras(Double salarioPorHoras) {
		this.salarioPorHoras = salarioPorHoras;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	//Definindo o MÉTODO para calcular o Valor Total por contrato.
	public double valorTotal() {
		return salarioPorHoras * horas;
	}
	
}
