
package protecto_fundamentos2;
import java.util.Date;
public class Vehiculo {
    
    private String placa; 
    private String marca; 
    private String color; 
    private int valorComercial;
    private Date horaIngreso;
    protected String tipo; 
    
    public static int tamano;
    public static int cantidad = 0;
    public static Vehiculo[][] vehiculos; 
    
    public Vehiculo() {
        
    }
    
    public Vehiculo(String p, String m, String c) {
        this(p, m, c, 30000000);    
    }
    
    public Vehiculo(String p, String m, String c, int v) {
        this.placa = p.toUpperCase(); 
        this.marca = m.toUpperCase(); 
        this.color = c.toUpperCase(); 
        
        if (v >= 0) {
          this.valorComercial = v;
        } else {
          this.valorComercial = 30000000;
        }
        
        Date tiempoEntrada = new Date();
        this.horaIngreso = tiempoEntrada;
        
        cantidad = cantidad + 1; 
    }
    
    public void setPlaca(String p) {
        this.placa = p.toUpperCase(); 
    }
    
    public String getPlaca() {
       return this.placa;
    }
    
    public void setMarca(String m) {
        this.marca = m.toUpperCase(); 
    }
    
    public String getMarca() {
       return this.marca;
    }
    
    public void setColor(String c) {
        this.color = c.toUpperCase(); 
    }
    
    public String getColor() {
       return this.color;
    }
    
    public void setValorComercial(int v) {
        if (v >= 0) {
          this.valorComercial = v;
        } else {
          this.valorComercial = 30000000;
        } 
    }
    
    public int getValorComercial() {
       return this.valorComercial;
    }
    
    public Date getHoraIngreso(){
        return this.horaIngreso;
        
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    @Override
    public String toString() {
        
        String informacion1 = "{Tipo: " + this.tipo + ", Placa: " + this.placa + ", Marca: " + this.marca + ", Color: " + this.color;
        String informacion2 =  ", Valor Comercial: " + this.valorComercial + ", Hora de Parqueo: " + this.horaIngreso; 
        String informacionCompleta = informacion1 + informacion2;
        return informacionCompleta;
    }
    
    public static String toStringVehiculos() {
        String infoTodos = "Información Vehículos:"; 
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j ++) {
                
                if (vehiculos [i][j] != null) {
                    String infoIndividual = System.lineSeparator() + vehiculos[i][j].toString() + ", Piso: " + i + ", Espacio: " + j + "}";
                    infoTodos = infoTodos + infoIndividual; 
                }
            }
        }
        
        if (infoTodos.equals("Información Vehículos:")) {
            infoTodos = "No hay ningún vehículo en el parqueadero"; }
        
        return infoTodos; 
    }
    
    public static int cantidadVehiculos() {
        return cantidad; 
    }
    
    public static String colorEspecifico (String c){
        String colorIgual = "Vehículos con el color " + c + ":";
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j ++) {
                
                if (vehiculos[i][j] != null && c.equals(vehiculos[i][j].getColor())) {
                    String infoIndividual = System.lineSeparator() + vehiculos[i][j].toString();
                    colorIgual = colorIgual + infoIndividual;    
                } 
            }
        }
        
        if(colorIgual.equals("Vehículos con el color " + c + ":")) {
            colorIgual = colorIgual + " Ninguno"; }
        
        return colorIgual; 
    }
    
    public static Vehiculo[] valoresOrdenados(int cantidadActual) {
        Vehiculo[] ordenValores = new Vehiculo[cantidadActual];
        int indice = 0; 
        
        for (int i = 0; i < vehiculos.length; i++) {
            for (int j = 0; j < vehiculos[i].length; j++) {
                
                if(vehiculos[i][j] != null){
                    ordenValores[indice] = vehiculos[i][j];
                    indice++; 
                }
            }
        }
        
        Vehiculo temp = new Vehiculo(); 
                
        for(int i = 1; i < ordenValores.length; i++) { 
            for(int j = 0; j < (ordenValores.length -i); j++){
                
                 if(ordenValores[j].getValorComercial() > ordenValores[j+1].getValorComercial()){
                    temp = ordenValores[j];
                    ordenValores[j] = ordenValores[j+1];
                    ordenValores[j+1] = temp; 
                }
            }
        }
        
        return ordenValores; 
    }
    public double tiempoEnParqueadero(){
 
        Date tiempoSalida = new Date();
        long diferencia = tiempoSalida.getTime() - this.horaIngreso.getTime();
        double tiempo = (double) diferencia/60000;
        tiempo = tiempo/60;   
 
        return tiempo;
    }
 
    public String pago () {
 
        return "";
    }
    
}
