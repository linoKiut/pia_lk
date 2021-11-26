
package pia;


public enum Habitaciones {
    Individual(1,1,0,1,1000),
    Doble(2,1,1,1,1500),
    Suite(2,2,2,2,2000);
    
    int camas,banos,sillones,tv,precio;

    private Habitaciones(int camas, int banos, int sillones, int tv, int precio) {
        this.camas = camas;
        this.banos = banos;
        this.sillones = sillones;
        this.tv = tv;
        this.precio = precio;
    }

    public int getCamas() {
        return camas;
    }

    public int getBanos() {
        return banos;
    }

    public int getSillones() {
        return sillones;
    }

    public int getTv() {
        return tv;
    }

    public int getPrecio() {
        return precio;
    }
    
    
    
    
    
}


