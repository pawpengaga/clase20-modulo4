package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection; // Contiene todos los paquetes que permiten conectarse a redes
import java.net.URI; // Nos permiten crear la instancia que va a representar la dirección
import java.net.URL; // Nos permiten crear la instancia que va a representar la dirección

public class EjemploApi {
  // Esta es la forma tipica, es engorrosa
  public static void main(String[] args) {
    System.out.println("------------------------------------------------------------------\n");
    try {
      // Definimos la url
      // Estaré usando una api propia en Ruby on Rails.
      // Los endopoints van a diferir de lo que haga el profesor
      // VER: https://github.com/pawpengaga/FakeMusicApi.git

      // Definimos a URI
      URI uri = new URI("http://localhost:3000/music_albums");      
      
      // Convertir URI a URL
      URL url = uri.toURL();

      // URL: Uniform resource locator (Localizador uniforme de recursos (Solo el dominio: ej: localhost))
      // URI: Uniform resource indicator? (Es la url + la urn (El endopoint))

      // Establecemos la conexion
      // Hacemos un parsing a la URL, la pasamos de URL a HttpUrlConnection
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();

      // Configurar el metodo
      // Usamos GET para obtener datos
      conn.setRequestMethod("GET");

      // Configurar el metodo POST

      // Leemos la respuesta
      // Esto normalmente viene en bytes, se usa para convertirlo a texto legible
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

      String inputLine;
      StringBuffer contenido = new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
        contenido.append(inputLine);
      }
      System.out.println(contenido.toString());
      
      // Cerramos las conexiones
      in.close();
      conn.disconnect();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
