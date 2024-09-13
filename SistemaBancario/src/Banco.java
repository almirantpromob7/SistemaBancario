import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

//Classe filha ou subclasse
public class Banco{
	
	private ArrayList<Correntista> listaDeClientes;
	
	public Banco() {
		listaDeClientes = new ArrayList<Correntista>();
	}
	
	
	
	public ArrayList<Correntista> getListaDeClientes() {
		return listaDeClientes;
	}



	public void setListaDeClientes(ArrayList<Correntista> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}



	public void salvaClientela() throws IOException{
		
		File file = new File("database.dat");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Correntista c : listaDeClientes) {
			oos.writeObject(c);
		}
	}
	
	public void leClientela() throws IOException, ClassNotFoundException {
		
		File file = new File("database.dat");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = null;
		
		try {
			while ((obj = ois.readObject()) != null) {
				this.listaDeClientes.add((Correntista) obj);
			}
		} catch (EOFException e) {
			
		}
		finally {
			ois.close();
		}
	}
	
	public static void main(String args[]) {
		
		ContaFisica conta = new ContaFisica();
		conta.deposito(1000);
		
		CorrentistaFisico marcos = new CorrentistaFisico("Marcos", conta);
		
		CorrentistaFisico julia = new CorrentistaFisico("Julia", conta);
		
		SaqueATM saqueMarcos = new SaqueATM(marcos.getConta(), 500);
		
		SaqueATM saqueJulia = new SaqueATM(julia.getConta(), 300);
		
		saqueMarcos.start();
		saqueJulia.start();
		
		Banco banco = new Banco();
		
	/*	CorrentistaFisico c1 = new CorrentistaFisico("João", new ContaFisica()); 
	    banco.getListaDeClientes().add(c1);
		
		CorrentistaFisico c2 = new CorrentistaFisico("Maria", new ContaFisica());
	    banco.getListaDeClientes().add(c2);
		
		CorrentistaFisico c3 = new CorrentistaFisico("Lucas", new ContaFisica());
		banco.getListaDeClientes().add(c3);
		
		CorrentistaFisico c4 = new CorrentistaFisico("Ana", new ContaFisica());
		banco.getListaDeClientes().add(c4);
		
		CorrentistaJuridico cJuridico = new CorrentistaJuridico("ACME LLC", "Pedro", new ContaJuridica());
		banco.getListaDeClientes().add(cJuridico);
		
		try {
			banco.salvaClientela();
		} catch (IOException e) {

		}
		
		/*
		try {
			banco.leClientela();
			
			for(Correntista c : banco.getListaDeClientes()){
			
			     System.out.println(c.getNome());
			
			}
			
		}
		catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		

		Iterator<Correntista> it = listaDeClientes.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.hasNext().getNome());
		}
		*/
		
		File meuArquivo = new File("exemplo.txt");
		
		/*
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(meuArquivo, true));

			writer.write("\nAté logo");

			writer.close();

		} catch (Exception e) {

		}
		
		try {
		
		     BufferedReader reader = new BufferedReader(new FileReader(meuArquivo));
		     
		     String s = "";
		     while((s = reader.readLine()) != null) {
		    	 System.out.println(s);
		     }
		
		     reader.close();
		}
		catch(Exception e){
			
		}
		*/
		/*
		c1.exibeIdentificacao();
		c2.exibeIdentificacao();
		c3.exibeIdentificacao();
		c4.exibeIdentificacao();
		cJuridico.exibeIdentificacao();
		*/
		
	    // Correntisa cc =  new CorrentistaFisico("Sergio");
		// cc.exibeIdentificacao();
		
		/*
		try {
			double valorParcela = c1.getConta().simulaEmprestimo(1000.00, 12);
			System.out.printf("Valor das parcelas %.2f%n", valorParcela);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Digite valores válidos");
		}
		*/
	}
}