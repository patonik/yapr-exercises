package sprint8.exe5;

import java.util.Optional;

public class Practicum {
    public static void main(String[] args) {
        // Доработайте данный метод, чтобы на экран выводилось
        // сообщение в соответствии с заданием

        SearchService searchService = new SearchService();

        Optional<Candy> candy = searchService.search("Африка");
        if (candy.isPresent()){
            Candy c = candy.get();
            System.out.printf("Товар \"%s\" доступен в количестве %d кг по цене %f руб за кг",c.name, c.amount, c.price);
        }
        else System.out.println("Данный товар не найден");

    }
}
