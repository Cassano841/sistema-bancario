import java.util.ArrayList;
import java.util.List;

class Banco {
    String nome;
    String CNPJ;
    Integer NroBanco;
    List<ContaBancaria> contasBancarias;

    public Banco(String nome, String cNPJ, Integer nroBanco) {
        this.nome = nome;
        this.CNPJ = cNPJ;
        this.NroBanco = nroBanco;
        this.contasBancarias = new ArrayList<ContaBancaria>();
    }

    public void adicionarConta(ContaBancaria contaBancaria){
        contasBancarias.add(contaBancaria);
    }

    void Info(){
        System.out.println("Nome Banco: "+ nome);
        System.out.println("CNPJ Banco: " + CNPJ);
        System.out.println("Nro Banco: " + NroBanco);
        System.out.println("Contas Bancárias: " + contasBancarias.size());
    }

    void InfoContas(){
        System.out.println("[In Progress] Acesso criar conta [In Progress]");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
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
  
  }