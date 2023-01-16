import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    static ArrayList<Pessoa> cadastro = new ArrayList<Pessoa>();
    static ArrayList<Banco> bancos = new ArrayList<Banco>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo!");

        Pessoa pessoa1 = new Pessoa("Nicholas", "Cassano", 27, "030.123.050-43");
        Pessoa pessoa2 = new Pessoa("Aline", "Dias", 24, "873.123.140-87");
        Pessoa pessoa3 = new Pessoa("Gueppetto", "Petto", 23, "020.345.123.-09");

        Banco banco1 = new Banco("Banco do Brasil", "090.123.0001/09", 1);
        Banco banco2 = new Banco("Banrisul", "911.323.0001/12", 2);
        Banco banco3 = new Banco("Bradesco", "123.323.0001/43", 3);

        ContaCorrente contaCorrente1 = new ContaCorrente(pessoa1, banco1, "CC 01", 275, 100.0, "nicholas123", 6.50);
        ContaCorrente contaCorrente2 = new ContaCorrente(pessoa2, banco2, "CC 02", 276, 450.0, "aline123", 5.50);
        ContaCorrente contaCorrente3 = new ContaCorrente(pessoa3, banco3, "CC 03", 277, 650.0, "petto123", 4.75);

        ContaPoupanca contaPoupanca1 = new ContaPoupanca(pessoa1, banco1, "CP 01", 111, 100.0, "123nicholas", 3.0, 3);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(pessoa2, banco2, "CP 02", 112, 150.0, "123aline", 3.0, 3);
        ContaPoupanca contaPoupanca3 = new ContaPoupanca(pessoa3, banco3, "CP 03", 113, 450.0, "123petto", 3.0, 3);

        pessoa1.adicionarConta(contaCorrente1);
        pessoa2.adicionarConta(contaCorrente2);
        pessoa3.adicionarConta(contaCorrente3);

        pessoa1.adicionarConta(contaPoupanca1);
        pessoa2.adicionarConta(contaPoupanca2);
        pessoa3.adicionarConta(contaPoupanca3);

        banco1.adicionarConta(contaCorrente1);
        banco1.adicionarConta(contaPoupanca1);

        banco2.adicionarConta(contaCorrente2);
        banco2.adicionarConta(contaPoupanca2);

        banco3.adicionarConta(contaCorrente3);
        banco3.adicionarConta(contaPoupanca3);

        int input = 100;
        while (input != 0) {

            menuPrincpal();

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.println(":::::: Acessou Pessoas ::::::: ");
                    pessoa1.Info();
                    System.out.println("-----------------------");
                    pessoa2.Info();
                    System.out.println("-----------------------");
                    pessoa3.Info();
                    System.out.println("-----------------------");
                    for (int i = 0; i < cadastro.size(); i++) {
                        System.out.println("Nome: " + cadastro.get(i).getNome());
                        System.out.println("Sobrenome: " + cadastro.get(i).getSobrenome());
                        System.out.println("idade " + cadastro.get(i).getIdade());
                        System.out.println("CPF: " + cadastro.get(i).getCPF());
                    }
                    break;
                case 2:
                    System.out.println(":::::: Acessou Bancos :::::::: ");
                    banco1.Info();
                    banco2.Info();
                    banco3.Info();
                    System.out.println("------------------------");
                    // banco1.InfoContas();
                    for (int i = 0; i < bancos.size(); i++) {
                        System.out.println("Nome da Instituição: " + bancos.get(i).getNome());
                        System.out.println("CNPJ: " + bancos.get(i).getCnpj());
                        System.out.println("Número Do Banco: " + bancos.get(i).getNroBanco());
                    }

                    break;
                case 3:
                    System.out.println("Acessou Contas Corrente");
                    System.out.println("O que deseja ver:");
                    System.out.println("1) Informações da Conta");
                    System.out.println("2) Simulação Taxa Mensal");
                    System.out.println("3) Depositar valor");
                    System.out.println("4) Voltar ao menu princpal");
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
                        case 4:
                            menuPrincpal();
                            input = sc.nextInt();

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
                    System.out.println("4) Voltar para o menu princpal");
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
                        case 4:
                            menuPrincpal();
                            input = sc.nextInt();
                        default:
                            System.out.println("Opção não encontrada");
                    }
                    break;
                case 5:
                    System.out.println("Cadastro de Pessoa");

                    menuCadastroPessoa();
                    break;
                case 6:
                    System.out.println("Cadastro de Banco");

                    menuCadastroBanco();
                    break;
                case 7:
                    System.out.println("Cadastro de Conta");
                    MenuCadastroConta();
                    break;
                default:
                    System.out.println("Opção não encontrada");
            }
        }

    }

    static void menuPrincpal() {
        System.out.println(" ");
        System.out.println("Escolha uma opção: ");
        System.out.println("1) Consulta de Pessoas Cadastradas");
        System.out.println("2) Consulta de Bancos Cadastrados");
        System.out.println("3) Contas Corrente");
        System.out.println("4) Contas Poupança");
        System.out.println("5) Cadastro de Pessoas");
        System.out.println("6) Cadastro de Bancos");
        System.out.println("7) Cadastro de Contas");
        System.out.println(" ");

    }

    public static void menuCadastroPessoa() {
        Scanner sc = new Scanner(System.in);

        String nome, sobrenome, cpf;
        int idade;

        System.out.println(" ");
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Sobrenome: ");
        sobrenome = sc.nextLine();
        System.out.print("CPF: ");
        cpf = sc.nextLine();
        System.out.print("Idade: ");
        idade = sc.nextInt();

        cadastro.add(new Pessoa(nome, sobrenome, idade, cpf));

        System.out.println("Cadastro realizado com sucesso!");

    }

    public static void menuCadastroBanco() {
        Scanner sc = new Scanner(System.in);

        String nome, cnpj;
        int nroBanco;

        System.out.println(" ");
        System.out.print("Nome do Banco: ");
        nome = sc.nextLine();
        System.out.print("CNPJ: ");
        cnpj = sc.nextLine();
        System.out.print("Numero do Banco: ");
        nroBanco = sc.nextInt();
        System.out.print(" ");

        bancos.add(new Banco(nome, cnpj, null));

        System.out.println("Cadastro realizado com sucesso!");

    }

    public static void MenuCadastroConta() {
        Scanner sc = new Scanner(System.in);

        int input = 5;
        boolean pesquisa = false;
        String pulando;

        String cnpjBanco;
        String cpfTitular;
        int nroBanco;
        String nomeConta;
        Integer nroConta;
        Double saldo;
        String senha;

        System.out.println("");
        System.out.println("Abrir conta: ");
        System.out.println("1) Poupança \n2) Corrente \n3) Voltar ao Menu Principal \n");
        input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.print("CPF do Titular: ");

                pulando = sc.nextLine();
                cpfTitular = sc.nextLine();

                for (int i = 0; i < cadastro.size(); i++) {

                    Pessoa busca = cadastro.get(i);

                    if (busca.CPF.contains(cpfTitular)) {
                        pesquisa = true;
                    }
                    if (pesquisa == false) {
                        System.out.println("Cadastro de Cliente não encontrado!");
                        // menu cadastro de cliente
                    }
                }
                System.out.println("CNPJ da Instuição: ");
                // validar banco
                // criar nome automatico
                // informar dps
                pulando = sc.nextLine();
                cnpjBanco = sc.nextLine();

                for (int i = 0; i < bancos.size(); i++) {

                    Banco busca = bancos.get(i);

                    if (busca.cnpj.contains(cnpjBanco)) {
                        pesquisa = true;
                    }
                    if (pesquisa == false) {
                        System.out.println("Cadastro de Cliente não encontrado!");
                        // menu cadastro de cliente
                    }

                    // System.out.println("Numero da Conta: ");
                    // gerar automatico
                    // informar depois
                    // System.out.println("Nome da conta: ");
                    // gerar automatico
                    // informar depois
                    // System.out.println("Qual valor deseja colocar na conta: R$");
                    // saldo = sc.nextDouble();
                    // System.out.println("Qual será sua senha: ");
                    // senha = nextLine();

                    // System.out.println("Confirmando Dados: ");
                    // System.out.println("Nome do Titular: " + titularConta);
                    // System.out.println("Número do Banco: ");
                    // System.out.println("Número da Conta: ");
                    // System.out.println("Nome da Conta: ");
                    // System.out.println("Informações: sua conta poupança rende X % ao mês");

                    // System.out.println("Bem-vindo ao Banco TAL "); // nome do banco);
                    // break;
                    // case 2:
                    // mesma coisa que conta poupança porem com outros rendimentos
                    // break;
                    // case 3:
                    // menuPrincpal();
                    // break;

                }
        }
    }
}