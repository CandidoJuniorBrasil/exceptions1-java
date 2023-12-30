package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Entidades.Reservas;

public class ControleReservas {

	public static void main(String[] args) throws ParseException {
		
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat datado = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Forneça o número do quarto: ");
		int numero = scn.nextInt();
		System.out.print("Data de entrada (dd/mm/yyyy): ");
		Date dataEntrada = datado.parse(scn.next());
		System.out.print("Data de Saída (dd/mm/yyyy): ");
		Date dataSaida = datado.parse(scn.next());
		// System.out.println();
		if (! dataSaida.after(dataEntrada)) {
			System.out.println("Erro na reserva: Data de saída deve ser posterior a data de entrada!" );
		}else {
			Reservas reserva = new Reservas(numero, dataEntrada, dataSaida);
			System.out.println(reserva);
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/mm/yyyy): ");
			dataEntrada = datado.parse(scn.next());
			System.out.print("Data de Saída (dd/mm/yyyy): ");
			dataSaida = datado.parse(scn.next());
			
			Date hoje = new Date();
			if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {
				System.out.println("Erro na reserva: Datas para reserva devem ser datas futuras!" );
			} else if (! dataSaida.after(dataEntrada)) {
				System.out.println("Erro na reserva: Data de saída deve ser posterior a data de entrada!" );
			} else {
			    reserva.atualizaReserva(dataEntrada, dataSaida);
			    System.out.println(reserva);
			}
		}		
		scn.close();
	}

}
