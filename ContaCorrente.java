public class ContaCorrente extends ContaBancaria {

    private double taxasMensais;

    public ContaCorrente(Pessoa titularConta, Banco banco, Integer nroConta, Integer senha) {
        super(titularConta, banco, nroConta, saldo, senha);
        this.saldo = 100.0;
        this.taxasMensais = 1.5;
    }

    public void sacar(double valor, Integer senha) {
        System.out.println("Opção não aceita para Conta Corrente.");
    }

    void Info() {
        System.out.println("Nome do Banco : " + banco.nome);
        System.out.println("Nr. Conta     : " + nroConta);
        System.out.println("Nome Cliente  : " + titularConta.nome);
        System.out.println("Saldo da Conta: R$" + saldo);
        System.out.println("Taxas Mensais : R$" + taxasMensais);
    }

    public void NovoMes(Integer senha) {
        if (verificarSenha(senha)) {
            saldo -= taxasMensais;
            System.out.println("Taxa mensal de " + taxasMensais + " debitada com sucesso.");
        }
    }

    public double getTaxasMensais() {
        return taxasMensais;
    }

    public void setTaxasMensais(double limite) {
        this.taxasMensais = limite;
    }
}
