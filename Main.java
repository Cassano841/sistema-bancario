import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static ArrayList<Pessoa> cadastroPessoa = new ArrayList<Pessoa>();
    static ArrayList<Banco> cadastroBanco = new ArrayList<Banco>();
    static ArrayList<ContaCorrente> cadastroContaCorrente = new ArrayList<ContaCorrente>();
    static ArrayList<ContaPoupanca> cadastroContaPoupanca = new ArrayList<ContaPoupanca>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo!");

        int input = 100;
        while (input != 0) {
            menuPrincpal();
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println(":::::: Acessou Pessoas ::::::: ");
                    System.out.println("-----------------------");
                    for (Pessoa pessoa : cadastroPessoa) {
                        System.out.println("-------------------------------");
                        System.out.println("Nome     : " + pessoa.getNome());
                        System.out.println("Sobrenome: " + pessoa.getSobrenome());
                        System.out.println("Idade    : " + pessoa.getIdade());
                        System.out.println("CPF      : " + pessoa.getCPF());
                        if (!pessoa.getContaBancaria().isEmpty()) {
                            for (ContaPoupanca contaPoupanca : cadastroContaPoupanca){
                                System.out.println("----------------------------------------------");
                                System.out.println("Nome Conta           : " + contaPoupanca.getNomeConta() );
                                System.out.println("Numero Conta         : " + contaPoupanca.getNroConta());
                                System.out.println("Nome Banco Associado : " + contaPoupanca.getBanco().getNome());
                                System.out.println("CNPJ Banco Associado : " + contaPoupanca.getBanco().getCnpj());
                                System.out.println("----------------------------------------------");
                            }
                        } else {
                            System.out.println("Sem contas bancárias vinculadas ao usuário " + pessoa.getNome());
                        }
                        /*
                         * for (int j = 0; j < cadastroPessoa.get(i).getContaBancaria().size(); j++){
                         * System.out.println("Contas   : " +
                         * cadastroPessoa.get(i).getContaBancaria().get(i).nomeConta);
                         * }
                         */
                        System.out.println("-------------------------------");
                    }
                    break;
                case 2:
                    System.out.println(":::::: Acessou Bancos :::::::: ");
                    // banco1.Info();
                    // banco2.Info();
                    // banco3.Info();
                    System.out.println("------------------------");
                    // banco1.InfoContas();
                    for (int i = 0; i < cadastroBanco.size(); i++) {
                        System.out.println("-----------------------");
                        System.out.println("Nome da Instituição: " + cadastroBanco.get(i).getNome());
                        System.out.println("CNPJ               : " + cadastroBanco.get(i).getCnpj());
                        System.out.println("Número Do Banco    : " + cadastroBanco.get(i).getNroBanco());
                        System.out.println("-----------------------");
                    }
                    break;
                case 3:
                    System.out.println(":::::: Acessou Contas Corrente ::::::");
                    System.out.println("O que deseja ver:");
                    System.out.println("1) Informações da Conta");
                    System.out.println("2) Simulação Taxa Mensal");
                    System.out.println("3) Depositar valor");
                    System.out.println("4) Voltar ao menu princpal");
                    input = sc.nextInt();
                    switch (input) {
                        case 1:
                            for (int i = 0; i < cadastroContaCorrente.size(); i++) {
                                System.out.println("-----------------------");
                                System.out.println(
                                        "Titular         : " + cadastroContaCorrente.get(i).getTitularConta().nome);
                                System.out.println("Nro Conta       : " + cadastroContaCorrente.get(i).getNroConta());
                                System.out.println("Saldo           : " + cadastroContaCorrente.get(i).saldo);
                                System.out.println("Número Do Banco : " + cadastroContaCorrente.get(i).getBanco().nome);
                                System.out.println("-----------------------");
                            }
                            System.out.println("FIM");

                            break;
                        case 2:
                            // contaCorrente1.NovoMes();
                            // contaCorrente1.Info();
                            break;
                        case 3:
                            System.out.println("Quanto deseja depositar:");
                            double valorDeposito = sc.nextDouble();
                            System.out.println("Informe sua senha:");
                            String senha = sc.next();
                            // contaCorrente1.depositar(valorDeposito, senha);
                            System.out.println("-----------");
                            // contaCorrente1.Info();
                            // case 4:
                            // menuPrincpal();
                            // input = sc.nextInt();
                        default:
                            System.out.println("Opção não encontrada");
                    }
                    break;
                case 4:
                    System.out.println(":::::: Acessou Contas Poupança ::::::");
                    System.out.println("O que deseja ver:");
                    System.out.println("1) Informações da Conta");
                    System.out.println("2) Simulação Taxa Mensal");
                    System.out.println("3) Operação de Saque");
                    System.out.println("4) Voltar para o menu princpal");
                    input = sc.nextInt();
                    switch (input) {
                        case 1:
                            if (cadastroContaPoupanca.size() != 0) {
                                for (int i = 0; i < cadastroContaPoupanca.size(); i++) {
                                    System.out.println("-----------------------");
                                    System.out.println("Nome do Titular      : "
                                            + cadastroContaPoupanca.get(i).getTitularConta().nome);
                                    System.out.println("Sobrenome do Titular : "
                                            + cadastroContaPoupanca.get(i).getTitularConta().sobrenome);
                                    System.out.println("CPF do Titular       : "
                                            + cadastroContaPoupanca.get(i).getTitularConta().CPF);
                                    // System.out.println("Taxas Mensais : " +
                                    // cadastroContaPoupanca.get(i).NovoMes(););
                                    System.out.println("Saldo Conta     : " + cadastroContaPoupanca.get(i).getSaldo());
                                    System.out.println(
                                            "Banco           : " + cadastroContaPoupanca.get(i).getBanco().nome);
                                    System.out.println("-----------------------");
                                }
                            } else {
                                System.out.println("Sem cadastros no momento");
                            }
                            break;
                        case 2:
                            // contaPoupanca1.NovoMes();
                            System.out.println("-----------");
                            // contaPoupanca1.Info();
                            break;
                        case 3:
                            System.out.println("Quanto deseja sacar da conta?");
                            double valorSaque = sc.nextInt();
                            System.out.println("Informe sua senha:");
                            String senha = sc.next();
                            // contaPoupanca1.sacar(valorSaque, senha);
                            System.out.println("-----------");
                            // q contaPoupanca1.Info();
                            break;
                        // case 4:
                        // menuPrincpal();
                        // input = sc.nextInt();
                        default:
                            System.out.println("Opção não encontrada");
                    }
                    break;
                case 5:
                    System.out.println(":::::: Cadastro de Pessoa ::::::");
                    menuCadastroPessoa();
                    break;
                case 6:
                    System.out.println(":::::: Cadastro de Banco ::::::");
                    menuCadastroBanco();
                    break;
                case 7:
                    System.out.println(":::::: Cadastro de Conta ::::::");
                    MenuCadastroConta();
                    break;
                default:
                    System.out.println("Opção não encontrada");
            }
        }
    }

    static void menuPrincpal() {
        System.out.println("==================================");
        System.out.println("Escolha uma opção: ");
        System.out.println("1) Consulta de Pessoas Cadastradas");
        System.out.println("2) Consulta de Bancos Cadastrados");
        System.out.println("3) Contas Corrente");
        System.out.println("4) Contas Poupança");
        System.out.println("5) Cadastro de Pessoas");
        System.out.println("6) Cadastro de Bancos");
        System.out.println("7) Cadastro de Contas");
        System.out.println("===================================");
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

        cadastroPessoa.add(new Pessoa(nome, sobrenome, idade, cpf));

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

        cadastroBanco.add(new Banco(nome, cnpj, nroBanco));

        System.out.println("Cadastro realizado com sucesso!");

    }

    public static void MenuCadastroConta() {
        Scanner sc = new Scanner(System.in);
        Banco banco1 = new Banco("Banco do Brasil", "090.123.0001/09", 1);
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
                System.out.println("Conta Poupança");
                System.out.print("Titular Conta: ");
                cpfTitular = sc.next();
                // = sc.nextLine();
                // System.out.print("Senha: ");
                // senha = sc.next();
                // System.out.println("Número da Instuição: ");
                // pulando = sc.nextLine();
                // nroBanco = sc.nextInt();

                if (cpfTitular == null || cpfTitular == " ") {
                    System.out.println("Sem informação preenchida");
                } else if (cpfTitular.length() > 0) {
                    for (Pessoa pessoa : cadastroPessoa) {
                        if (cpfTitular.equals(pessoa.CPF)) {
                            ContaPoupanca contaPoupanca = new ContaPoupanca(pessoa, banco1, "123", 12, 100.0, "123",
                                    100.0, 32);
                            cadastroContaPoupanca.add(contaPoupanca);
                            pessoa.adicionarConta(contaPoupanca);
                            System.out.println("Sucesso. CPF Informado  : " + cpfTitular);
                            System.out.println("Sucesso. Valor Informado: " + pessoa.CPF.toString());
                            System.out.println("Objeto Pessoa           : " + pessoa);
                            System.out.println("Objeto Conta Poupança:" + contaPoupanca);
                        } else {
                            System.out.println("Usuário não encontrado!");
                        }
                    }
                } else {
                    System.out.println("Usuário não cadastrado!");
                }

                break;
            case 2:
                System.out.println("Conta Corrente");
                break;
            default:
                System.out.println("Opção não encontrada");
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
        // }
        // }
    }
}