package pia;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PIA {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner lectura = new Scanner(System.in);
        String clave, contrasena;
        int Nper = 0, Nrev = 0;
        int Cor = 2;
        File ArchPersona = new File("./persona.txt");
        File ArchHabitaciones = new File("./habitaciones.txt");

        Persona persona = new Persona();
        Habitacion habitaciones = new Habitacion();

        System.out.println("Ingrese la id: ");
        clave = lectura.nextLine();
        System.out.println("Ingrese la contrasena: ");
        contrasena = lectura.nextLine();

        Empleado encontrado = Empleado.buscarEmpleado(clave, contrasena);
        if (encontrado == null) {
            System.out.println("No Encontrado");
        } else {

            int opc;
            do {

                System.out.println("\tMENU PRINCIPAL\n");
                System.out.println("1) Iniciar proceso reservacion");
                System.out.println("2) Mostrar Habitaciones");
                System.out.println("3) Cerrar Programa");
                System.out.println("Ingrese el numero de la opcion deseada: ");
                opc = lectura.nextInt();
                lectura.nextLine();

                switch (opc) {
                    case 1:
                        Nper++;

                        do {
                            System.out.println("\tPROCESO DE RESERVACION\n");
                            System.out.println("\n\tDatos Personales\n");

                            System.out.println("Ingrese los datos de la persona [" + Nper + "]");
                            System.out.println("Ingrese el nombre: ");
                            persona.setNombre(lectura.nextLine());
                            System.out.println("Ingrese su numero de telefono: ");
                            persona.setTelefono(lectura.nextInt());
                            lectura.nextLine();
                            System.out.println("Ingrese su direcion: ");
                            persona.setDireccion(lectura.nextLine());
                            System.out.println("Ingrese su correo electronico: ");
                            persona.setCorreo(lectura.nextLine());

                            System.out.println("\n\nPersona [" + Nper + "]");
                            System.out.println("Nombre: " + persona.getNombre());
                            System.out.println("Numero de telefono: " + persona.getTelefono());
                            System.out.println("Direccion: " + persona.getDireccion());
                            System.out.println("Correo electronico: " + persona.getCorreo() + "\n\n");

                            System.out.println("Si los datos son correctos ingrese 1 \n de lo contrario ingrese cualquier numero");
                            Cor = lectura.nextInt();
                            lectura.nextLine();

                        } while (Cor != 1);
                        Cor = 2;

                        if (!ArchPersona.exists()) {
                            try {
                                ArchPersona.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            FileWriter fw = new FileWriter(ArchPersona, true);
                            PrintWriter pw = new PrintWriter(fw);

                            if (!pw.checkError()) {
                                pw.println("Persona [" + Nper + "]");

                                pw.println("Nombre: " + persona.getNombre());
                                pw.println("Numero de telefono: " + persona.getTelefono());
                                pw.println("Direccion: " + persona.getDireccion());
                                pw.println("Correo electronico: " + persona.getCorreo() + "\n\n");

                            }
                            pw.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Datos de la persona registrados.");

                        Nrev++; //numero de reservaciones

                        Habitaciones NomHab;

                        do {

                            System.out.println("\n\tDatos de habitacion\n");

                            System.out.println("Numero de habitaciones: ");
                            habitaciones.setNumHab(lectura.nextInt());
                            lectura.nextLine();
                            System.out.println("Ingrese los dias de hospedaje: ");
                            habitaciones.setDias(lectura.nextInt());
                            lectura.nextLine();
                            System.out.println("\tTipo de habitacion");
                            System.out.println("1) Individual");
                            System.out.println("2) Doble");
                            System.out.println("3) Suite");

                            System.out.println("Ingrese el nombre de la opcion deseada: ");
                            Habitaciones habitacion = Habitaciones.valueOf(lectura.nextLine());

                            NomHab = habitacion;

                            habitaciones.setPrecioTotal(habitaciones.getDias() * habitaciones.getNumHab() * habitacion.precio);

                            System.out.println("Numero de habitaciones: " + habitaciones.getNumHab());
                            System.out.println("Dias reservados: " + habitaciones.getDias());
                            System.out.println("Tipo de habitacion: " + NomHab);
                            System.out.println("Precio Total: " + habitaciones.getPrecioTotal() + "\n\n");

                            System.out.println("Si los datos son correctos ingrese 1 \n de lo contrario ingrese cualquier numero");
                            Cor = lectura.nextInt();
                            lectura.nextLine();

                        } while (Cor != 1);

                        if (!ArchHabitaciones.exists()) {
                            try {
                                ArchHabitaciones.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        try {
                            FileWriter fw = new FileWriter(ArchHabitaciones, true);
                            PrintWriter pw = new PrintWriter(fw);

                            if (!pw.checkError()) {
                                pw.println("Reservacion [" + Nrev + "]");

                                pw.println("Nombre del cliente: " + persona.getNombre());
                                pw.println("Tipo de habitacion: " + NomHab);
                                pw.println("Numero de habitaciones: " + habitaciones.getNumHab());
                                pw.println("Dias reservados: " + habitaciones.getDias());
                                pw.println("Precio Total: " + habitaciones.getPrecioTotal() + "\n\n");

                            }
                            pw.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Reservacion registrada.");

                        System.out.println("\n\tTicket de reservacion\n");
                        System.out.println("Nombre del cliente: " + persona.getNombre());
                        System.out.println("Tipo de habitacion: " + NomHab);
                        System.out.println("Numero de habitaciones: " + habitaciones.getNumHab());
                        System.out.println("Dias reservados: " + habitaciones.getDias());
                        System.out.println("Precio Total: " + habitaciones.getPrecioTotal());
                        System.out.println("Numero de empleado: " + clave + "\n\n");

                        break;
                    case 2:
                        System.out.println("\n\tOpciones de habitaciones");

                        Habitaciones h[] = Habitaciones.values();
                        for (int i = 0; i < h.length; i++) {
                            System.out.println("\n" + (i + 1) + ") " + h[i]);
                            System.out.println("Camas: " + h[i].getCamas());
                            System.out.println("Banos: " + h[i].getBanos());
                            System.out.println("Sillones: " + h[i].getSillones());
                            System.out.println("Tvs: " + h[i].getTv());
                            System.out.println("Precio por noche: " + h[i].getPrecio());
                        }
                        System.out.println("\n");
                        break;
                  

                    default:
                        break;
                }

            } while (opc != 4);

        }
        //Final del programa
    }

}
