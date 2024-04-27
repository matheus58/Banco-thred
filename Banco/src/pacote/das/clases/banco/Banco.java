package pacote.das.clases.banco;


public class Banco {
    private String nomeBanco;
    private Conta conta;

    public Banco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
    
    public synchronized void transferir(Conta pagador, Conta contaLoja, double quantia){
        if(pagador.getSaldo() >= quantia) {

            double novoValorPagador = pagador.getSaldo() - quantia;
            double saldoContaLoja = contaLoja.getSaldo(); // Aqui estava o problema
            double novoValorContaLoja = saldoContaLoja + quantia;
            pagador.setSaldo(novoValorPagador);
            contaLoja.setSaldo(novoValorContaLoja);
            
            System.out.println("+***************************************+");
            System.out.println("*\t   NOTA DE TRASFERENCIA   \t*");
            System.out.println("+***************************************+");
            System.out.println("* Pagador:" + pagador.getNomeTitular()+"\t\t\t\t*");
            System.out.println("* Beneficiado :" + contaLoja.getNomeTitular()+"\t\t*");
            System.out.println("* Valor:" + quantia+"\t\t\t\t*");
            System.out.println("+***************************************+");
            System.out.println("\n\n");
            
        } else {
            System.out.println();
        }
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}

