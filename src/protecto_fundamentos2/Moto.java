
package protecto_fundamentos2;

public class Moto extends Vehiculo  {
    
    public static double precioMotos;
    
    public Moto() {
        
    }
    
    public Moto(String p, String m, String c) {
        super(p,m,c);
        this.tipo = "MOTO";
    }
    
    public Moto(String p, String m, String c, int v) {
        super (p,m,c,v);
        this.tipo = "MOTO";
    }
    
    public void imprimirTipo() {
        System.out.println("MOTO");
    }
    
    @Override 
    public String pago() {
        
        double tiempo = super.tiempoEnParqueadero();
        double pago = tiempo * (precioMotos);
        
        String concat = "Tiempo de estadia en el parqueadero: " + String.format("%.4f", tiempo) + " horas";
        concat = concat + System.lineSeparator() + "Valor a pagar: " + "$" + String.format("%.2f", pago);
        
        return concat; 

    }
}