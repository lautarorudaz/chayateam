package Model;

public class Sala {

    private int nro_sala;
    private String ubicacion;
    private int capacidad;

    public Sala(int nro_sala, String ubicacion) {
        this.nro_sala = nro_sala;
        this.ubicacion = ubicacion;
    }

    public int getNro_sala() {
        return nro_sala;
    }

    public void setNro_sala(int nro_sala) {
        this.nro_sala = nro_sala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}
