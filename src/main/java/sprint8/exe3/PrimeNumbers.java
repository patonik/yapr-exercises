package sprint8.exe3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PrimeNumbers {

    public static void main(String[] args) {
        // Лямбда, возвращающая целое число в интервале от 1 до 100
        // Укажите правильный тип данных для переменной randomInt
        Supplier<Integer> randomInt = () -> ThreadLocalRandom.current().nextInt(0, 100);
        // Лямбда, проверяющая, является ли число простым
        // Укажите правильный тип данных для переменной isPrime
        Predicate<Integer> isPrime = number -> {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            return count == 2;
        };
        // Лямбда, принимающая два аргумента (целое число и строку) и выводящая сообщение
        // укажите правильные параметры типа для BiConsumer
        BiConsumer<Integer, String> outputConsumer =
                (num, str) -> System.out.println("Число " + num + " " + str);

        // Используем созданные лямбды
        for (int i = 0; i < 10; i++) {
            Integer number = randomInt.get();// получаем случайное целое число

            if (isPrime.test(number)) {
                // используйте нужный функциональный метод
                outputConsumer.accept(number, "является простым.");
            } else {
                // используйте нужный функциональный метод
                outputConsumer.accept(number, "не является простым.");
            }
        }
    }
}
