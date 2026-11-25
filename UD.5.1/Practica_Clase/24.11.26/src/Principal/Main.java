package Principal;

import java.util.Scanner;

import Clases.Persona;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner scLetra = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        int contador = 0;
        Persona[] persona = new Persona[20];
        int maximo = persona.length;

        persona[0] = new Persona("daniel", "DI basilico");
        persona[1] = new Persona("juan", "Ramirez");
        persona[2] = new Persona("angel", "Redondo");
        persona[3] = new Persona("jose", "hurtado", 15, 01, 1897);
        persona[4] = new Persona("joaquin", "Sabina");
        persona[5] = new Persona("Raul", "Sanchez");
        persona[6] = new Persona("jose", "hurtado", 10, 03, 1998);

        do {

            System.out.println("1. dar de alta sin fecha de nacimiento");
            System.out.println("2. dar de alta con fecha de nacimiento");
            System.out.println("3. Mostrar listado");
            System.out.println("4. Buscar persona por nombre y apellido");
            System.out.println("5. Salir");
            System.out.println("Introduce la opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce el nombre de la persona");
                    String nombre = scLetra.nextLine();
                    System.out.println("Introduce el apellido de la persona");
                    String apellido = scLetra.nextLine();
                    if (contador < maximo) {
                        persona[contador] = new Persona(nombre, apellido);
                        contador++;
                    }
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la persona");
                    String nombre2 = scLetra.nextLine();
                    System.out.println("Introduce el apellido de la persona");
                    String apellido2 = scLetra.nextLine();
                    System.out.println("Introduce el dia de nacimiento de la persona");
                    int dia = sc.nextInt();
                    System.out.println("Introduce el mes de nacimiento de la persona");
                    int mes = sc.nextInt();
                    System.out.println("Introduce el año de nacimiento de la persona");
                    int ayo = sc.nextInt();
                    if (contador != maximo) {
                        persona[contador] = new Persona(nombre2, apellido2, dia, mes, ayo);
                        contador++;
                    }

                    break;
                case 3:
                    System.out.println("===LISTADO DE PERSONAS===");
                    for (int i = 0; i < persona.length; i++) {
                        if (persona[i] != null) {
                            if (persona[i].getDiaNacimiento() != 0) {
                                System.out.println("Nombre: " + persona[i].getNombre().toUpperCase() + " Apellido: "
                                        + persona[i].getApellido().toUpperCase() + " dia de nacimiento:"
                                        + persona[i].getDiaNacimiento()
                                        + " mes de nacimiento:" + persona[i].getMesNacimiento()
                                        + " año de nacimiento:"
                                        + persona[i].getAyoNacimiento());
                            } else {

                                System.out.println(
                                        "Nombre: " + persona[i].getNombre().toUpperCase() + " Apellido: "
                                                + persona[i].getApellido().toUpperCase()
                                                + " Fecha nacimiento: XX-XX-XXXX");
                            }
                        }
                    }

                    break;
                case 4:
                    System.out.println("Introduce nombre de la persona a buscar:");
                    String name = scLetra.nextLine();
                    for (int i = 0; i < persona.length; i++) {
                        if (persona[i] != null) {
                            if (persona[i].getNombre().equalsIgnoreCase(name)) {
                                System.out.println(
                                        "Has encontrado a la persona:  " + persona[i].getNombre().toUpperCase());
                              
                            }
                        }
                    }
                    System.out.println("No se ha encontrado a la persona");
                    break;
                case 5:
                    System.out.println("Has salido");
                    break;

                default:
                    System.out.println("===ERROR===");
                    break;
            }

        } while (opcion != 5);

    }
}
