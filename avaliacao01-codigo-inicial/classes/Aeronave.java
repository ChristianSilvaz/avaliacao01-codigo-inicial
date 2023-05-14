package classes;

public class Aeronave {
    private String modelo;
    private String matricula;

    public Aeronave(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Modelo: " + this.getModelo() + "\nMatrícula: " + this.getMatricula();
    }
}