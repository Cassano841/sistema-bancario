public class ContaCorrente extends ContaBancaria {

    private double taxasMensais;

    public ContaCorrente(Pessoa titularConta, Banco banco, String nomeConta, Integer nroConta, Double saldo,
            String senha, double taxasMensais) {
        super(titularConta, banco, nomeConta, nroConta, saldo, senha);
        this.taxasMensais = taxasMensais;
    }

    public void sacar(double valor, String senha) {
        System.out.println("Opção não aceita para Conta Corrente.");
    }

    void Info() {
        System.out.println("Nome do Banco : " + banco.nome);
        System.out.println("Nr. Conta     : " + nroConta);
        System.out.println("Nome Cliente  : " + titularConta.nome);
        System.out.println("Saldo da Conta: R$" + saldo);
        System.out.println("Taxas Mensais : R$" + taxasMensais);
    }

    public void NovoMes() {
        saldo -= taxasMensais;
        System.out.println("Taxa mensal de " + taxasMensais + " debitada com sucesso.");
    }

    public double getTaxasMensais() {
        return taxasMensais;
    }

    public void setTaxasMensais(double limite) {
        this.taxasMensais = limite;
    }
}
