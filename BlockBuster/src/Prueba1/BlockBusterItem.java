package Prueba1;

import java.util.Calendar;

public abstract class BlockBusterItem {
    protected String nombre;
    protected int codigo;
    protected double precioRenta;
    protected Calendar fecha;

    public BlockBusterItem(String nombre, int codigo, double precioRenta) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precioRenta = precioRenta;
        fecha=Calendar.getInstance();
    }
    
    public String toString() {
        return "Nombre: "+nombre+", Código: "+codigo+", Precio de renta: Lps. "+precioRenta;
    }
    public abstract double pagoRenta(int dias); 

    
    
}
