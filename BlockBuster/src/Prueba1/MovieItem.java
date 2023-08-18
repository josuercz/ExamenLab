package Prueba1;
import java.util.Calendar;
public class MovieItem extends BlockBusterItem {
    private String estado;
    
    MovieItem(String nombre, int codigo, double precioRenta){
        super(nombre, codigo, precioRenta);
        estado = "ESTRENO";
    }
    
    public String toString(){
        return super.toString()+", Estado: "+estado+" - Movie";
    }
    public double pagoRenta(int dias){
        double mili = super.getFecha().getTimeInMillis()+(86400000*dias);
        double renta = 45;
        if(estado.equals("ESTRENO") && mili+getFecha().getTimeInMillis()>getFecha().getTimeInMillis()+(86400000*2)){
            return renta+(50*dias-2);
        }
        else if(estado.equals("NORMAL") && mili+getFecha().getTimeInMillis()>getFecha().getTimeInMillis()+(86400000*5)){
            return renta+(30*dias-5);
        }
        return renta;
    }
    public void evaluarEstado(){
        Calendar fechaActual = Calendar.getInstance();
        getFecha().add(Calendar.MONTH, 5);
        if(fechaActual.after(getFecha())==true){
            estado = "NORMAL";
        }
    }
}
