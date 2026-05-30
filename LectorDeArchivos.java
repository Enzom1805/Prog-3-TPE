import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LectorDeArchivos {
        // Método para cargar los camiones desde el archivo CSV
    public static Camion[] cargarCamiones(String ruta) {
        Camion[] camiones = null;
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // 1. Leer la primera línea para saber la cantidad total de camiones
            String primeraLinea = br.readLine();
            if (primeraLinea != null) {
                int cantidad = Integer.parseInt(primeraLinea.trim());
                camiones = new Camion[cantidad]; // Inicializamos el arreglo con el tamaño exacto

                String linea;
                int indice = 0;
                
                // 2. Leer el resto de las líneas
                while ((linea = br.readLine()) != null && indice < cantidad) {
                    String[] campos = linea.split(separador);
                    
                    // Extraer y convertir los datos
                    String id = campos[0];
                    String patente = campos[1];
                    boolean estaRefrigerado = campos[2].equals("1"); // "1" es true, "0" es false
                    int capacidad = Integer.parseInt(campos[3]);

                    // Crear el objeto Camion
                    Camion camion = new Camion(id, patente, capacidad);
                    camion.setEsta_refrigerado(estaRefrigerado);
                    
                    // Guardarlo en el arreglo
                    camiones[indice] = camion;
                    indice++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de camiones: " + e.getMessage());
        }
        return camiones;
    }

    // Método para cargar los paquetes desde el archivo CSV
    public static Paquete[] cargarPaquetes(String ruta) {
        Paquete[] paquetes = null;
        String separador = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // 1. Leer la primera línea para saber la cantidad total de paquetes
            String primeraLinea = br.readLine();
            if (primeraLinea != null) {
                int cantidad = Integer.parseInt(primeraLinea.trim());
                paquetes = new Paquete[cantidad]; // Inicializamos el arreglo

                String linea;
                int indice = 0;
                
                // 2. Leer el resto de las líneas
                while ((linea = br.readLine()) != null && indice < cantidad) {
                    String[] campos = linea.split(separador);
                    
                    // Extraer y convertir los datos
                    String id = campos[0];
                    String codigo = campos[1];
                    double peso = Double.parseDouble(campos[2]);
                    boolean contieneAlimentos = campos[3].equals("1"); // "1" es true, "0" es false
                    int urgencia = Integer.parseInt(campos[4]);

                    // Crear el objeto Paquete
                    Paquete paquete = new Paquete(id, codigo, peso, urgencia);
                    paquete.setContiene_alimentos(contieneAlimentos);
                    
                    // Guardarlo en el arreglo
                    paquetes[indice] = paquete;
                    indice++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de paquetes: " + e.getMessage());
        }
        return paquetes;
    }
}
   

