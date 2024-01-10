# FileConverter
'FileConverter'- программа для конвертации файлов из формата XML в JSON и обратно. Разработан в рамках задания №2 практической работы.
## Использование
1. Работа через консоль
- Исходный путь файла, который необходимо конвертировать.
- Путь сохранения файла, содержащего результаты преобразования.
2. Интерактивый режим
## Начало работы
Для запуска программы, используйте вашу IDE или командную строку. В качестве аргументов командной строки укажите путь к исходному файлу и путь для сохранения результата преобразования.
## Структура проекта
- `src/main`: основная папка проекта
  - `java/ru/vyatsu`: папка в которой находится основной код проекта
    - `converters`: классы преобразования xml и json файлов
    - `structure`: классы для хранения структыры файлов
  - `resources`: примеры xml и json файлов
## Пример использования
- Для запуска конвертации data.xml в newPlayers.json, необходимо выполнить запрос следующей команды:
```
java -jar FileConverter.jar src\main\resources\players.xml src\main\resources\newPlayers.json
```
- Для запуска конвертации data.json в newPlayers.xml, необходимо выполнить запрос следующей команды:
```
java -jar FileConverter.jar src\main\resources\players.json src\main\resources\newPlayers.xml
```
