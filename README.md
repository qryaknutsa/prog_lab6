## <p style="text-align: center;"> 5 лаба </p>

Реализовать консольное приложение, которое реализует управление коллекцией
объектов в интерактивном режиме. В коллекции необходимо хранить объекты
класса <span style="color:#e83e8c; font-family: Consolas">Person</span>, описание которого приведено ниже.

**Разработанная программа должна удовлетворять следующим требованиям:**

* Класс, коллекцией экземпляров которого управляет программа, должен
реализовывать сортировку по умолчанию.
* Все требования к полям класса (указанные в виде комментариев) должны быть
выполнены.
* Для хранения необходимо использовать коллекцию типа <span style="color:#e83e8c; font-family: Consolas">java.util.LinkedList
* При запуске приложения коллекция должна автоматически заполняться
значениями из файла.
* Имя файла должно передаваться программе с помощью: **переменная окружения**.
* Данные должны храниться в файле в формате <span style="color:#e83e8c; font-family: Consolas">json
* Чтение данных из файла необходимо реализовать с помощью
класса <span style="color:#e83e8c; font-family: Consolas">java.io.BufferedInputStream
* Запись данных в файл необходимо реализовать с помощью
класса <span style="color:#e83e8c; font-family: Consolas">java.io.PrintWriter
* Все классы в программе должны быть задокументированы в формате javadoc.
* Программа должна корректно работать с неправильными данными (ошибки
пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).

**В интерактивном режиме программа должна поддерживать выполнение
следующих команд**:

* <span style="color:#e83e8c; font-family: Consolas">help</span> : вывести справку по доступным командам
* <span style="color:#e83e8c; font-family: Consolas">info</span> : вывести в стандартный поток вывода информацию о коллекции (тип, дата
инициализации, количество элементов и т.д.)
* <span style="color:#e83e8c; font-family: Consolas">show</span> : вывести в стандартный поток вывода все элементы коллекции в строковом
представлении
* <span style="color:#e83e8c; font-family: Consolas">add {element}</span> : добавить новый элемент в коллекцию
* <span style="color:#e83e8c; font-family: Consolas">update id {element}</span> : обновить значение элемента коллекции, id которого равен
заданному
* <span style="color:#e83e8c; font-family: Consolas">remove_by_id id</span> : удалить элемент из коллекции по его id
* <span style="color:#e83e8c; font-family: Consolas">clear</span> : очистить коллекцию
* <span style="color:#e83e8c; font-family: Consolas">save</span> : сохранить коллекцию в файл
* <span style="color:#e83e8c; font-family: Consolas">execute_script file_name</span> : считать и исполнить скрипт из указанного файла. В
скрипте содержатся команды в таком же виде, в котором их вводит пользователь в
интерактивном режиме.
* <span style="color:#e83e8c; font-family: Consolas">exit</span> : завершить программу (без сохранения в файл)
* <span style="color:#e83e8c; font-family: Consolas">insert_at index {element}</span> : добавить новый элемент в заданную позицию
* <span style="color:#e83e8c; font-family: Consolas">add_if_min {element}</span> : добавить новый элемент в коллекцию, если его значение
меньше, чем у наименьшего элемента этой коллекции
* <span style="color:#e83e8c; font-family: Consolas">history</span> : вывести последние 9 команд (без их аргументов)
* <span style="color:#e83e8c; font-family: Consolas">filter_starts_with_name name</span> : вывести элементы, значение поля name которых
начинается с заданной подстроки
* <span style="color:#e83e8c; font-family: Consolas">print_ascending</span> : вывести элементы коллекции в порядке возрастания
* <span style="color:#e83e8c; font-family: Consolas">print_field_ascending_birthday</span> : вывести значения поля birthday всех
элементов в порядке возрастания

**Формат ввода команд**:

* Все аргументы команды, являющиеся стандартными типами данных (примитивные
типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той
же строке, что и имя команды.
* Все составные типы данных (объекты классов, хранящиеся в коллекции) должны
вводиться по одному полю в строку.
* При вводе составных типов данных пользователю должно показываться
приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
* Если поле является enum'ом, то вводится имя одной из его констант (при этом
список констант должен быть предварительно выведен).
* При некорректном пользовательском вводе (введена строка, не являющаяся
именем константы в enum'е; введена строка вместо числа; введённое число не
входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и
предложено повторить ввод поля.
* Для ввода значений null использовать пустую строку.
* Поля с комментарием "Значение этого поля должно генерироваться
автоматически" не должны вводиться пользователем вручную при добавлении.

**Описание хранимых в коллекции классов**:

<code>

    public class Person {
        private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть  пустой
        private Coordinates coordinates; //Поле не может быть null
        private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private double height; //Значение поля должно быть больше 0
        private java.time.ZonedDateTime birthday; //Поле может быть null
        private Integer weight; //Поле может быть null, Значение поля должно быть больше 0
        private Country nationality; //Поле не может быть null
        private Location location; //Поле не может быть null
    }
    public class Coordinates {
        private int x;
        private Long y; //Значение поля должно быть больше -860, Поле не может быть null
    }
    public class Location {
        private long x;
        private double y;
        private Integer z; //Поле не может быть null
        private String name; //Поле может быть null
    }
    public enum Country {
        RUSSIA,
        FRANCE,
        NORTH_KOREA;
    }
</code>