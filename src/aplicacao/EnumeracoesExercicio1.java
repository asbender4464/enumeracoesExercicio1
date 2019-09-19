package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoPorHora;
import entidades.Departamentos;
import entidades.Trabalhador;
import entidades.enums.NivelDoTrabalhador;

public class EnumeracoesExercicio1 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.FRANCE);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Informe o nome do departamento: ");
		String nomeDoDepartamento = sc.nextLine();
		System.out.println("Informe os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeDoFuncionario = sc.nextLine();
		System.out.print("Nível de experiência: ");
		String nivelDeExperiencia = sc.nextLine();
		System.out.print("Salário base: ");
		Double salarioBase = sc.nextDouble();
		
		//Definidas as variáveis é preciso 'instanciar' o objeto/classe Trabalhador.
		Trabalhador trabalhador = new Trabalhador(nomeDoFuncionario, NivelDoTrabalhador.valueOf(nivelDeExperiencia),salarioBase, new Departamentos(nomeDoDepartamento));
		
		System.out.print("Quantos contratos este funcionário terá? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Informe os dados do contrato #" + i + ": ");
			System.out.print("Digite a data no formato DD/MM/YYYY: ");
			Date dataDoContrato = sdf.parse(sc.next());
			System.out.print("Informe o valor por hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Informa a duração do contrato em horas: ");
			int duracaoDoContrato = sc.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(dataDoContrato, valorPorHora, duracaoDoContrato);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.println("Informe MÊS e ANO para calcular o salário (MM/YYYY): ");
		String mesEano = sc.next();
		int mes = Integer.parseInt(mesEano.substring(0,2));
		int ano = Integer.parseInt(mesEano.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamentos().getName());
		System.out.println("Salario em " + mesEano + ": " + String.format("%.2f", trabalhador.income(ano,mes)));
		
		
		sc.close();
	}

}
