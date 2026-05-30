import java.io.BufferedReader;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        
        LectorDeArchivos lector = new LectorDeArchivos();
        
        ArrayList<Paquete> misPaquetes = lector.obtenerPaquetes("Paquetes.csv");

        ArrayList<Camion> misCamiones = lector.obtenerCamiones("Camiones.csv");
           
        
        for (Camion c : misCamiones) {
            System.out.println("Cargué el camión patente: " + c.getPatente() );
        }
          
    }
}