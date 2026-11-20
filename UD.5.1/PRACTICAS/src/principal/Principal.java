package principal;

import java.util.Scanner;

import clases.DiaReto;
import utilidades.Utilidades;

public class Principal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int DIAS = 30;
        DiaReto[] retos = crearCalendario(DIAS);
        System.out.println("1. Completa el reto de hoy");
        System.out.println("2. Muestra los retos completados");
        System.out.println("3. Salir");
        int opcion = sc.nextInt();

        do {

            switch (opcion) {
                case 1:System.out.println("Dime el dia del reto");
                 //int dia = sc.nextInt();
                System.out.println("Dime el reto completado\n==Lista de retos==");
                mostrarRetos();
                for(int i=0; i<retos.length;i++){
                if (retos[i].isCompletado()) {
                    
                }}
           


                    break;
                case 2:

                    break;
                case 3:

                    break;

                default:
                    System.out.println("fallo");
                    break;
            }
        } while (opcion != 3);

    }

    public static DiaReto[] crearCalendario(int DIAS) {
        DiaReto[] retos = new DiaReto[DIAS];
        for (int i = 0; i < DIAS; i++) {
            retos[i] = new DiaReto(i);
        }
        return retos;

    }
    private  static void mostrarRetos(){
        System.out.println(Utilidades.devolverRetos());
        
    }

}
