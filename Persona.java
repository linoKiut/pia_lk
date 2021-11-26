
package pia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;



public class Persona {
    
    private String Nombre;
    private String Direccion;
    private int Telefono;
    private String Correo;

    public Persona() {
        this.Nombre ="";
        this.Direccion ="";
        this.Telefono = 0;
        this.Correo = "";
    }

    
    public Persona(String Nombre, String Direccion, int Telefono, String Correo) {
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    

  
    
}
    
    
    
    
           
    
    
    
    
 