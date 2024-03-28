package sprint8.exe5;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Warehouse {
    private List<Candy> candies;

    public Warehouse() {
        this.candies = List.of(
                new Candy("Мишка в лесу", 32, 2, Set.of("Мишка косолапый")),
                new Candy("Трюфель", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный")));
    }

    // Ищет конфеты на складе по их названию
    // Возвращает пустой Optional, если конфеты отсутствуют
    // или в обратном случае Optional, содержащий соответствующие конфеты
    public Optional<Candy> search(String name) {
        return candies.stream().filter(x-> Objects.equals(x.name, name) || x.alternativeNames.contains(name)).findFirst();
    }
}
