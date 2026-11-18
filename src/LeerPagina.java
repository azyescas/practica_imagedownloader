import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class LeerPagina {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Uso: java LeerPagina https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
            return;
        }

        HttpURLConnection connection = null;
        try {

            URL url = URI.create(args[0]).toURL();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);


            int codigo = connection.getResponseCode();
            System.out.println("Código HTTP: " + codigo);
            System.out.println("Tipo de contenido: " + connection.getContentType());


            StringBuilder htmlContent = new StringBuilder();
            try (InputStream input = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))) {

                String linea;
                while ((linea = reader.readLine()) != null) {
                    htmlContent.append(linea).append("\n");
                }
            }

            String htmlFinal = htmlContent.toString();


            System.out.println("\n--- Primeros 500 caracteres del HTML ---");
            if (htmlFinal.length() <= 500) {
                System.out.println(htmlFinal);
            } else {
                System.out.println(htmlFinal.substring(0, 500) + "...");
            }

        } catch (IllegalArgumentException | java.net.MalformedURLException e) {
            System.err.println("URL inválida: " + e.getMessage());
        } catch (java.io.IOException e) {
            System.err.println("Error de red o el servidor no responde: " + e.getMessage());
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}