package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelDoTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelDoTrabalhador nivel; //Relaciona a 'entidade.enum' com a vari�vel 'nivel'.
	private Double salarioBase;
	
	//Associa��es entre 'Trabalhador e Departamento' e 'Trabalhador e Contrato por Hora'.
	//Trata-se de uma 'COMPOSI��O DE OBJETOS'.
	
	//Rela��o de 1 para 1.
	private Departamentos departamentos;
	
	//Rela��o de 1 para muitos, implica utiliza��o de "LISTAS".
	//A lista ser� instanciada na pr�pria declara��o da vari�vel 'contratos'.
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	
	//Construtor padr�o.
	public Trabalhador() {
	}

	//Construtor com 'quase' todas as vari�veis, EXCETO a do tipo LISTA, neste caso, atribu�da a 'contratos'.
	public Trabalhador(String nome, NivelDoTrabalhador nivel, Double salarioBase, Departamentos departamentos) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamentos = departamentos;
	}

	//GETs e SETs.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDoTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelDoTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamentos getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public List<ContratoPorHora> getContratos() {
		return contratos;
	}
	
	//Definindo os M�TODOS.
	
	public void adicionarContrato (ContratoPorHora contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato (ContratoPorHora contrato) {
		contratos.remove(contrato);
	}

	public double income (int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (ContratoPorHora c: contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH); //O calend�rio come�a em '0', raz�o de se colocar o '+1'.
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	
}