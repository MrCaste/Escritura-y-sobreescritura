import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
            File Archivo = new File("Archivo.txt");

        try (FileWriter fw = new FileWriter(Archivo)) {

            String numero1 = "1";
            String numero2 = "2";
            for (int iterator = 0; iterator < 3; iterator++) {
                fw.write(numero1);
            }
            for (int iterator = 0; iterator < 6; iterator++) {
                fw.write(numero2); 
            }

        } catch (IOException e) {
            System.out.println("Se ha producido un error: "+e.getMessage());
        }

        try(FileReader fr = new FileReader(Archivo);
            BufferedReader br = new BufferedReader(fr)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            
        } catch (IOException e) {
            System.out.println("Se ha producido un error: "+e.getMessage());
        }
         List<Character> caracteres = new ArrayList<>();
        try (FileReader fr = new FileReader(Archivo)) {
            int character;
            while ((character = fr.read()) != -1) {
                caracteres.add((char) character);
            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: "+e.getMessage());
        }

        // Modificar la lista (reemplazar '2' por '3')
        for (int i = 0; i < caracteres.size(); i++) {
            if (caracteres.get(i) == '2') {
                caracteres.set(i, '3');
            }
        }
        // Sobreescribir el archivo original
        try (FileWriter fw = new FileWriter(Archivo)) {
            for (char character : caracteres) {
                fw.write(character);
            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: "+e.getMessage());
        }
        // Mostrar el contenido del archivo modificado por pantalla
        try (FileReader fr = new FileReader(Archivo);
             BufferedReader br = new BufferedReader(fr)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea); 

            }
        } catch (IOException e){
            System.out.println("Se ha producido un error: "+e.getMessage());
        }
    }
}
