package sprint9.exe12;

import java.net.http.HttpClient;
import java.util.HashMap;

public class WeatherApplication {
    private HashMap<String, String> weatherData;
    private WeatherClient weatherClient = new WeatherClient(HttpClient.newBuilder().build());

    public WeatherApplication() {
        initializedData();
    }

    // инициализация статических данных о погоде
    private void initializedData() {
        weatherData = new HashMap<>();
        weatherData.put("MOW", "Город: Москва. Облачно, +5°C");
        weatherData.put("LED", "Санкт-Петербург. Дождливо, +3°C");
        weatherData.put("KZN", "Город: Казань. Солнечно, +12°C");
    }

    // метод для отображения погоды
    public void displayWeather(String city) {
        // замените данные на динамические, полученные через weatherClient
        String weatherData = weatherClient.getWeatherData(city);
        System.out.println(weatherData);
    }
}