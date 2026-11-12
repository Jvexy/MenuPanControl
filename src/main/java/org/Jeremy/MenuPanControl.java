package org.Jeremy;

import java.util.Scanner;

public class MenuPanControl
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int capacidadMax = 10;
        String[] nombres = new String[capacidadMax];
        String[] correos = new String[capacidadMax];
        String[] contrasenas = new String[capacidadMax];
        String[] roles = new String[capacidadMax];

        int totalUsuarios = 0;

        nombres[0] = "Crispín Mendoza";
        correos[0] = "crispin@gmail.com";
        contrasenas[0] = "Pan123";
        roles[0] = "dueño";
        totalUsuarios++;


        nombres[1] = "Juan Pérez";
        correos[1] = "juan@gmail.com";
        contrasenas[1] = "cliente123";
        roles[1] = "cliente";
        totalUsuarios++;

        int opcion = 0;
        do
        {
            System.out.println("\n========================================");
            System.out.println("   PANCONTROL - PANADERÍA \"DON NICO\"    ");
            System.out.println("========================================");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse (Cliente)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt())
            {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else
            {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion)
            {
                case 1:

                    System.out.println("\n--- INICIAR SESIÓN ---");
                    System.out.print("Ingrese correo electrónico: ");
                    String correoIngresado = scanner.nextLine().trim();
                    System.out.print("Ingrese contraseña: ");
                    String passIngresada = scanner.nextLine().trim();

                    int indiceEncontrado = -1;
                    for (int i = 0; i < totalUsuarios; i++) {
                        if (correos[i] != null && correos[i].equalsIgnoreCase(correoIngresado))
                        {
                            indiceEncontrado = i;
                            break;
                        }
                    }

                    if (indiceEncontrado == -1) {
                        System.out.println("Mensaje: No tienes una cuenta registrada con ese correo.");
                    } else {
                        if (contrasenas[indiceEncontrado].equals(passIngresada))
                        {
                            System.out.println("Mensaje: Sesión iniciada.");

                            if (roles[indiceEncontrado].equalsIgnoreCase("dueño"))
                            {
                                mostrarPanelDueño(scanner, nombres[indiceEncontrado]);
                            } else {
                                mostrarPortalCliente(scanner, nombres[indiceEncontrado]);
                            }
                        } else {
                            System.out.println("Mensaje: Datos no coinciden (Contraseña incorrecta).");
                        }
                    }
                    break;

                case 2:
                    if (totalUsuarios >= capacidadMax)
                    {
                        System.out.println("Error: El sistema ha alcanzado el límite máximo de usuarios.");
                        break;
                    }

                    System.out.println("\n--- REGISTRO DE NUEVA CUENTA ---");
                    System.out.print("Ingrese su nombre completo: ");
                    String nuevoNombre = scanner.nextLine().trim();
                    System.out.print("Ingrese su correo electrónico: ");
                    String nuevoCorreo = scanner.nextLine().trim();
                    System.out.print("Ingrese su contraseña: ");
                    String nuevaPass = scanner.nextLine().trim();


                    if (nuevoNombre.isEmpty() || nuevoCorreo.isEmpty() || nuevaPass.isEmpty())
                    {
                        System.out.println("Error: Todos los campos son obligatorios.");
                        break;
                    }

                    boolean correoExistente = false;
                    for (int i = 0; i < totalUsuarios; i++)
                    {
                        if (correos[i] != null && correos[i].equalsIgnoreCase(nuevoCorreo))
                        {
                            correoExistente = true;
                            break;
                        }
                    }

                    if (correoExistente) {
                        System.out.println("Mensaje: Ya existe un registro con este correo.");
                    } else {
                        nombres[totalUsuarios] = nuevoNombre;
                        correos[totalUsuarios] = nuevoCorreo;
                        contrasenas[totalUsuarios] = nuevaPass;
                        roles[totalUsuarios] = "cliente";
                        totalUsuarios++;
                        System.out.println("Mensaje: ¡Registro exitoso! Ya puede iniciar sesión.");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del sistema PanControl. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    public static void mostrarPanelDueño(Scanner scanner, String nombreDueño)
    {
        int opcionDueño = 0;
        do {
            System.out.println("\n========================================");
            System.out.println("       PANEL DEL DUEÑO (ADMIN)          ");
            System.out.println(" Bienvenid@, " + nombreDueño);
            System.out.println("========================================");
            System.out.println("1. Gestionar Inventario de Productos");
            System.out.println("2. Registrar Ingresos por Venta");
            System.out.println("3. Registrar Gastos / Inversiones");
            System.out.println("4. Consultar Reportes Financieros");
            System.out.println("5. Revisar Pedidos de Clientes");
            System.out.println("6. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt())
            {
                opcionDueño = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcionDueño)
            {
                case 1 -> System.out.println("\n[Módulo de Productos / Inventario activado]");
                case 2 -> System.out.println("\n[Módulo de Ingresos en mostrador activado]");
                case 3 -> System.out.println("\n[Módulo de Gastos de insumos activado]");
                case 4 -> System.out.println("\n[Módulo de Reportes financieros activado]");
                case 5 -> System.out.println("\n[Módulo de Notificaciones de pedidos activado]");
                case 6 -> System.out.println("Cerrando sesión de administrador...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcionDueño != 6);
    }

    public static void mostrarPortalCliente(Scanner scanner, String nombreCliente)
    {
        int opcionCliente = 0;
        do
        {
            System.out.println("\n========================================");
            System.out.println("          PORTAL DEL CLIENTE            ");
            System.out.println(" Bienvenid@, " + nombreCliente);
            System.out.println("========================================");
            System.out.println("1. Explorar Catálogo de Panadería");
            System.out.println("2. Agregar Productos al Carrito");
            System.out.println("3. Confirmar Pedido (Checkout y Dirección)");
            System.out.println("4. Cerrar Sesión");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt())
            {
                opcionCliente = scanner.nextInt();
                scanner.nextLine();
            } else
            {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcionCliente)
            {
                case 1 -> System.out.println("\n[Catálogo interactivo de Panadería \"Don Nico\"]");
                case 2 -> System.out.println("\n[Gestión del carrito de compras]");
                case 3 -> System.out.println("\n[Checkout: Captura de dirección y confirmación]");
                case 4 -> System.out.println("Cerrando sesión de cliente...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcionCliente != 4);
    }
}