package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.Entidades.Reservas;
import Model.Excessoes.DominioExcessoes;

public class ControleReservas {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		SimpleDateFormat datado = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Forneça o número do quarto: ");
			int numero = scn.nextInt();
			System.out.print("Data de entrada (dd/mm/yyyy): ");
			Date dataEntrada = datado.parse(scn.next());
			System.out.print("Data de Saída (dd/mm/yyyy): ");
			Date dataSaida = datado.parse(scn.next());
		
			Reservas reserva = new Reservas(numero, dataEntrada, dataSaida);
			System.out.println(reserva);
			
			System.out.println();
			System.out.println("Entre com os dados para atualizar a reserva:");
			System.out.print("Data de entrada (dd/mm/yyyy): ");
			dataEntrada = datado.parse(scn.next());
			System.out.print("Data de Saída (dd/mm/yyyy): ");
			dataSaida = datado.parse(scn.next());
			
		    reserva.atualizaReserva(dataEntrada, dataSaida);
			System.out.println(reserva);
		} catch (ParseException e) {
			System.out.println("Invalido formato para a data!");
		} catch (DominioExcessoes e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Entrada de dados divergente do valor esperado!");
		}
		
		scn.close();
	}

}
