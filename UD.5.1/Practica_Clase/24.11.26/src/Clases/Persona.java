package Clases;

public class Persona {
    private String nombre;
    private String apellido;
    private int diaNacimiento;
    private int mesNacimiento;
    private int ayoNacimiento;





    public Persona(String nombre, String apellido, int diaNacimiento, int mesNacimiento, int ayoNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.ayoNacimiento = ayoNacimiento;
    }
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getDiaNacimiento() {
        return diaNacimiento;
    }
    public void setDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }
    public int getMesNacimiento() {
        return mesNacimiento;
    }
    public void setMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }
    public int getAyoNacimiento() {
        return ayoNacimiento;
    }
    public void setAyoNacimiento(int ayoNacimiento) {
        this.ayoNacimiento = ayoNacimiento;
    }
}
