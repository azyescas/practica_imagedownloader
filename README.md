# Práctica guiada: Descarga de imágenes de una página web mediante URL y URLConnection en Java
## Nombre: Azkahira Ziret Yescas Diaz
## Expediente: 222213158

## 1. Información general

| Elemento | Descripción |
|---|---|
| Asignatura | Desarrollo de Sistemas III |
| Unidad temática | Arquitectura cliente-servidor y programación de aplicaciones para Internet |
| Nombre de la práctica | Descargador de imágenes de páginas web |
| Duración estimada | 180 minutos |
| Modalidad | Individual |
| Entorno | IntelliJ IDEA; JDK 17 o superior; Git y GitHub |
| Restricción tecnológica | Exclusivamente clases de la API estándar de Java |
| API de comunicación | `java.net.URL`, `java.net.URLConnection` y `java.net.HttpURLConnection` |

**Restricción principal:** todas las conexiones a recursos de Internet deberán realizarse mediante `URL.openConnection()` y objetos `URLConnection` o su subclase `HttpURLConnection`. No se permite utilizar `HttpClient`, Jsoup, Apache HttpComponents ni bibliotecas externas. `URI` puede utilizarse para construir o validar direcciones y convertirlas a `URL`, pero no para establecer conexiones.

## 2. Propósito

Desarrollar una aplicación Java de línea de comandos que reciba como argumento la URL de una página web, establezca una conexión con el servidor, obtenga el documento HTML, identifique las imágenes referenciadas mediante etiquetas `<img>` y descargue cada imagen en un archivo local.

## 3. Resultados de aprendizaje

Al finalizar, el estudiante será capaz de:

1. Explicar el funcionamiento de la arquitectura cliente-servidor en aplicaciones web.
2. Utilizar `URL` para representar la localización de recursos en Internet.
3. Establecer conexiones mediante `URLConnection`.
4. Utilizar `HttpURLConnection` para consultar códigos de respuesta HTTP.
5. Leer contenido textual y binario mediante flujos de entrada.
6. Identificar referencias a imágenes dentro de un documento HTML.


Preguntas
1. ¿Qué responsabilidad desempeña la aplicación dentro de una arquitectura cliente-servidor?
El cliente solicita recursos o servicios y el servidor los procesa, administra y responde.
2. ¿Qué diferencias existen entre `URL`, `URLConnection` y `HttpURLConnection`?
URL identifica la dirección estática del recurso; URLConnection es una clase genérica para conexión 
a múltiples protocolos; e HttpURLConnection es una clase especializada y optimizada para HTTP/HTTPS
que maneja códigos de estado y métodos de petición.
3. ¿Qué sucede al invocar `openConnection()`?
Se crea y configura el objeto de conexión de red vinculado a la URL, preparando el enlace antes de
enviar los datos.
4. ¿Qué operaciones provocan que la conexión se establezca realmente?
Llamadas que interactúan con el servidor como getResponseCode(), connect() o getInputStream()
5. ¿Por qué una página HTML puede requerir múltiples conexiones?
Porque la página prinicipal contiene referencias a recursos externos adicionales (imágenes,
estilos CSS, scripts, fuentes) que deben descargarse por separados
6. ¿Cuál es la diferencia entre `getInputStream()` y `getContentType()`?
getContentType() devuelve el tipo de medio MIME del recurso (ej. text/html), mientras que getInputStream()
abre el flujo de datos para descargar el contenido
7. ¿Por qué distinguir recursos textuales y binarios?
Porque los textos requieren un juego de caracteres específico (como UTF-8), mientras que los binarios (como imágenes)
deben leerse y guardarse exactamente como bytes sin alterar su codificación.
8. ¿Para qué sirven los tiempos máximos de conexión y lectura?
Para evitar que el programa se quede bloqueado indefinidamente si el servidor está caída (setConnectTimeout) o se demora
enviando datos (setReadTimeout)
9. ¿Qué limitaciones tiene analizar HTML mediante expresiones regulares?
Es una aproximación didáctica frágil; no maneja correctamente atributos sin comillas, marcado complejo, etiquetas anidadas
o contenido generado por JavaScript
10. ¿Cómo podría implementarse la descarga concurrente usando únicamente la API estándar de Java?
Utilizando un ExecutorService (con un pool de hilos) o la clase Thread para procesar y descargar múltples URLs en paralelo
de forma independiente.



