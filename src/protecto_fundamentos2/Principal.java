
package protecto_fundamentos2;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Date;
public class Principal {
 
    public static void main(String[] args) throws Exception {
 
        Scanner scan = new Scanner(System.in);
 
        System.out.println("Ingrese la cantidad de pisos del edificio:");
        int pisos = scan.nextInt();
        System.out.println(System.lineSeparator() + "Ingrese la cantidad de espacios de parqueo por piso:");
        int espacios = scan.nextInt();
        System.out.println(" ");
 
        if(pisos > 0 && espacios > 0) {
            Vehiculo.vehiculos = new Vehiculo[pisos][espacios];
            Sensor.sensores = new Sensor[pisos][espacios];
        } else {
            System.out.println("El valor de los pisos y los espacios debe ser mayor que 0");
            System.exit(0);
        }
 
        for (int i = 0; i < pisos; i++) {
            for (int j = 0; j < espacios; j ++) {
                Sensor S = new Sensor(0); 
                Sensor.sensores[i][j] = S;  
            }
        }
 
        System.out.println("Ingrese el valor a cobrar por hora para motos:");
        Moto.precioMotos = scan.nextDouble();
        System.out.println(System.lineSeparator() + "Ingrese el valor a cobrar por hora para carros:");
        Carro.precioCarros = scan.nextDouble(); 
        System.out.println(" ");
 
        Vehiculo.tamano = (pisos)*(espacios); 
 
        System.out.println(System.lineSeparator() + "¿Qúe desea hacer?");
        System.out.println("1: Mostrar sensores libres");
        System.out.println("2: Parquear vehículo sin valor comercial");
        System.out.println("3: Parquear vehículo con valor comercial");
        System.out.println("4: Mostrar información de todos los vehículos parqueados actualmente");
        System.out.println("5: Mostrar cantidad de vehículos actuales y disponibilidad del parqueadero");
        System.out.println("6: Mostrar estado de sensor específico");
        System.out.println("7: Mostrar estado de todos los sensores");
        System.out.println("8: Mostrar los vehiculos del mismo color");
        System.out.println("9: Mostrar vehiculos ordenados por valor comercial");
        System.out.println("10: Salida de un vehículo del parqueadero");
        System.out.println("11: Exportar un archivo .txt con toda la información de los vehículos parqueados actualmente");
        System.out.println("0: Salir del programa" + System.lineSeparator());
 
        int accion = scan.nextInt();
 
        while (true) {
 
            if (accion == 0) {
                System.out.println("Saliendo...");
                break; 
            }
 
            switch (accion) {
 
                case 1: 
                    System.out.println(Sensor.sensorLibre());
                    break; 
 
                case 2: 
 
                    if (Vehiculo.cantidad == Vehiculo.tamano) {
                        System.out.println("El parqueadero esta lleno. No puede parquear.");
                        break;
                    }
 
                    System.out.println("¿En qué piso desea parquear?");
                    System.out.println("Recuerde que los pisos van de 0 a " + (pisos-1));
                    int piso2 = scan.nextInt(); 
                    System.out.println(System.lineSeparator() + "¿En qué espacio desea parquear?");
                    System.out.println("Recuerde que los espacios van de 0 a " + (espacios-1));
                    int espacio2 = scan.nextInt(); 
                    System.out.println(" ");
 
                    if (!(piso2 < pisos && piso2 >= 0 && espacio2 < espacios && piso2 >= 0)) {
                        System.out.println("Piso o espacio inválido. Vuelva a intentarlo." + System.lineSeparator()); 
                        continue; 
                    }
 
                    if (Sensor.sensores[piso2][espacio2].getEstado() == 1) {
                        System.out.println("Este espacio esta ocupado. Ingrese un piso y un espacio diferente." + System.lineSeparator());
                        continue;
                    } 
 
                    System.out.println("¿Desea parquear una moto o un carro?");
                    String tipoVehiculo = scan.next().toLowerCase();
                    System.out.println(" ");
 
                    if (!(tipoVehiculo.equals("moto") || tipoVehiculo.equals("carro"))) {
                        System.out.println("Tipo de vehículo inválido. Vuelva a intentarlo." + System.lineSeparator());
                        continue;
                    }
 
                    Vehiculo V; 
 
                    if (tipoVehiculo.equals("moto")) {
                        System.out.println("Ingrese la placa de la moto:");
                        String placaMoto = scan.next(); 
                        System.out.println("Ingrese la marca de la moto:");
                        String marcaMoto = scan.next(); 
                        System.out.println("Ingrese el color de la moto:");
                        String colorMoto = scan.next();
                        System.out.println(" ");
 
                        V = new Moto(placaMoto, marcaMoto, colorMoto);
 
                    } else {
                        System.out.println("Ingrese la placa del carro:");
                        String placaCarro = scan.next(); 
                        System.out.println("Ingrese la marca del carro:");
                        String marcaCarro = scan.next(); 
                        System.out.println("Ingrese el color del carro:");
                        String colorCarro = scan.next();
                        System.out.println(" ");
 
                        V = new Carro(placaCarro, marcaCarro, colorCarro);
 
                    }
 
                    Vehiculo.vehiculos[piso2][espacio2] = V;
                    Sensor.sensores[piso2][espacio2].setEstado(1);
                    System.out.println("Vehículo parqueado en piso " + piso2 + ", espacio " + espacio2 + ": " + Vehiculo.vehiculos[piso2][espacio2].toString()+"}");
                    break; 
 
                case 3: 
 
                    if (Vehiculo.cantidad == Vehiculo.tamano) {
                        System.out.println("El parqueadero esta lleno. No puede parquear.");
                        break;
                    }
 
                    System.out.println("¿En qué piso desea parquear?"); 
                    System.out.println("Recuerde que los pisos van de 0 a " + (pisos-1));
                    int piso3 = scan.nextInt(); 
                    System.out.println(System.lineSeparator() + "¿En qué espacio desea parquear?");
                    System.out.println("Recuerde que los espacios van de 0 a " + (espacios-1));
                    int espacio3 = scan.nextInt();
                    System.out.println(" ");
 
                    if (!(piso3 < pisos && piso3 >= 0 && espacio3 < espacios && espacio3 >= 0)) {
                        System.out.println("Piso o espacio inválido. Vuelva a intentarlo." + System.lineSeparator()); 
                        continue;
                    }
 
                    if (Sensor.sensores[piso3][espacio3].getEstado() == 1) {
                        System.out.println("Este espacio esta ocupado. Ingrese un piso y un espacio diferente." + System.lineSeparator());
                        continue; 
                    }
 
                    System.out.println("¿Desea parquear una moto o un carro?");
                    String tipoVehiculo3 = scan.next().toLowerCase();
                    System.out.println(" ");
 
                    if (!(tipoVehiculo3.equals("carro") || tipoVehiculo3.equals("moto"))) {
                        System.out.println("Tipo de vehículo inválido. Vuelva a intentarlo." + System.lineSeparator());
                        continue;
                    }
 
                    Vehiculo V2; 
 
                    if (tipoVehiculo3.equals("moto")) { 
                        System.out.println("Ingrese la placa de la moto:");
                        String placaMoto = scan.next(); 
                        System.out.println("Ingrese la marca de la moto:");
                        String marcaMoto = scan.next(); 
                        System.out.println("Ingrese el color de la moto:");
                        String colorMoto = scan.next();
                        System.out.println("Ingrese el valor comercial de la moto:");
                        int valorMoto = scan.nextInt();
                        System.out.println(" ");
 
                        V2 = new Moto(placaMoto, marcaMoto, colorMoto, valorMoto);
 
                    } else {
                        System.out.println("Ingrese la placa del carro:");
                        String placaCarro = scan.next(); 
                        System.out.println("Ingrese la marca del carro:");
                        String marcaCarro = scan.next(); 
                        System.out.println("Ingrese el color del carro:");
                        String colorCarro = scan.next();
                        System.out.println("Ingrese el valor comercial del carro:");
                        int valorCarro = scan.nextInt();
                        System.out.println(" ");
 
                        V2 = new Carro(placaCarro, marcaCarro, colorCarro, valorCarro);
 
                    }
 
                    Vehiculo.vehiculos[piso3][espacio3] = V2;
                    Sensor.sensores[piso3][espacio3].setEstado(1);
                    System.out.println("Vehículo parqueado en piso " + piso3 + ", espacio " + espacio3 + ": " + Vehiculo.vehiculos[piso3][espacio3].toString() + "}");
                    break;
 
                case 4:
                    System.out.println(Vehiculo.toStringVehiculos());
                    break;
 
                case 5:
                    System.out.println("Cantidad de vehículos actual: " + Vehiculo.cantidad);
                    int cantidadRestante = Vehiculo.tamano - Vehiculo.cantidad;
                    System.out.println("Pueden entrar " + cantidadRestante + " vehículos más al parqueadero");
                    break;
 
                case 6:
                    System.out.println("Ingrese el piso que desea consultar: ");
                    System.out.println("Recuerde que los pisos van de 0 a " + (pisos-1));
                    int consultaPiso = scan.nextInt(); 
                    System.out.println(System.lineSeparator() + "Ingrese el espacio que desea consultar:");
                    System.out.println("Recuerde que los espacios van de 0 a " + (espacios-1));
                    int consultaEspacio = scan.nextInt();
                    System.out.println(" ");
 
                    if (!(consultaPiso < pisos && consultaPiso >= 0 && consultaEspacio < espacios && consultaEspacio >= 0)) {
                        System.out.println("Piso o espacio inválido. Vuelva a intentarlo." + System.lineSeparator()); 
                        continue;
                    }    
 
                    System.out.println("El estado del sensor ingresado es: " + Sensor.sensores[consultaPiso][consultaEspacio].toString());
 
                    if (Sensor.sensores[consultaPiso][consultaEspacio].getEstado() == 1) {
                        System.out.print("El vehículo parqueado en el piso " + consultaPiso + " espacio " + consultaEspacio + " es: ");
                        System.out.println(Vehiculo.vehiculos[consultaPiso][consultaEspacio].toString() + "}");
                    }
                    break;
 
                case 7:
                    System.out.println(Sensor.sensoresEstado());
                    break; 
 
                case 8:
                    System.out.println("¿Qué color desea consultar?");
                    String color = scan.next().toUpperCase();
                    System.out.println(System.lineSeparator() + Vehiculo.colorEspecifico(color));
                    break; 
 
                case 9: 
                    String orden = "Vehículos ordenados por valor comercial:";
 
                    for (int i = 0; i < Vehiculo.valoresOrdenados(Vehiculo.cantidad).length; i++) {
                        orden = orden + System.lineSeparator() + Vehiculo.valoresOrdenados(Vehiculo.cantidad)[i].toString() + "}"; 
                    }
 
                    if (orden.equals("Vehículos ordenados por valor comercial:")) {
                        orden = "No hay ningún vehículo en el parqueadero"; 
                    }
 
                    System.out.println(orden);
                    break; 
 
                case 10:
                    
                    if (Vehiculo.cantidad == 0) {
                        System.out.println("No hay ningun vehículo en el parqueadero.");
                        break;
                    }
                    
                    System.out.println("Ingrese el piso en el que estaba parqueado el vehículo:");
                    System.out.println("Recuerde que los pisos van de 0 a " + (pisos-1));
                    int piso10 = scan.nextInt();
                    System.out.println(System.lineSeparator() + "Ingrese el espacio en el que estaba parqueado el vehículo;");
                    System.out.println("Recuerde que los espacios van de 0 a " + (espacios-1));
                    int espacio10 = scan.nextInt(); 
                    System.out.println(" ");
                        
                    if (!(piso10 < pisos && piso10 >= 0 && espacio10 < espacios && espacio10 >= 0)) {
                        System.out.println("Piso o espacio inválido. Vuelva a intentarlo." + System.lineSeparator()); 
                        continue;
                    }
                            
                    if (Sensor.sensores[piso10][espacio10].getEstado() == 0){
                        System.out.println("Consulta inválida, este espacio estaba desocupado. Ingrese un piso y un espacio diferente." + System.lineSeparator());
                        continue;
                    } 
                    
                    Sensor.sensores[piso10][espacio10].setEstado(0);
                    Vehiculo.cantidad--;
                    System.out.println("El vehículo que evacua del parqueadero es: " + Vehiculo.vehiculos[piso10][espacio10].toString() + "}");
                    System.out.println(Vehiculo.vehiculos[piso10][espacio10].pago());
                    Vehiculo.vehiculos[piso10][espacio10] = null; 
                    System.out.println("El piso " + piso10 + ", espacio " + espacio10 + " ahora está: " + Sensor.sensores[piso10][espacio10].toString());
                    
                    break;
                case 11:
                    FileWriter archivo = new FileWriter("vehiculos.txt");
                    archivo.write(Vehiculo.toStringVehiculos());
                    archivo.close();
                    System.out.println("Archivo .txt exportado");
                    break; 
 
                case -1: 
                    System.out.println("¿Qúe desea hacer?");
                    System.out.println("1: Mostrar sensores libres");
                    System.out.println("2: Parquear vehículo sin valor comercial");
                    System.out.println("3: Parquear vehículo con valor comercial");
                    System.out.println("4: Mostrar información de todos los vehículos parqueados actualmente");
                    System.out.println("5: Mostrar cantidad de vehículos actuales y disponibilidad del parqueadero");
                    System.out.println("6: Mostrar estado de sensor específico");
                    System.out.println("7: Mostrar estado de todos los sensores");
                    System.out.println("8: Mostrar los vehiculos del mismo color");
                    System.out.println("9: Mostrar vehículos ordenados por valor comercial");
                    System.out.println("10: Salida de un vehículo del parqueadero");
                    System.out.println("11: Exportar un archivo .txt con toda la información de los vehículos parqueados actualmente");
                    System.out.println("0: Salir del programa");
                    break; 
 
                default: 
                    System.out.println("Comando incorrecto");
                    break;  
                }
 
            System.out.println(System.lineSeparator() + System.lineSeparator() + "Ingrese una nueva opción del menú");
            System.out.println("Para volver a ver el menú ingrese -1");
            accion = scan.nextInt();
            System.out.println(" ");
        }
    }
}