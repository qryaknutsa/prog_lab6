package commands;

public enum CommandsEnum {
    ADD("add", "add {element} : добавить новый элемент в коллекцию"),
    ADD_IF_MIN("add_if_min","add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции"),
    CLEAR("clear","clear : очистить коллекцию"),
    EXECUTE_SCRIPT("execute_script","execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit","exit : завершить программу, сохраняя её в файл"),
    FILTER_STARTS_WITH_NAME("filter_starts_with_name","filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки"),
    HELP("help","help : вывести справку по доступным командам"),
    HISTORY("history","history : вывести последние 9 команд (без их аргументов)"),
    INFO("info","info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"),
    INSERT_AT_INDEX("insert_at_index","insert_at_index {element} : добавить новый элемент в заданную позицию"),
    IS_EXIST("is_exist","null"),
    PRINT_ASCENDING("print_ascending","print_ascending : вывести элементы коллекции в порядке возрастания"),
    PRINT_FIELD_ASCENDING_BIRTHDAY("print_field_ascending_birthday","print_field_ascending_birthday : вывести значения поля birthday всех элементов в порядке возрастания"),
    REMOVE_BY_ID("remove_by_id","remove_by_id: удалить элемент из коллекции по его id"),
    SAVE("save","save : сохранить коллекцию в файл"),
    SHOW("show","show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    UPDATE_ID("update_id","update_id {element} : обновить значение элемента коллекции, id которого равен заданному");


    public String name;
    public String description;

    CommandsEnum(String name, String description) {
        this.description = description;
        this.name = name;
    }

}
