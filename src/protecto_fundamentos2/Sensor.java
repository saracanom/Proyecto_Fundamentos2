
package protecto_fundamentos2;
public class Sensor {
    
    private int estado;
    public static Sensor[][] sensores;
    
    public Sensor(){    
        
    }
    
    public Sensor(int e){
        if (e == 1 || e == 0){
            this.estado = e; 
        } else {
            this.estado = 0; 
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int e) {
        if (e == 1 || e == 0){
            this.estado = e; 
        } else {
            this.estado = 0;
        }
    }
    
    public String toString() {
        String estadoActual = ""; 
        if(this.estado == 1){
            estadoActual = "Ocupado";
        } else if (this.estado == 0) {
            estadoActual = "Libre";
        }
        
        return estadoActual; 
    }
    
    public static String sensorLibre(){
        String concat = "Sensores Libres:";
        for(int i = 0; i < sensores.length; i++){
            for(int j = 0; j < sensores[i].length; j++){
                
                if(sensores[i][j]!= null && sensores[i][j].getEstado()== 0){
                        String infoIndividual = System.lineSeparator() + "{Piso: " + i + ", Espacio: " + j + "}";
                        concat = concat + infoIndividual;
                }
            }
        }
        
        if(concat.equals("Sensores Libres:")) {
            concat = concat + " Ninguno. Parqueadero Lleno";
        }
        
        return concat;
    }
        
    public static String sensoresEstado(){
        String concat = "Información de todos los sensores:";
        for(int i = 0; i < sensores.length; i++){
            for(int j = 0; j < sensores[i].length; j++){
                
                if (sensores[i][j]!= null) {
                    String infoIndividual = System.lineSeparator() + "{Piso: " + i + ", Espacio: " + j + ", Estado: " + sensores[i][j].toString() + "}";
                    concat = concat + infoIndividual; 
                    }
                }
        }
        
        return concat;  
    }
    
}

