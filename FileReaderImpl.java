import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileReaderImpl implements FileReader {

    @Override
    public String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            // Manejo de la excepción, por ejemplo, podrías devolver null o lanzar una excepción personalizada
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }
}
