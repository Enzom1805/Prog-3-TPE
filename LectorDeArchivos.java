import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDeArchivos {
        // Método para cargar los camiones desde el archivo CSV
    public static ArrayList<Camion> cargarCamiones(String ruta) {
        ArrayList<Camion> camiones = new ArrayList<>();;
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // 1. Leemos la primera línea para saltarla (ya no necesitamos el número para el tamaño)
            br.readLine(); 
            
            String linea;
            // 2. Leer el resto de las líneas hasta que se acabe el archivo
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(separador);
                
                String id = campos[0];
                String patente = campos[1];
                boolean estaRefrigerado = campos[2].equals("1");
                int capacidad = Integer.parseInt(campos[3]);

                Camion camion = new Camion(id, patente, capacidad);
                camion.setEsta_refrigerado(estaRefrigerado);
                
                // Agregamos el camión a la lista dinámica
                camiones.add(camion);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de camiones: " + e.getMessage());
        }
        return camiones;
    }

    // Ahora devuelve un ArrayList de Paquete
    public static ArrayList<Paquete> cargarPaquetes(String ruta) {
        ArrayList<Paquete> paquetes = new ArrayList<>(); // Inicializamos la lista vacía
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // 1. Leemos la primera línea para saltarla
            br.readLine(); 
            
            String linea;
            // 2. Leer el resto de las líneas
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(separador);
                
                String id = campos[0];
                String codigo = campos[1];
                double peso = Double.parseDouble(campos[2]);
                boolean contieneAlimentos = campos[3].equals("1");
                int urgencia = Integer.parseInt(campos[4]);

                Paquete paquete = new Paquete(id, codigo, peso, urgencia);
                paquete.setContiene_alimentos(contieneAlimentos);
                
                // Agregamos el paquete a la lista dinámica
                paquetes.add(paquete);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de paquetes: " + e.getMessage());
        }
        return paquetes;
    }
}
   

