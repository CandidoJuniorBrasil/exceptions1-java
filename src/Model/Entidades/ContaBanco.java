package Model.Entidades;

import Model.Excessoes.DominioExcessoes;

public class ContaBanco {
	
	private Integer numeroConta;
	private String cliente;
	private double saldo;
	private double limiteSaque;
	
	public ContaBanco() {	
	}

	public ContaBanco(Integer numeroConta, String cliente, 
			          double saldo, double limiteSaque) throws DominioExcessoes {
		if (numeroConta <= 0) {
			throw new DominioExcessoes ("Numero da conta deve ser maior que zero!");
		} else if (saldo <= 0.0) {
			throw new DominioExcessoes ("Saldo da conta deve ser maior que zero!");
		} else if (limiteSaque <= 0.0) {
			throw new DominioExcessoes ("Limite de saque deve ser maior que zero!");
		} else {
			this.numeroConta = numeroConta;
			this.cliente = cliente;
			this.saldo = saldo;
			this.limiteSaque = limiteSaque;
		}	
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimiteSaque() {
		return limiteSaque;
	}
	
	public void deposito(double quantia) {
		saldo += quantia;
	}
	
	public void retiradaConta(double quantia) throws DominioExcessoes {
		if (saldo < quantia) {
			throw new DominioExcessoes ("Valor da retirada acima do valor em conta disponivel (saldo)!");
		} else if (quantia > limiteSaque) {
			throw new DominioExcessoes ("Valor de saque superior ao valor permitido para esta conta (limite)!");
		} else {
			saldo -= quantia;
		}
		
	}
	
	@Override
	
	public String toString() {
		return "Saldo atual: R$" +
				String.format("%.2f",getSaldo());
	}
}
