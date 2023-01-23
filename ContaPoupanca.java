public class ContaPoupanca extends ContaBancaria {

    private Double rendimento;
    private Integer saquesMensais;

    public ContaPoupanca(Pessoa titularConta, Banco banco, Integer nroConta, Integer senha) {
        super(titularConta, banco, nroConta, saldo, senha);
        this.saldo = 100.0;
        this.rendimento = 1.5;
        this.saquesMensais = 3;
    }

    public Integer getSaquesMensais() {
        return saquesMensais;
    }

    public void setSaquesMensais(Integer saquesMensais) {
        this.saquesMensais = saquesMensais;
    }

    public Double getRendimento() {
        return rendimento;
    }

    public void setRendimento(Double rendimento) {
        this.rendimento = rendimento;
    }

    void Info() {
        System.out.println("Nome do Banco : " + banco.nome);
        System.out.println("Nr. Conta     : " + nroConta);
        System.out.println("Variação da Poupança: [?]");
        System.out.println("Nome Cliente  : " + titularConta.nome);
        System.out.println("Saldo da Conta: R$" + saldo);
        System.out.println("Rendimento Mensal: " + rendimento);
        System.out.println("Saques Restantes no Mês: " + saquesMensais);
    }

    public void sacar(double valor, Integer senha) {
        if (verificarSenha(senha)) {
            if (saquesMensais != 0) {
                if (valor <= saldo) {
                    saldo -= valor;
                    saquesMensais--;
                    System.out.println("Saque realizado com sucesso");
                    System.out.println("Saldo atual:" + saldo);
                    System.out.println("Quantidade de Saques restantes:" + saquesMensais);
                } else {
                    System.out.println("Saldo insuficiente.");
                }
            } else {
                System.out.println("Número de saques disponíveis no mês atingido.");
            }
        } else {
            System.out.println("Senha incorreta!");
        }
    }

    public void NovoMes() {
        double rendimentoTotalMes;
        rendimentoTotalMes = ((saldo * rendimento) / 100);
        saldo += rendimentoTotalMes;
        saquesMensais = 3;
        System.out.println("Rendimento total do mês: R$" + rendimentoTotalMes);
        System.out.println("Saldo final: R$ " + saldo);
    }
}
