import java.util.ArrayList;
import java.util.List;

class Banco {
    String nome;
    String cnpj;
    Integer NroBanco;
    List<ContaBancaria> contasBancarias;
    public Object nroBanco;
    public Object numero;

    public Banco(String nome, String cnpj, Integer nroBanco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.NroBanco = nroBanco;
        this.contasBancarias = new ArrayList<ContaBancaria>();
    }

    public void adicionarConta(ContaBancaria contaBancaria) {
        contasBancarias.add(contaBancaria);
    }
    
    public void removerConta(ContaBancaria contaBancaria) {
        contasBancarias.remove(contaBancaria);
    }
    
    void Info() {
        System.out.println("");
        System.out.println("Nome Banco: " + nome);
        System.out.println("CNPJ Banco: " + cnpj);
        System.out.println("Nro Banco: " + NroBanco);
        System.out.println("Contas Bancárias: " + contasBancarias.size());
    }

    // void InfoContas(){
    // System.out.println("Nome Da Instituição: " + nome);
    // System.out.println("CPF: " + CPF);
    // System.out.println("Contas Bancária: " + contasBancarias.size());
    // }");
    // }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getNroBanco() {
        return NroBanco;
    }

    public void setNroBanco(Integer nroBanco) {
        NroBanco = nroBanco;
    }

    public List<ContaBancaria> getContaBancaria() {
        return contasBancarias;
    }

    public void setContaBancaria(ArrayList<ContaBancaria> contaBancaria) {
        this.contasBancarias = contaBancaria;
    }

    public static void add(Banco bancos) {
    }
}