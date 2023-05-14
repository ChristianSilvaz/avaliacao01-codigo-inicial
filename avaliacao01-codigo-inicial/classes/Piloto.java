package classes;

public class Piloto extends Pessoa {
    private String breve;

    public Piloto() {
        super();
        this.breve = "";
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nBreve: " + this.getBreve();
    }
}




