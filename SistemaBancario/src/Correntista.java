import java.io.Serializable;

// Classe mãe ou superclasse
public abstract class Correntista implements Serializable {
	
	private static int proxCodigo = 1;
	
	private Conta conta;
	
	private int codigo;
	protected String nome;
	
	
	public Correntista(String nome, Conta conta) {
		codigo = getProxCodigo();
		this.nome = nome;
		this.setConta(conta);
	}
	
	public abstract void exibeIdentificacao();
	
	public static int getProxCodigo() {
		return proxCodigo++;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
}