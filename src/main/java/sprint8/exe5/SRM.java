package sprint8.exe5;

import java.util.*;

//содержимое этого класса не нужно менять
public class SRM {
    private final Map<String, List<Candy>> suppliersProducts = new HashMap<>();

    public SRM() {
        suppliersProducts.put("Первая кондитерская фабрика", List.of(
                new Candy("Мишка на севере", 34.4, 100, Set.of("Мишка косолапый", "Мишка")),
                new Candy("Победа",56, 35, Set.of("Победа вкуса")),
                new Candy("Два верблюда",20, 47, Set.of("Каракум", "Африка")),
                new Candy("Красная шапочка",35, 3, Set.of("КРАСНАЯ ШАПОЧКА"))
        ));

        suppliersProducts.put("Триумф", List.of(
                new Candy("Мишка в лесу", 34.2, 63, Set.of("Мишка косолапый")),
                new Candy("Трюфель",21, 25, Set.of("Трюфель классический", "Трюфель шоколадный"))
        ));

        suppliersProducts.put("Сладости Везде", List.of(
                new Candy("Шоколадный восторг",33.98, 257, Collections.emptySet()),
                new Candy("Африка",25, 114, Set.of("Каракум"))
        ));
        suppliersProducts.put("ООО Дом Шоколада", List.of(
                new Candy("ШокоБомб",20, 1, Set.of("Шоко_бомб")),
                new Candy("Трюфель классический",35, 94, Set.of("Трюфель шоколадный"))
        ));

    }

    // Возвращает название всех поставщиков
    public Set<String> listSuppliers() {
        // Создаём новую коллекцию на основе множества имеющихся поставщиков
        // Создание новой коллекции необходимо, чтобы клиентский код не смог
        // повлиять на содержимое, хранящееся в Map
        return new HashSet<>(suppliersProducts.keySet());
    }

    // Возвращает информацию о товаре на складе поставщика
    // Если поставщик или товар не найден, возвращает null
    public Candy getProduct(String supplierName, String candyName) {
        List<Candy> candies = suppliersProducts.get(supplierName);
        if(candies != null) {
            for (Candy candy : candies) {
                if(candy.name.equals(candyName)
                        || candy.alternativeNames.contains(candyName)) {
                    return candy;
                }
            }
        }
        return null;
    }
}
