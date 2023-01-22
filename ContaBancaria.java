
public abstract class ContaBancaria{

    protected Pessoa titularConta;
    protected Banco banco;

    protected Integer nroConta;
    protected static Double saldo;
    protected Integer senha;

    public ContaBancaria(Pessoa titularConta, Banco banco, Integer nroConta, Double saldo, Integer senha) {
        this.titularConta = titularConta;
        this.banco = banco;
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
    public Integer getSenha() {
        return senha;
    }
    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public void depositar(double valor, Integer senha){
        if (verificarSenha(senha)){
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Senha incorreta. Operação Cancelada.");
        }
    }

    public boolean verificarSenha(Integer senha){
        if (this.senha.equals(senha)){
            return true;
        } else {
            return false;
        }
    }

    public abstract void sacar(double valor, Integer senha);
}