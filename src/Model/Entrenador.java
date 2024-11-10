package Model;

public class Entrenador {

    private int id;
    private String nombre;
    private String apellido;
    private int telefono;

    public Entrenador(int id, String nombre, String apellido, int telefono) {
        this.id = id;
        this.nombre = nombre;
    }

    public Entrenador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
