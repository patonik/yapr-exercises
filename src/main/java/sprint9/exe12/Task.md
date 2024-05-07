Доработайте приложение для получения данных о погоде. Вот что нужно сделать:
Создайте класс WeatherClient:
Добавьте скрытое неизменяемое поле client с типом HttpClient.
Реализуйте публичный конструктор по умолчанию для инициализации поля client.
Добавьте публичный метод getWeatherData — он будет принимать название города и возвращать для него данные о погоде в виде строки.
Воспользуйтесь нашим сервисом, чтобы получать данные о погоде (на самом деле они не актуальны и нужны исключительно для выполнения задания!). Отправьте GET-запрос на https://functions.yandexcloud.net/d4eo3a1nvqedpic89160. В строке параметров укажите: Цельсий в качестве шкалы температур (параметр scale должен быть равен C) и переданный код в качестве города (параметр city).
В ответ возвращается JSON следующего вида:
{
"cities": {
"MOW": {
"city": "Москва",
"conditions": "Облачно",
"temperature": "+5°C"
}
}
}

При работе с методом, который будет отправлять GET-запрос сервису погоды, учтите следующее:
метод должен возвращать строку вида “Город: Москва. Облачно, +5°”;
если HTTP-статус ответа не равен 200, необходимо вернуть строку "Что-то пошло не так. Сервер вернул код состояния: [код ответа]", где [код ответа] — это код возникнувшей ошибки;
если возникло любое другое исключение, нужно вернуть такую строку:

"Во время выполнения запроса возникла ошибка.
Проверьте, пожалуйста, параметры запроса и повторите попытку.".
Доработайте класс WeatherApplication:
добавьте поле для WeatherClient;
уберите фиксированные значения погоды — вместо них при каждом вызове метода displayWeather должен вызываться метод getWeatherData.
Вывод
