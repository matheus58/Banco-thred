package pacote.das.clases.banco;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        
    	// Criar o banco
        Banco santander = new Banco("Santander");
        
        // Criar a conta
        Conta contaMatheus = new Conta("Matheus", 1, 0, santander);
        Conta contaYan = new Conta("Yan", 2, 0, santander);
        Conta contaMaria = new Conta("Maria", 3, 0, santander);
        Conta contaPedro = new Conta("Pedro", 4, 0, santander);
        Conta contaBruno = new Conta("Bruno", 5, 0, santander);
        
        //conta funcionarios
        Conta contaKerlen = new Conta("Kerlen", 6, 0, santander);
        Conta contakaylane = new Conta("Kaylane", 7, 0, santander);
        Conta contaJone = new Conta("Jone", 8, 0, santander);
        Conta contaKetlen = new Conta("Ketlen", 9, 0, santander);
        
        //conta investimento funcionarios:
        Conta contaKerlenInvestimento = new Conta("Kerlen", 10, 0, santander);
        Conta contakaylaneInvestimento  = new Conta("Kaylane", 11, 0, santander);
        Conta contaJoneInvestimento  = new Conta("Jone", 12, 0, santander);
        Conta contaKetlenInvestimento  = new Conta("Ketlen", 13, 0, santander);
        
        //conta loja:
        Conta contaMC = new Conta("mc_Donalds", 14, 0, santander);
        Conta contaBK = new Conta("BurgeKing",15,0,santander);
        //criando loja
        List<Funcionario> funcionariosMC = new ArrayList<>();
        List<Funcionario> funcionariosBK = new ArrayList<>();
        
        Loja mc = new Loja("mc_donalds",funcionariosMC, contaMC);
        Loja bk = new Loja("Burgue_king",funcionariosBK,contaBK);   
        List<Loja>lojas = new ArrayList<>();
        lojas.add(bk);
        lojas.add(mc);
            
        // Criar o funcionario e associar a conta:
        Funcionario kerlen = new Funcionario("Kerlen", contaKerlen, contakaylaneInvestimento, santander, mc);
        Funcionario kaylane = new Funcionario("Kaylane", contakaylane, contakaylaneInvestimento, santander, mc);
        Funcionario jone = new Funcionario("jone", contaJone, contaJoneInvestimento, santander, bk);
        Funcionario ketlen = new Funcionario("ketlen", contaKetlen, contaKetlenInvestimento, santander, bk);

        
        //Lista dos funcionarios
        //mc

        funcionariosMC.add(kerlen);
        funcionariosMC.add(kaylane);
        
        //bk

        funcionariosBK.add(jone);
        funcionariosBK.add(ketlen);
        
        
        Loja[] TodasLojas = {bk,mc};
        
        // Criar o cliente e associar a conta:
        Cliente matheus = new Cliente("matheus", contaMatheus,santander,TodasLojas);
        Cliente yan = new Cliente("Yan", contaYan,santander,TodasLojas);
        Cliente maria = new Cliente("Maria", contaMaria,santander,TodasLojas);
        Cliente pedro = new Cliente("Pedro", contaPedro,santander,TodasLojas);
        Cliente bruno = new Cliente("Bruno", contaBruno,santander,TodasLojas);
        // printando saldo das contas 
        System.out.println("+***************************************************************+");
        System.out.println("*\t\t\tsaldo das contas\t\t\t*");
        System.out.println("+***************************************************************+");
        System.out.println("* - SALDO DAS CONTAS CLIENTES :\t\t\t\t\t*");
        System.out.println("*\tMatheus: R$" + contaMatheus.getSaldo()+"\t\t\t\t\t*");
        System.out.println("*\tYan: R$"+contaYan.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tMaria: R$"+contaMaria.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tPedro: R$"+contaPedro.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tBruno: R$"+contaBruno.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("+***************************************************************+");
        System.out.println("* - SALDO DAS CONTAS LOJAS :\t\t\t\t\t*");
        System.out.println("*\tMc Donalds: R$" + contaMC.getSaldo()+ "\t\t\t\t\t*");
        System.out.println("*\tBurgue King: R$" + contaBK.getSaldo()+ "\t\t\t\t\t*");
        System.out.println("+***************************************************************+");
        
        matheus.start();
        matheus.join(); 
        yan.start();
        yan.join(); 
        maria.start();
        maria.join(); 
        pedro.start();
        pedro.join(); 
        bruno.start();
        bruno.join(); 
        
        // printando saldo das contas 
        System.out.println("+***************************************************************+");
        System.out.println("*\t\t\tsaldo das contas \t\t\t*");
        System.out.println("+***************************************************************+");
        System.out.println("* - SALDO DAS CONTAS CLIENTES :\t\t\t\t\t*");
        System.out.println("*\tMatheus: R$" + contaMatheus.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tYan: R$"+contaYan.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tMaria: R$"+contaMaria.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tPedro: R$"+contaPedro.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("*\tBruno: R$"+contaBruno.getSaldo()+"\t\t\t\t\t\t*");
        System.out.println("+***************************************************************+");
        System.out.println("* - SALDO DAS CONTAS LOJAS :\t\t\t\t\t*");
        System.out.println("*\tMc Donalds: R$" + contaMC.getSaldo()+ "\t\t\t\t\t*");
        System.out.println("*\tBurgue King: R$" + contaBK.getSaldo()+ "\t\t\t\t\t*");
        System.out.println("+***************************************************************+");
        
        // Iniciar as threads dos funcionários
        kerlen.start();
        kerlen.join();
        kaylane.start();
        kaylane.join();
        jone.start();
        jone.join();
        ketlen.start();
        kerlen.join();
        System.out.println("+***************************************************************+");
        System.out.println("*\t\t    PAGAMENTO DOSFUNCIONARIOS\t\t        *");
        System.out.println("+***************************************************************+");
        System.out.println("* - SALDO DAS CONTAS FUNCIONARIOS(antes) :\t\t\t*");
        System.out.println("+***************************************************************+");
        System.out.println("*\t Mc Donalds:\t\t\t\t\t\t*");
        System.out.println("*\t\t kerlen:\t\t\t\t\t*");
        System.out.println("*\t\t\t Saldo conta corente :" + kerlen.getContaCorente().getSaldo()+"\t\t*");
        System.out.println("*\t\t\t Saldo conta investimento :" + kerlen.getContaInvestimeto().getSaldo()+"\t\t*");
        System.out.println("*\t\t kaylane:\t\t\t\t\t*");
        System.out.println("*\t\t\t Saldo conta corente :" + kaylane.getContaCorente().getSaldo()+"\t\t*");
        System.out.println("*\t\t\t Saldo conta investimento :" + kaylane.getContaInvestimeto().getSaldo()+"\t\t*");
        System.out.println("*\t Burgue King:\t\t\t\t\t\t*");
        System.out.println("*\t\t Jone:\t\t\t\t\t\t*");
        System.out.println("*\t\t\t Saldo conta corente :" + jone.getContaCorente().getSaldo()+"\t\t*");
        System.out.println("*\t\t\t Saldo conta investimento :" + jone.getContaInvestimeto().getSaldo()+"\t\t*");
        System.out.println("*\t\t ketlen:\t\t\t\t\t*");
        System.out.println("*\t\t\t Saldo conta corente :" + ketlen.getContaCorente().getSaldo()+"\t\t*");
        System.out.println("*\t\t\t Saldo conta investimento :" +ketlen.getContaInvestimeto().getSaldo()+"\t\t*");
        System.out.println("+***************************************************************+");
        System.out.println("* - SALDO DAS CONTAS LOJAS :\t\t\t\t\t*");
        System.out.println("*\tMc Donalds: R$" + contaMC.getSaldo()+ "\t\t\t\t\t*");
        System.out.println("*\tBurgue King: R$" + contaBK.getSaldo()+ "\t\t\t\t\t*");
    }
}
