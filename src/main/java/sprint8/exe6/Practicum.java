package sprint8.exe6;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Practicum {

    // запросите у пользователя его координаты (долгота и широта) и затем
    // выведите расписание рассветов и закатов на сегодня
    // и ближайшую неделю в формате РАССВЕТ - ЗАКАТ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите широту:");
        double userLatitude = scanner.nextDouble();

        System.out.println("Введите долготу: ");
        double userLongtitude = scanner.nextDouble();

        System.out.println("Введите вашу временную зону: ");
        int userTimezone = scanner.nextInt();

        System.out.println("Введите текущий год в формате unix (10 цифр): ");
        long startOfYear = scanner.nextLong();

        // нам нужно знать, когда начался этот год
        Instant startOfYearMoment = Instant.ofEpochSecond(startOfYear);

        // и текущую дату
        Instant thisMoment = Instant.now();

        // и конечную дату нашего графика рассветов и закатов (плюс семь дней)
        Instant lastMoment = thisMoment.plus(7, ChronoUnit.DAYS);

        System.out.println("Рассвет - Закат, график на неделю:");
        do {
            int day = dayOfYearFromInstant(startOfYearMoment, thisMoment);

            // эти вычисления нужны для расчёта времени рассвета и заката,
            // но вы можете изучить их позже, когда освоите класс Instant
            int noonMinutes = localNoonMinutes(day, userTimezone, userLongtitude);
            double hourDelta = sunsetTimeHours(day, userLatitude);
            double noonHour = 12 + (noonMinutes / 60.0);
            double sunriseHour = noonHour - hourDelta;
            double sunsetHour = noonHour + hourDelta;

            System.out.printf("%s - %s\n", hhmmFromDouble(sunriseHour), hhmmFromDouble(sunsetHour));

            // эта конструкция позволит вам высчитать следующий день
            thisMoment = thisMoment.plus(1, ChronoUnit.DAYS);
        } while (thisMoment.isBefore(lastMoment)); // вам нужно вывести график на семь дней

    }

    // эта функция высчитывает текущий день года по заданному моменту начала года и по заданному текущему времени
    // TODO повышенный уровень сложности: попробуйте учесть високосный год
    private static int dayOfYearFromInstant(Instant startOfYear, Instant time) {
        long yearMilli = startOfYear.toEpochMilli();
        long timeMilli = time.toEpochMilli();
        if (yearMilli <= 0) return (int) ((yearMilli + timeMilli) / 86400000);
        if (time.isAfter(startOfYear)) return (int) ((timeMilli - yearMilli) / 86400000);
        return (int) ((yearMilli - timeMilli) / 86400000);
    }

    // все формулы ниже вы можете просто использовать как есть

    // эта супер-сложная формула возвращает длительность половины
    // светового дня (от рассвета до полудня или от полудня до заката)
    static double sunsetTimeHours(int dayOfYear, double latitude) {
        double rad = (Math.PI / 180);
        double factor = -1 * Math.tan(rad * latitude) * Math.tan(23.44 * rad * Math.sin(rad * (360 / 365.0) * (dayOfYear + 284.0)));
        if (factor <= -1 || factor >= 1) {
            return 0.0;
        }
        return Math.abs(Math.acos(factor)) / (rad * 15);
    }

    // эта сложная формула является уравнением времени и возвращает поправку на несовершенство орбиты Земли
    static int equationOfTimeMinutes(int dayOfYear) {
        return (int) Math.round(-7.655 * Math.sin(2 * Math.PI * dayOfYear / 365) + 9.873 * Math.sin(4 * Math.PI * dayOfYear / 365 + 3.588));
    }

    // эта не очень сложная формула возвращает поправку на истинный полдень (время, когда Солнце в зените)
    static int localNoonMinutes(int dayOfYear, int timeZone, double longtitude) {
        return (int) Math.round(4.0 * (longtitude - (15 * (timeZone - 1)))) - equationOfTimeMinutes(dayOfYear);
    }

    // эта функция поможет превратить вещественное значение часа в привычный формат чч:мм
    static String hhmmFromDouble(double hour) {
        return String.format("%d:%02d", (int) Math.floor(hour), (int) Math.round(60 * (hour - Math.floor(hour))));
    }

}
