package Main;

import java.util.Scanner;

import Utilidades.Utilidades;
import clases.DiaAdviento;

public class Principal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        final int DIASADVIENTO = 24;
        DiaAdviento[] calendario = crearCalendario(DIASADVIENTO);

        do{
        System.out.println("inserta el dia");
        int prueba = sc.nextInt();

        System.out.println("===Menu===");
        System.out.println("1. Mostrar calendario");
        System.out.println("2. Abrir el dia de hoy");
        System.out.println("3. Salir");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                for (int i = 0; i < calendario.length; i++) {
                    if (calendario[i].isEstado() == true) {
                        System.out.println("Dia " + calendario[i].getNumDia() + ":" + "[ABIERTO]" + " "
                                + calendario[i].getSorpresa());
                    } else {
                        System.out.println("Dia " + calendario[i].getNumDia() + ":" + "[CERRADO]");
                    }
                }
                break;
            case 2:
                System.out.println("Hoy es dia " + prueba + "de diciembre");
                if (prueba == calendario[opcion].getNumDia()) {
                    System.out.println( calendario[opcion].isEstado());
                    calendario[opcion].setEstado(true);
                    System.out.println( calendario[opcion].isEstado());
                }

                break;
            case 3:
                System.out.println("has salido");
                break;

            default:
                break;
        }
    }while (true);

    }

    public static DiaAdviento[] crearCalendario(int DIASADVIENTO) {
        DiaAdviento[] calendario = new DiaAdviento[DIASADVIENTO];
        String[] sorpresa = Utilidades.DarListaDeSorpresas();
        for (int i = 0; i < DIASADVIENTO; i++) {
            // preguntar por la sintaxis otra vez
            calendario[i] = new DiaAdviento(i + 1);
            calendario[i].setSorpresa(sorpresa[i]);
        }
        return calendario;

    }
}
