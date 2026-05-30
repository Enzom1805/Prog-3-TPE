import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Ejecutamos los métodos de carga
        ArrayList<Camion> arregloCamiones = LectorDeArchivos.cargarCamiones("Camiones.csv");
        ArrayList<Paquete> arregloPaquetes = LectorDeArchivos.cargarPaquetes("Paquetes.csv");

        // Comprobación rápida para ver si se cargaron correctamente
        if (arregloCamiones != null) {
            System.out.println("--- CAMIONES CARGADOS ---");
            for (Camion c : arregloCamiones) {
                System.out.println("Camión ID: " + c.getId_camion() + " | Patente: " + c.getPatente() + 
                                   " | Capacidad: " + c.getCapacidad_kg() + "kg | Refri: " + c.esta_refrigerado());
            }
        }

        System.out.println();

        if (arregloPaquetes != null) {
            System.out.println("--- PAQUETES CARGADOS ---");
            for (Paquete p : arregloPaquetes) {
                System.out.println("Paquete ID: " + p.getId_paquete() + " | Código: " + p.getCodigo_paquete() + 
                                   " | Peso: " + p.getPeso_kg() + "kg | Alimentos: " + p.contiene_alimentos() + 
                                   " | Urgencia: " + p.getNivel_urgencia());
            }
        }
    }
}
