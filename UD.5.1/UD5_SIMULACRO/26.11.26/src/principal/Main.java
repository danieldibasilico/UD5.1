import java.util.Scanner;

import clase.Producto;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner scLetras = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Producto[] producto = new Producto[10];
        int opcion = 0;
        double ingreso = 0;
        int codigo = 0;

        // stock de prueba
        producto[0] = new Producto(1234, "perico", 200);
        producto[1] = new Producto(5432, "pez", 12);
        producto[2] = new Producto(5345, "pan", 40);
        producto[3] = new Producto(6741, "harina", 300);

        do {

            System.out.println("1. Dar de alta producto");
            System.out.println("2. Listar producto");
            System.out.println("3. Registrar venta");
            System.out.println("4. Reponer stock");
            System.out.println("5. Aplicar descuento");
            System.out.println("6. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    int precio = 0;
                    String nombre = "";
                    boolean inventarioLleno = false;
                    System.out.println("Dime el codigo del producto");
                    codigo = sc.nextInt();
                    System.out.println("Dime el nombre del producto");
                    nombre = scLetras.nextLine();
                    System.out.println("Dime el precio del producto");
                    precio = sc.nextInt();
                    int contador = 0;

                    for (int i = 0; i < producto.length; i++) {

                        if (producto[i] != null) {

                            contador++;
                            // significa que hay un producto -
                            // compruebo si el código está repetido
                            if (producto[i].getCodigo() == codigo) {
                                System.out.println("Codigo ya existente");
                                break;
                            }
                        } else {
                            // tengo un hueco
                            // y en las posiciones anteriores el código no estaba
                            producto[i] = new Producto(codigo, nombre, precio);
                            System.out.println("Producto dado de alta correctamente");

                            break;
                        }

                    }
                    if (contador == producto.length) {
                        System.out.println("Inventario completo");
                    }

                    System.out.println("Inventario lleno");
                    break;
                case 2:
                    System.out.println("===Productos===");
                    for (int i = 0; i < producto.length; i++) {
                        if (producto[i] != null) {
                            System.out.println("Codigo:" + producto[i].getCodigo() + " Nombre:"
                                    + producto[i].getNombre() + " Precio:" + producto[i].getPrecio() + " Stock:0");
                            if (producto[i].getStock() != 0) {
                                System.out.println("Codigo:" + producto[i].getCodigo() + " Nombre:"
                                        + producto[i].getNombre() + " Precio:" + producto[i].getPrecio() + " Stock:"
                                        + producto[i].getStock());
                            }
                        }
                    }

                    break;
                case 3:
                    int value = 0;
                    int codigoProducto;
                    int unidades;
                    double ganancia;
                    int venta;
                    System.out.println("Dime el codigo del producto vendido");
                    codigoProducto = sc.nextInt();
                    System.out.println("Unidades vendidas");
                    unidades = sc.nextInt();
                    for (int i = 0; i < producto.length; i++) {
                        if (producto[i].getCodigo() == codigoProducto) {
                            System.out.println("Producto encontrado");
                            if (producto[i].getStock() > unidades) {
                                System.out.println("producto vendido correctamente");
                                venta = producto[i].getStock() - unidades;
                                producto[i].setStock(venta);
                                ganancia = producto[i].getPrecio() * unidades;
                                ingreso = ganancia;
                                break;
                            } else {
                                System.out.println("Stock insuficiente");
                                break;
                            }

                        } else {
                            value++;
                        }
                    }
                    if (value == producto.length) {
                        System.out.println("producto no encontrado");
                    }

                    break;
                case 4:
                    int comprobacion = 0;
                    int Stock = 0;
                    System.out.println("Codigo del producto:");
                    codigo = sc.nextInt();
                    System.out.println("Unidades a añadir:");
                    Stock = sc.nextInt();
                    for (int i = 0; i < producto.length; i++) {
                        if (producto[i].getCodigo() == codigo) {
                            System.out.println("Producto encontrado");
                            System.out.println("añadido el nuevo stock");
                            producto[i].setStock(Stock);
                            break;
                        } else {
                            comprobacion++;
                        }
                    }
                    if (comprobacion == producto.length) {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 5:

                    break;
                case 6:

                    break;

                default:
                    break;
            }

        } while (opcion != 7);

    }
}
