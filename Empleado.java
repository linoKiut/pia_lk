package pia;

import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Empleado {

    private String idemple;
    private String contra;
    private String nombre;
    private boolean activo;

    public Empleado() {
        this.idemple = "";
        this.contra = "";
        this.nombre = "";
        this.activo = false;
    }

    public Empleado(String idemple, String contra, String nombre, boolean activo) {
        this.idemple = idemple;
        this.contra = contra;
        this.nombre = nombre;
        this.activo = activo;
    }

    public String getIdemple() {
        return idemple;
    }

    public void setIdemple(String idemple) {
        this.idemple = idemple;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return ("\nID Empleado: " + idemple
                + "\nNombre: " + nombre
                + (isActivo() ? "\nActivo" : "\nDesactivo"));
    }

    public static Empleado buscarEmpleado(String clave, String contrasena) throws FileNotFoundException
    {

        File archivo = new File("./Empleados.txt");
        Scanner lectura = null;
        Empleado encontrado = null;

        try {
            lectura = new Scanner(archivo);

            while (lectura.hasNextLine()) {
                String idemple = lectura.next();
                String contra = lectura.next();
                String nombre = lectura.next();
                boolean estado = lectura.nextBoolean();

                if (clave.equals(idemple) && contrasena.equals(contra) && estado == true) {
                    encontrado = new Empleado(idemple, contra, nombre, estado);
                    lectura.close();
                    return encontrado;
                }

                lectura.nextLine();
            }
            return encontrado;

        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage());
        } finally {

            try {
                if (lectura != null) {
                    lectura.close();
                }
                 } catch(Exception e) {
        System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
