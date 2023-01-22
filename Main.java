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
                    System.out.println(" ");
                    if (cadastroPessoa.size() != 0) {
                        for (Pessoa pessoa : cadastroPessoa) {
                            System.out.println(" ");
                            System.out.println("Nome     : " + pessoa.getNome());
                            System.out.println("Sobrenome: " + pessoa.getSobrenome());
                            System.out.println("Idade    : " + pessoa.getIdade());
                            System.out.println("CPF      : " + pessoa.getCPF());
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println("Sem cadastro de usuários no momento.");
                    }
                    break;
                case 2:
                    System.out.println(":::::: Acessou Bancos :::::::: ");
                    if (cadastroBanco.size() != 0) {
                        for (int i = 0; i < cadastroBanco.size(); i++) {
                            System.out.println(" ");
                            System.out.println("Nome da Instituição: " + cadastroBanco.get(i).getNome());
                            System.out.println("CNPJ               : " + cadastroBanco.get(i).getCnpj());
                            System.out.println("Número Do Banco    : " + cadastroBanco.get(i).getNroBanco());
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println(" ");
                        System.out.println("Sem cadastro de bancos no momento.");
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
                                System.out.println(" ");
                                System.out.println("Titular: " + cadastroContaCorrente.get(i).getTitularConta().nome);
                                System.out.println("Nro Conta: " + cadastroContaCorrente.get(i).getNroConta());
                                System.out.println("Saldo: " + cadastroContaCorrente.get(i).saldo);
                                System.out.println("Número Do Banco: " + cadastroContaCorrente.get(i).getBanco().nome);
                                System.out.println(" ");
                            }
                            System.out.println("FIM");
                            break;
                        case 2:
                            System.out.println("Qual CPF do usuário?");
                            String cpfTitular = sc.next();
                            System.out.println("Informe sua senha:");
                            Integer senha = sc.nextInt();
                            for (Pessoa pessoa : cadastroPessoa) {
                                if (cpfTitular.equals(pessoa.CPF)) {
                                    for (ContaCorrente cCorrente : cadastroContaCorrente) {
                                        cCorrente.NovoMes(senha);
                                        System.out.println(" ");
                                        cCorrente.Info();
                                    }
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Qual CPF do usuário?");
                            cpfTitular = sc.next();
                            System.out.println("Informe sua senha:");
                            senha = sc.nextInt();
                            System.out.println("Quanto deseja depositar:");
                            double valorDeposito = sc.nextDouble();
                            for (Pessoa pessoa : cadastroPessoa) {
                                if (cpfTitular.equals(pessoa.CPF)) {
                                    for (ContaCorrente cCorrente : cadastroContaCorrente) {
                                        cCorrente.depositar(valorDeposito, senha);
                                        System.out.println(" ");
                                        cCorrente.Info();
                                    }
                                }
                            }

                            break;
                        default:
                            System.out.println("Opção não encontrada");
                    }
                    break;
                case 4:
                    System.out.println(":::::: Acessou Contas Poupança ::::::");
                    System.out.println("O que deseja ver:");
                    System.out.println("1) Informações da Conta");
                    System.out.println("2) Simulação Rendimento");
                    System.out.println("3) Operação de Saque");
                    System.out.println("4) Voltar para o menu princpal");
                    input = sc.nextInt();
                    switch (input) {
                        case 1:
                            if (cadastroContaPoupanca.size() != 0) {
                                for (int i = 0; i < cadastroContaPoupanca.size(); i++) {
                                    System.out.println(" ");
                                    System.out.println("Nome do Titular: "
                                            + cadastroContaPoupanca.get(i).getTitularConta().nome);
                                    System.out.println("Sobrenome do Titular: "
                                            + cadastroContaPoupanca.get(i).getTitularConta().sobrenome);
                                    System.out.println("CPF do Titular: "
                                            + cadastroContaPoupanca.get(i).getTitularConta().CPF);
                                    System.out.println("Saldo Conta: " + cadastroContaPoupanca.get(i).getSaldo());
                                    System.out.println("Banco: " + cadastroContaPoupanca.get(i).getBanco().nome);
                                    System.out.println("-----------------------");
                                }
                            } else {
                                System.out.println("Sem cadastros no momento");
                            }
                            break;
                        case 2:
                        System.out.println("Qual CPF do usuário?");
                        String cpfTitular = sc.next();
                        System.out.println("Informe sua senha:");
                        Integer senha = sc.nextInt();
                        for (Pessoa pessoa : cadastroPessoa) {
                            if (cpfTitular.equals(pessoa.CPF)) {
                                for (ContaPoupanca cPoupanca : cadastroContaPoupanca) {
                                    cPoupanca.NovoMes();
                                    System.out.println(" ");
                                    cPoupanca.Info();
                                }
                            }
                        }
                            break;
                        case 3:
                            System.out.println("Qual CPF do usuário?");
                            cpfTitular = sc.next();
                            System.out.println("Qual o número da conta que deseja realizar a operação de saque?");
                            Integer contaTitular = sc.nextInt();
                            System.out.println("Informe sua senha:");
                            senha = sc.nextInt();
                            System.out.println("Quanto deseja sacar da conta?");
                            Double valorSaque = sc.nextDouble();
                            for (Pessoa pessoa : cadastroPessoa) {
                                if (cpfTitular.equals(pessoa.CPF)) {
                                    for (ContaPoupanca cPoupanca : cadastroContaPoupanca) {
                                        if (contaTitular.equals(cPoupanca.nroConta)) {
                                            cPoupanca.sacar(valorSaque, senha);
                                            System.out.println("Saque efetuado com sucesso!");
                                            System.out.println(" ");
                                        }
                                    }
                                }
                            }
                            break;
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
        System.out.println("========================================");
        System.out.println("|| Escolha uma opção:                 ||");
        System.out.println("|| 1) Consulta de Pessoas Cadastradas ||");
        System.out.println("|| 2) Consulta de Bancos Cadastrados  ||");
        System.out.println("|| 3) Contas Corrente                 ||");
        System.out.println("|| 4) Contas Poupança                 ||");
        System.out.println("|| 5) Cadastro de Pessoas             ||");
        System.out.println("|| 6) Cadastro de Bancos              ||");
        System.out.println("|| 7) Cadastro de Contas              ||");
        System.out.println("========================================");
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

        int input = 5;
        String cpfTitular;
        int nroBanco;
        Integer senha;

        System.out.println("==================================");
        System.out.println("|| Tipo de Conta para Abertura: ||");
        System.out.println("|| 1) Poupança                  ||");
        System.out.println("|| 2) Corrente                  ||");
        System.out.println("|| 3) Voltar ao Menu Principal  ||");
        System.out.println("==================================");
        input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Cadastro de Conta Poupança");
                System.out.println("Qual o CPF do Titular da Conta:");
                cpfTitular = sc.next();
                System.out.println("Qual senha deseja cadastrar:");
                senha = sc.nextInt();
                System.out.println("Qual banco deseja cadastrar sua Conta Poupança?");
                nroBanco = sc.nextInt();
                if (cpfTitular == null || cpfTitular == " ") {
                    System.out.println("O CPF precisa ser informado para cadastro de Conta Poupança.");
                } else if (cpfTitular.length() > 0) {
                    for (Pessoa pessoa : cadastroPessoa) {
                        if (cpfTitular.equals(pessoa.CPF)) {
                            if (nroBanco != 0) {
                                for (Banco banco : cadastroBanco) {
                                    if (nroBanco == banco.NroBanco) {
                                        ContaPoupanca contaPoupanca = new ContaPoupanca(pessoa, banco, nroBanco, senha);
                                        cadastroContaPoupanca.add(contaPoupanca);
                                        pessoa.adicionarConta(contaPoupanca);
                                        banco.adicionarConta(contaPoupanca);
                                    } else {
                                        System.out.println("Nenhum banco encontrado com este número de conta.");
                                    }
                                }
                            }
                            System.out.println("Cadastro de Conta Poupança realizado com sucesso!");
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Cadastro de Conta Corrente");
                System.out.println("Qual o CPF do Titular da Conta:");
                cpfTitular = sc.next();
                System.out.println("Qual senha deseja cadastrar:");
                senha = sc.nextInt();
                System.out.println("Qual banco deseja cadastrar sua Conta Corrente?");
                nroBanco = sc.nextInt();
                if (cpfTitular == null || cpfTitular == " ") {
                    System.out.println("O CPF precisa ser informado para cadastro de Conta Corrente.");
                } else if (cpfTitular.length() > 0) {
                    for (Pessoa pessoa : cadastroPessoa) {
                        if (cpfTitular.equals(pessoa.CPF)) {
                            if (nroBanco != 0) {
                                for (Banco banco : cadastroBanco) {
                                    if (nroBanco == banco.NroBanco) {
                                        ContaCorrente contaCorrente = new ContaCorrente(pessoa, banco, nroBanco, senha);
                                        cadastroContaCorrente.add(contaCorrente);
                                        pessoa.adicionarConta(contaCorrente);
                                        banco.adicionarConta(contaCorrente);
                                    } 
                                }
                            }
                            System.out.println("Cadastro de Conta Corrente realizado com sucesso!");
                        }
                    }
                }
                break;
            default:
                System.out.println("Opção não encontrada");
        }
    }
}