Создайте аннотацию @ObjectInfo с элементами type, args и required:
- type — содержит аннотированный класс, либо класс аннотированного поля, либо класс возвращаемого значения (если аннотирован метод);
- args — содержит классы аргументов, аннотированного конструктора или метода;
- required — указывает, обязательны ли аргументы или нет.
Используйте эту аннотацию для аннотирования класса, его конструктора, полей и метода:
- Для аннотации `@ObjectInfo` укажите, что `type` по умолчанию равен `Object.class`, 
`args` по умолчанию равен пустому массиву и `required` по умолчанию равен `false`.
- Проаннотируйте класс `MyClass` и поле `myField` с использованием аннотации `@ObjectInfo`. Укажите только тип.
- Проаннотируйте конструктор с использованием аннотации `@ObjectInfo`. 
Конструктор должен содержать только один аргумент типа `int.class` и должен быть обязательным. Также укажите тип.
- Проаннотируйте метод `myMethod` с использованием аннотации `@ObjectInfo`. 
Укажите, что тип возвращаемого значения — void, аргументы содержат два элемента и они обязательные.