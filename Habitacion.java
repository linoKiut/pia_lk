
package pia;

public class Habitacion {
    
    private int numHab,dias,precioTotal;
    
    public Habitacion() {
        this.numHab = 0;
        this.dias = 0;
        this.precioTotal = 0;
    }

    public Habitacion(int numHab, int dias, int precioTotal) {
        this.numHab = numHab;
        this.dias = dias;
        this.precioTotal = precioTotal;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
    

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    
}
