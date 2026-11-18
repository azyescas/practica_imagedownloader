import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DescargarImagen {
    public static void main(String[] args) throws Exception {
        URL url = URI.create("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png").toURL();
        Path directorio = Path.of("imagenes");

        boolean exito = descargarImagen(url, directorio, 1);
        if (exito) {
            System.out.println("Proceso de descarga finalizado correctamente.");
        } else {
            System.out.println("No se pudo completar la descarga.");
        }
    }

    public static boolean descargarImagen(URL urlImagen, Path directorio, int numero) {
        try {
            Files.createDirectories(directorio);

            Path destino = directorio.resolve("imagen_" + numero + ".png");

            URLConnection connection = urlImagen.openConnection();
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);

            try (InputStream input = connection.getInputStream()) {
                Files.copy(input, destino, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Imagen descargada: " + destino);
                return true;
            }

        } catch (IOException e) {
            System.err.println("Error al descargar la imagen " + numero + ": " + e.getMessage());
            return false;
        }
    }
}