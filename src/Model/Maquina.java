package Model;

public class Maquina {
    private int codigoMaquina;
    private String marca;
    private String modelo;
    private int nroSala; // Este es el código de la sala asociada

    public Maquina(int codigoMaquina, String marca, String modelo, int nroSala) {
        this.codigoMaquina = codigoMaquina;
        this.marca = marca;
        this.modelo = modelo;
        this.nroSala = nroSala;
    }

    // Getters y setters
    public int getCodigoMaquina() {
        return codigoMaquina;
    }

    public void setCodigoMaquina(int codigoMaquina) {
        this.codigoMaquina = codigoMaquina;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }
}