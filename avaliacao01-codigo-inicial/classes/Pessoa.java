package classes;

public class Pessoa {
    private String nome;
    private String cpf;
 
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public Pessoa() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
   
    
    public void setAeronave(Aeronave aeronave) {
    }
    public void setCpf(String cpf) {
        try {
            if (cpf.length() != 11) {
                throw new IllegalArgumentException("O CPF deve conter 11 dígitos!");
            }
            this.cpf = cpf;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
       
    }
}


