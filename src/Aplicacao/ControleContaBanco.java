package Aplicacao;

import java.util.Locale;
import java.util.Scanner;

import Model.Entidades.ContaBanco;
import Model.Excessoes.DominioExcessoes;

public class ControleContaBanco {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scn = new Scanner(System.in);
		try {	
			System.out.println("Entre com os dados da conta bancária:");
			System.out.print("Numero da conta: ");
			int numeroConta = scn.nextInt();
			System.out.print("Cliente: ");
			String nomeCliente = scn.nextLine();
			scn.nextLine();
			System.out.print("Saldo inicial: ");
			double quantiaSaldo = scn.nextDouble();
			System.out.print("Limite para saque: ");
			double quantiaLimite = scn.nextDouble();
			ContaBanco contabanco = new ContaBanco(numeroConta, nomeCliente, quantiaSaldo, quantiaLimite);
			
			System.out.println();
			System.out.print("Entre com a quantia para saque: ");
			double quantiaSaque = scn.nextDouble();
			contabanco.retiradaConta(quantiaSaque);
			System.out.println(contabanco);
		} catch (DominioExcessoes e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Erro inesperado na entrada dos dados!");
		} finally {
			scn.close();
		}
	}

}
