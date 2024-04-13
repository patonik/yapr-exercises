package sprint9.exe12;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherClient {
    private final HttpClient client;

    public WeatherClient(HttpClient client) {
        this.client = client;
    }

    public String getWeatherData(final String city) {
        String result = null;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://functions.yandexcloud.net/d4eo3a1nvqedpic89160?scale=C&city=" + city))
                .build();
        HttpResponse.BodyHandler<String> responseHandler = HttpResponse.BodyHandlers.ofString();
        String body = null;
        try {
            HttpResponse<String> response = client.send(request, responseHandler);
            int statusCode = response.statusCode();
            if (statusCode != 200) {
                return String.format("Что-то пошло не так. Сервер вернул код состояния: %s", statusCode);
            }
            body = response.body();
        } catch (IOException | InterruptedException e) {
            result = "Во время выполнения запроса возникла ошибка.\n" +
                    "  Проверьте, пожалуйста, параметры запроса и повторите попытку.";
        }
        if (body != null) {
            JsonElement jsonElement = JsonParser.parseString(body);
            JsonElement cities = jsonElement.getAsJsonObject().get("cities");
            JsonElement c = cities.getAsJsonObject().get(city);
            String cit = c.getAsJsonObject().get("city").getAsString();
            String conditions = c.getAsJsonObject().get("conditions").getAsString();
            String temperature = c.getAsJsonObject().get("temperature").getAsString();
            result = String.format("Город: %s. %s, %s", cit, conditions, temperature);
        }
        return result;
    }
}
