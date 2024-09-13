import java.io.Serializable;

public interface Conta extends Serializable{

	public void extrato();
	
	public void deposito(double valor);
	
	public void saque(double valor);
	
	//cf = capital financiado, n = meses
	public double simulaEmprestimo(double cf, int n);
	
}

class SaqueATM extends Thread {
	
	private Conta conta;
	private double saque;
	
	public SaqueATM(Conta conta, double saque) {
		this.conta = conta;
		this.saque = saque;
	}
	
	public void run() {
		conta.saque(saque);
	}
	
}
