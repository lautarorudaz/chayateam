package Model;

public class Plan {

    private String hora;
    private String dia;
    private String descripcion;
    private int codigo;

    // Constructor
    public Plan(String hora, String dia, String descripcion, int codigo) {
        this.hora = hora;
        this.dia = dia;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}