package pacote.das.clases.banco;

import java.security.PublicKey;
import java.util.List;
import java.util.Random;

public class Cliente extends Thread {
	private String nome;
    private Conta contaCliente;
    private double saldoInicial;
    private Banco banco;
    private Conta conta;
    private Loja[] loja;

    public Cliente(String nome, Conta contaCliente,Banco banco,Loja[] loja) {
        this.nome = nome;
        this.contaCliente = contaCliente;
        this.banco = banco;
        this.loja = loja;
        contaCliente.setSaldo(1000);
    }
    public void run() {
        Random random = new Random();
        do  {
        	int indiceLoja = random.nextInt(2);
        	Loja qualLoja = loja[indiceLoja];
        	Conta contaLoja = qualLoja.getContaLoja();
            int valorTransferencia = random.nextInt(2) == 0 ? 100 : 200; // Aleatoriamente escolhe 100 ou 200
           // banco.trasferir(contaCliente, contaLoja, valorTransferencia);
            synchronized (this) {
           	 banco.transferir(contaCliente, contaLoja, valorTransferencia);
   		}
        }while(this.contaCliente.getSaldo() > 0);
    }
    
    public Conta getConta() {
        return contaCliente;
    }

    public void setConta(Conta contaCliente) {
        this.contaCliente =  contaCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public double getSaldoInicial() {
		return saldoInicial;
	}

}

