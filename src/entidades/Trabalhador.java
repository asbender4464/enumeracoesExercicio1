package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelDoTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelDoTrabalhador nivel; //Relaciona a 'entidade.enum' com a variável 'nivel'.
	private Double salarioBase;
	
	//Associações entre 'Trabalhador e Departamento' e 'Trabalhador e Contrato por Hora'.
	//Trata-se de uma 'COMPOSIÇÃO DE OBJETOS'.
	
	//Relação de 1 para 1.
	private Departamentos departamentos;
	
	//Relação de 1 para muitos, implica utilização de "LISTAS".
	//A lista será instanciada na própria declaração da variável 'contratos'.
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	
	//Construtor padrão.
	public Trabalhador() {
	}

	//Construtor com 'quase' todas as variáveis, EXCETO a do tipo LISTA, neste caso, atribuída a 'contratos'.
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
	
	//Definindo os MÉTODOS.
	
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
			int c_mes = 1 + cal.get(Calendar.MONTH); //O calendário começa em '0', razão de se colocar o '+1'.
			if (ano == c_ano && mes == c_mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
	
}