import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase demuestra varias operaciones básicas de archivos en Java:
 * - Escribir texto en un archivo.
 * - Leer líneas y caracteres de un archivo.
 * - Modificar el contenido del archivo en memoria.
 * - Sobreescribir el archivo original con el contenido modificado.
 */
public class App {

    /**
     * Método principal que ejecuta las operaciones de archivo.
     *
     * @param args Argumentos de línea de comandos (no utilizados en este caso)
     * @throws Exception Si ocurre un error al interactuar con el archivo
     */
    public static void main(String[] args) throws Exception {
        // Crear un nuevo objeto de archivo
        File archivo = new File("Archivo.txt");

        // Escribir contenido inicial en el archivo (demostración de escritura de cadenas)
        try (FileWriter escritor = new FileWriter(archivo)) {
            String numero1 = "1";
            String numero2 = "2";
            for (int i = 0; i < 3; i++) {
                escritor.write(numero1);
            }
            for (int i = 0; i < 6; i++) {
                escritor.write(numero2);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Leer líneas del archivo e imprimirlas (demostración de lectura de líneas)
        try (FileReader lector = new FileReader(archivo);
             BufferedReader bufferLector = new BufferedReader(lector)) {
            String linea;
            while ((linea = bufferLector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer del archivo: " + e.getMessage());
        }

        // Leer caracteres del archivo y almacenarlos en una lista (demostración de lectura de caracteres)
        List<Character> caracteres = new ArrayList<>();
        try (FileReader lector = new FileReader(archivo)) {
            int caracter;
            while ((caracter = lector.read()) != -1) {
                caracteres.add((char) caracter);
            }
        } catch (IOException e) {
            System.out.println("Error al leer del archivo: " + e.getMessage());
        }

        // Modificar la lista (reemplazar caracteres '2' por '3')
        for (int i = 0; i < caracteres.size(); i++) {
            if (caracteres.get(i) == '2') {
                caracteres.set(i, '3');
            }
        }

        // Sobreescribir el archivo original con el contenido modificado (demostración de escritura de caracteres)
        try (FileWriter escritor = new FileWriter(archivo)) {
            for (char caracter : caracteres) {
                escritor.write(caracter);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Leer el archivo modificado e imprimirlo (demostración de lectura de líneas nuevamente)
        try (FileReader lector = new FileReader(archivo);
             BufferedReader bufferLector = new BufferedReader(lector)) {
            String linea;
            while ((linea = bufferLector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer del archivo: " + e.getMessage());
        }
    }
}
