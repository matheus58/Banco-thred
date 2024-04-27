package pacote.das.clases.banco;

import java.util.List;

public class Loja {
	private String nome ;
	private List<Funcionario> funcionarios;
	private Conta contaLoja;
	private double valorCompra;
	private Cliente cliente;
	
	
	public Loja( String nome, List<Funcionario> funcionarios, Conta contaLoja) {
		this.nome = nome;
		this.funcionarios = funcionarios;
		this.contaLoja = contaLoja;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Conta getContaLoja() {
		return contaLoja;
	}
	public void setContaLoja(Conta contaLoja) {
		this.contaLoja = contaLoja;
	}

}
