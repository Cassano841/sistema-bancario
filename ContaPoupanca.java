public class ContaPoupanca extends ContaBancaria {

    private Double rendimento;
    private Integer saquesMensais;

    public ContaPoupanca(Pessoa titularConta, Banco banco, String nomeConta, Integer nroConta, Double saldo, String senha, Double rendimento, Integer saquesMensais) {
        super(titularConta, banco, nomeConta, nroConta, saldo, senha);
        this.rendimento    = rendimento;
        this.saquesMensais = saquesMensais;
    }

    void Info() {
        System.out.println("Nome do Banco : " + banco.nome);
        System.out.println("Nr. Conta     : " + nroConta);
        System.out.println("Variação da Poupança: [In Progress]");
        System.out.println("Nome Cliente  : " + titularConta.nome);
        System.out.println("Saldo da Conta: R$" + saldo);
        System.out.println("Rendimento Mensal: [In Progress]");
        System.out.println("Saques Restantes no Mês: " + saquesMensais);
    }


    public void sacar(double valor, String senha){
        if (verificarSenha(senha)){
            if (valor <= saldo){
                saldo -= valor;
                saquesMensais--;
                System.out.println("Saldo atual:" + saldo);
                System.out.println("Quantidade de Saques restantes:" + saquesMensais);
    
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Senha incorreta!");
        }
        
    }

    public void NovoMes() {
        saldo += rendimento;
        System.out.println("[In Progress] Rendimetno mensal de " + rendimento + " debitada com sucesso. [In Progress]");
    }
    
}
