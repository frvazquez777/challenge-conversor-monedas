package servicios;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMoneda {

    private String API = "https://v6.exchangerate-api.com/v6/1a945f05ac2f6be8f8a97989/latest/";

    public ApiResponse getResultado(String moneda) {
        System.out.println("Procesando...");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API+moneda))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ApiResponse respuesta = new ApiResponse();
            ApiResponse res = respuesta.fromJson(response.body());
            System.out.println(res);
        return res;
        } catch (NumberFormatException e){
            System.out.println("Ocurrió un error: ");
            System.out.println(e.getMessage());
            return null;
        }catch(IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la dirección.");
            return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (InterruptedException e) {
            System.out.println("Error en de petición.");
            return null;
        }

    }

}
