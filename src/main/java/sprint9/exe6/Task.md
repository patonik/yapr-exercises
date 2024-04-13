Мы подготовили задание для заядлых киноманов! 
Вам нужно реализовать программу, которая будет читать и записывать в JSON субтитры к фильмам, 
сериалам и роликам.
Субтитры представляют собой список записей с текстом на разных языках и временны́ми метками. 
Эти метки указывают на начало и окончание отображения фразы на экране.

Чтобы субтитры было удобно читать и редактировать человеку, учтите следующее:
- время начала и окончания можно будет задавать в JSON в привычном формате — 
чч:мм:сс.мсек (часы:минуты:секунды.миллисекунды);
- язык фразы можно будет задавать двумя буквами (например, ru, en, cn и так далее);
- JSON будет записан в удобном для чтения формате с отступами и переносами строк.

Мы сделали заготовку короткого диалога в виде переменной-списка в Java. Вам нужно:
- Восстановить структуру класса.
- Подготовить адаптеры и конвертер Gson.
- Реализовать простую проверку получившегося конвертера с помощью equals/hashCode.