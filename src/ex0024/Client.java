package ex0024;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws URISyntaxException {
        double LAT = Double.parseDouble(args[0]);
        double LONG = Double.parseDouble(args[0]);
        String KEY = "YOUR-API-KEY";
        String URI = "https://api.openweathermap.org/data/2.5/weather?lat=" + LAT + "&lon=" + LONG + "&appid=" + KEY;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(URI))
                .GET()
                .build();

        ExecutorService executor = Executors.newCachedThreadPool();
        HttpClient client = HttpClient.newBuilder().executor(executor).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(response2 -> {
            System.out.println("response");
            System.out.println(""+response2);
            System.out.println(""+response2.body());
        });
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }
}
