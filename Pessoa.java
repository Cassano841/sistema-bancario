import java.util.ArrayList;
import java.util.List;

class Pessoa {
    String nome;
    String sobrenome;
    Integer idade;
    String CPF;
    private List<ContaBancaria> contasBancarias;
    public Object cpf;
    public Object cpfTitular;

    public Pessoa(String nome, String sobrenome, Integer idade, String CPF) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.CPF = CPF;
        this.contasBancarias = new ArrayList<ContaBancaria>();
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public List<ContaBancaria> getContaBancaria() {
        return contasBancarias;
    }

    public void adicionarConta(ContaBancaria contaBancaria) {
        contasBancarias.add(contaBancaria);
    }

    /*
     * public void setContaBancaria(ArrayList<ContaBancaria> contaBancaria) {
     * this.contaBancaria = contaBancaria;
     * }
     */

    void Info() {
        System.out.println("Nome: " + nome + " " + sobrenome);
        System.out.println("CPF: " + CPF);
        System.out.println("Contas Bancária: " + contasBancarias.size());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public List<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

}