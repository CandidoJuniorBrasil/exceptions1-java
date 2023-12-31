package Model.Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

	private Integer numeroQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	private static SimpleDateFormat datado = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservas() {
	}
	
	public Reservas(Integer numeroQuarto, Date dataEntrada, Date dataSaida) {
		this.numeroQuarto = numeroQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}
	
	public long duracao() {
		long diferenca = dataSaida.getTime() - dataEntrada.getTime();
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}
	
	public String atualizaReserva (Date dataEntrada, Date dataSaida) {
		
		Date hoje = new Date();
		if (dataEntrada.before(hoje) || dataSaida.before(hoje)) {
			return "Erro na reserva: Datas para reserva devem ser datas futuras!";
		} 
		if (! dataSaida.after(dataEntrada)) {
			return "Erro na reserva: Data de saída deve ser posterior a data de entrada!";
		} 
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		return null;	
	}
	
	@Override
	public String toString() {
		return "Reserva: Quarto:" + 
				numeroQuarto + 
				", Entrada: " + 
				datado.format(dataEntrada) +
				", Saida: " +
				datado.format(dataSaida) +
				", "+ duracao() +
				" noites.";
	}
}
