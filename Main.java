import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Olá!");

        Pessoa pessoa1 = new Pessoa("Nicholas", "Cassano", 27, "030.313.050-43");
        Pessoa pessoa2 = new Pessoa("Aline", "Dias", 24, "873.269.140-87");

        Banco banco1 = new Banco("Banco Cassano", "CNPJ 123-123", 1);

        ContaCorrente contaCorrente1 = new ContaCorrente(pessoa1, banco1, "CC 01", 275, 100.0, "senha123", 6.50);
        ContaCorrente contaCorrente2 = new ContaCorrente(pessoa2, banco1, "CC 02", 276, 450.0, "senha1234", 30);

        ContaPoupanca contaPoupanca1 = new ContaPoupanca(pessoa2, banco1, "CP 01", 277, 500.0, "123456", 3.0, 3);

        pessoa1.adicionarConta(contaCorrente1);
        pessoa1.adicionarConta(contaCorrente2);

        pessoa2.adicionarConta(contaPoupanca1);

        banco1.adicionarConta(contaCorrente1);
        banco1.adicionarConta(contaCorrente2);
        banco1.adicionarConta(contaPoupanca1);

        System.out.println("O que você deseja ver?");
        System.out.println("1) Pessoas");
        System.out.println("2) Bancos");
        System.out.println("3) Contas Corrente");
        System.out.println("4) Contas Poupança");
        System.out.println("5) Cadastro de Pessoa");
        System.out.println("6) Cadastro de Banco");
        System.out.println("7) Cadastro de Conta");

        int input = 0;
        input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("Acessou Pessoas");
                pessoa1.Info();
                System.out.println("-----------");
                pessoa2.Info();
                break;
            case 2:
                System.out.println("Acessou Bancos");
                banco1.Info();
                System.out.println("-----------");
                banco1.InfoContas();
                break;
            case 3:
                System.out.println("Acessou Contas Corrente");
                System.out.println("O que deseja ver:");
                System.out.println("1) Informações da Conta");
                System.out.println("2) Simulação Taxa Mensal");
                System.out.println("3) Depositar valor");
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        contaCorrente1.Info();
                        System.out.println("-----------");
                        contaCorrente1.Info();
                        System.out.println("-----------");
                        contaCorrente2.Info();
                        break;
                    case 2:
                        contaCorrente1.NovoMes();
                        contaCorrente1.Info();
                        break;
                    case 3:
                        System.out.println("Quanto deseja depositar:");
                        double valorDeposito = sc.nextDouble();
                        System.out.println("Informe sua senha:");
                        String senha = sc.next();
                        contaCorrente1.depositar(valorDeposito, senha);
                        System.out.println("-----------");
                        contaCorrente1.Info();
                    default:
                        System.out.println("Opção não encontrada");
                }
                break;
            case 4:
                System.out.println("Acessou Contas Corrente");
                System.out.println("O que deseja ver:");
                System.out.println("1) Informações da Conta");
                System.out.println("2) Simulação Taxa Mensal");
                System.out.println("3) Operação de Saque");
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        contaPoupanca1.Info();
                        System.out.println("-----------");
                        break;
                    case 2:
                        contaPoupanca1.NovoMes();
                        System.out.println("-----------");
                        contaPoupanca1.Info();
                        break;
                    case 3:
                        System.out.println("Quanto deseja sacar da conta?");
                        double valorSaque = sc.nextInt();
                        System.out.println("Informe sua senha:");
                        String senha = sc.next();
                        contaPoupanca1.sacar(valorSaque, senha);
                        System.out.println("-----------");
                        contaPoupanca1.Info();
                        break;
                    default:
                        System.out.println("Opção não encontrada");
                }
                break;
            case 5:
                System.out.println("Cadastro de Pessoa");
                break;
            case 6:
                System.out.println("Cadastro de Banco");
                break;
            case 7:
                System.out.println("Cadastro de Conta");
                break;
            default:
                System.out.println("Opção não encontrada");
        }
    }
}