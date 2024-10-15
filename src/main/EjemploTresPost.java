package main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EjemploTresPost {
  public static void main(String[] args) {
    try {
      HttpClient cliente = HttpClient.newHttpClient();

      // Definir el cuerpo de la solicitud en formato json
      String json = "{\"name\": \"Confessions on a Dance Floor\", \"band\": \"Madonna\", \"genre\": \"Dance/Pop\", \"year\": 2005 }";

      // Creamos la solicitud
      HttpRequest request = HttpRequest.newBuilder()
      .uri(new URI("http://localhost:3000/music_albums"))
      // .uri(new URI("https://msk2sqqg-3000.brs.devtunnels.ms/music_albums"))
      .POST(HttpRequest.BodyPublishers.ofString(json))
      .headers("Content-Type", "application/json")
      .build();

      //Enviamos la solicitud y obtenemos la respuesta
      HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

      // Imprimimos la respuesta
      System.out.println(response.body());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
