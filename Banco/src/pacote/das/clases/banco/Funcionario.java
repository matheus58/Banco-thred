package pacote.das.clases.banco;


public class Funcionario extends Thread{
	
    private String nomeFuncionario;
    private Conta contaCorente;
    private Conta contaInvestimeto;
    private Banco banco;
    private Loja loja;

    public Funcionario(String nomeFuncionario, Conta contaCorente, Conta contaInvestimeto, Banco banco, Loja loja) {
        this.nomeFuncionario = nomeFuncionario;
        this.contaCorente = contaCorente;
        this.contaInvestimeto = contaInvestimeto;
        this.banco = banco;
        this.loja = loja;
        //start();
    }

    @Override
    public void run() {
        receberSalario();
    }

    private void receberSalario() {
        double salario = 1400.0;

        // Verificando se a loja existe antes de acessar
        if (loja != null) {
            synchronized (loja) {
                if (loja.getContaLoja().getSaldo() >= salario) {
                    banco.transferir(loja.getContaLoja(), contaCorente, salario);
                    System.out.println("Salário de " + nomeFuncionario + " pago pela " + loja.getNome() + ". Conta de " + nomeFuncionario + " (antes do investimento): R$" + contaCorente.getSaldo());

                    // Realizando o investimento
                    double valorInvestimento = salario * 0.2;
                    banco.transferir(contaCorente, contaInvestimeto, valorInvestimento);
                    //System.out.println("\n(Funcionário) - " + nomeFuncionario + " investiu R$" + valorInvestimento + ", Saldo atualizado:\n- Conta de investimento = R$" + contaInvestimeto.getSaldo() + " e Conta do salario(líquido) = R$" + contaCorente.getSaldo());
                } else {
                    //System.out.println("A " + loja.getNome() + " não possui saldo suficiente para pagar o salário de " + nomeFuncionario + ". (Saldo atual da " + loja.getNome() + ": R$" + loja.getContaLoja().getSaldo() + ")");
                }
            }
        } else {
            //System.out.println("Erro: Atributo 'loja' está nulo para o funcionário " + nomeFuncionario);
        }
    }


    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Conta getContaCorente() {
        return contaCorente;
    }

    public void setContaCorente(Conta contaCorente) {
        this.contaCorente = contaCorente;
    }

    public Conta getContaInvestimeto() {
        return contaInvestimeto;
    }

    public void setContaInvestimeto(Conta contaInvestimeto) {
        this.contaInvestimeto = contaInvestimeto;
    }
}
