package Model;

public class Se_imparte {

    private static Entrenador entrenador;
    private Sala sala;
    private Plan plan;

    // Constructor, getters y setters

    public Se_imparte(Entrenador entrenador, Sala sala, Plan plan) {
        this.entrenador = entrenador;
        this.sala = sala;
        this.plan = plan;
    }

    public static Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}