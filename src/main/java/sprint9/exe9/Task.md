Напишите HTTP-клиент, который будет работать с API с адресом functions.yandexcloud.net 
и получать от него курсы валют.
Клиент должен отправлять GET-запрос 
по адресу https://functions.yandexcloud.net/d4ed1i6t3f80hf0p7mer. 
Необходимо добавить два параметра:
base — параметр, указывающий базовую валюту для конвертации;
symbols — параметр, в котором через запятую перечислены все необходимые валюты для конвертации.
Параметр base должен быть равен RUB, а параметр symbols — USD,EUR. 
Ответ от сервера нужен в формате JSON.