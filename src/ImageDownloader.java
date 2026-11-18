import java.net.URI;
import java.net.URL;

public class ImageDownloader {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java ImageDownloader https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
            return;
        }
        try {
            URI uri = URI.create(args[0]);
            URL url = uri.toURL();
            System.out.println("Protocolo: " + url.getProtocol());
            System.out.println("Servidor: " + url.getHost());
            System.out.println("Puerto: " + url.getPort());
            System.out.println("Ruta: " + url.getPath());
        } catch (IllegalArgumentException e) {
            System.err.println("URL inválida: " + e.getMessage());
        } catch (java.net.MalformedURLException e) {
            System.err.println("URL no admitida: " + e.getMessage());
        }
    }
}