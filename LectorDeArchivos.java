import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LectorDeArchivos {
    public static void main(String[] args) {
        String ruta = "Camiones.csv";
        String linea;
        String separador = ";";

        try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
            while((linea = br.readLine()) != null){
                String[] campos = linea.split(separador);
                System.out.println(java.util.Arrays.toString(campos));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
   

