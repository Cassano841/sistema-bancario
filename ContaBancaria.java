
public abstract class ContaBancaria{

    protected Pessoa titularConta;
    protected Banco banco;
    
    protected String nomeConta;
    protected Integer nroConta;
    protected Double saldo;
    protected String senha;

    public ContaBancaria(Pessoa titularConta, Banco banco, String nomeConta, Integer nroConta, Double saldo, String senha) {
        this.titularConta = titularConta;
        this.banco = banco;
        this.nomeConta = nomeConta;
        this.nroConta = nroConta;
        this.saldo = saldo;
        this.senha = senha;
    }
    public Pessoa getTitularConta() {
        return titularConta;
    }
    public void setTitularConta(Pessoa titularConta) {
        this.titularConta = titularConta;
    }
    public Banco getBanco() {
        return this.banco = banco;
    }
    public Banco setBanco() {
        return banco;
    }
   
    public String getNomeConta() {
        return nomeConta;
    }
    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }
    public Integer getNroConta() {
        return nroConta;
    }
    public Integer setNroConta(Integer nroConta) {
        return this.nroConta = nroConta;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void depositar(double valor, String senha){
        if (verificarSenha(senha)){
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Senha incorreta. Operação Cancelada.");
        }
        saldo += valor;
    }

    public boolean verificarSenha(String senha){
        if (this.senha.equals(senha)){
            return true;
        } else {
            return false;
        }
    }

    public abstract void sacar(double valor, String senha);
}