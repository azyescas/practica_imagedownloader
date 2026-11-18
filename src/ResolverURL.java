import java.net.URI;
import java.net.URL;

public class ResolverURL {
    public static void main(String[] args) throws Exception {
        URL base = URI.create("https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png").toURL();


        System.out.println(resolverImagen(base, "../imagenes/cat.png"));
        System.out.println(resolverImagen(base, "https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png"));
    }

    public static URL resolverImagen(URL urlPagina, String referencia) throws Exception {

        if (referencia == null || referencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La referencia de la imagen está vacía.");
        }


        URL urlResuelta = new URL(urlPagina, referencia);


        String protocolo = urlResuelta.getProtocol().toLowerCase();
        if (!protocolo.equals("http") && !protocolo.equals("https")) {
            throw new IllegalArgumentException("Esquema no admitido: " + protocolo);
        }

        return urlResuelta;
    }
}