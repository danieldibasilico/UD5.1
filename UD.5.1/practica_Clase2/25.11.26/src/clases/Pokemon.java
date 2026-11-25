package clases;

public class Pokemon {

    private String nombre;
    private String tipo;
    private int nivel;
    private double experiencia;

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public double getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(double experiencia) {
        this.experiencia = experiencia;
    }

}
