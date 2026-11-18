import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

public class BuscarImagenes {
    public static void main(String[] args) {
        String html = """
                <html><body>
                    <img src="cat.png">
                    <img src="/descargas/cat.png">
                    <img src="https://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png">
                </body></html>
                """;

        Set<String> resultado = extraerImagenes(html);

        for (String urlImg : resultado) {
            System.out.println(urlImg);
        }
    }

    public static Set<String> extraerImagenes(String html) {
        Set<String> imagenes = new HashSet<>();

        Pattern imgPattern = Pattern.compile(
                "<img\\b[^>]*>", Pattern.CASE_INSENSITIVE);
        Pattern srcPattern = Pattern.compile(
                "\\bsrc\\s*=\\s*([\"'])(.*?)\\1", Pattern.CASE_INSENSITIVE);

        Matcher imgMatcher = imgPattern.matcher(html);
        while (imgMatcher.find()) {
            String etiqueta = imgMatcher.group();
            Matcher srcMatcher = srcPattern.matcher(etiqueta);
            if (srcMatcher.find()) {
                imagenes.add(srcMatcher.group(2));
            }
        }

        return imagenes;
    }
}