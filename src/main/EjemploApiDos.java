package main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjemploApiDos {
  public static void main(String[] args) {

    // Desde java 11 existe httpClient
    
    try {
      // Creamos el cliente
      HttpClient cliente = HttpClient.newHttpClient();

      // Creamos la solicitud
      HttpRequest solicitud = HttpRequest.newBuilder()
      .uri(new URI("http://localhost:3000/music_albums"))
      // Get para obtener los datos
      .GET()
      .build();

      // Enviamos la solicitud y obtenemos la respuesta
      HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

      // Imprimimos la respuesta
      // La respuesta será un json, es recomendable formatear la respuesta en consola con jq
      // https://supersimplearn.medium.com/using-jq-for-json-parsing-and-manipulation-8a4bd8923f47
      System.out.println(respuesta.body());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
