
package protecto_fundamentos2;

public class Carro extends Vehiculo {
    
    public static double precioCarros; 
    
    public Carro() {
        
    }
    
    public Carro(String p, String m, String c) {
        super(p,m,c);
        this.tipo = "CARRO";
       
    }
    
    public Carro(String p, String m, String c, int v) {
        super (p,m,c,v);
        this.tipo = "CARRO";
    }
    
    public void imprimirTipo() {
        System.out.println("CARRO");
    }
    @Override 
    public String pago() {
        
        double tiempo = super.tiempoEnParqueadero();
        double pago = tiempo * (precioCarros);
        
        String concat = "Tiempo de estadia en el parqueadero: " + String.format("%.4f", tiempo) + " horas";
        concat = concat + System.lineSeparator() + "Valor a pagar: " + "$" + String.format("%.2f", pago);
        
        return concat; 

    }
    
}
