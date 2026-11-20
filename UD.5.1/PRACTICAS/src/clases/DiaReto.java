package clases;

public class DiaReto {

private static int numeroDia;
private static String reto;
private static boolean completado;



public DiaReto(int numeroDia) {
this.numeroDia = numeroDia;
reto = "";
completado = false;

}

public int getNumeroDia() {
    return numeroDia;
}
public void setNumeroDia(int numeroDia) {
    this.numeroDia = numeroDia;
}
public String getReto() {
    return reto;
}
public void setReto(String reto) {
    this.reto = reto;
}
public boolean isCompletado() {
    return completado;
}
public void setCompletado(boolean completado) {
    this.completado = completado;
}

}
