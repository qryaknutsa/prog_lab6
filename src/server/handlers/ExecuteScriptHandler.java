package server.handlers;

import commands.CommandsEnum;
import person.Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

public class ExecuteScriptHandler implements Handler, Serializable {

    Collection collection;
    CommandsEnum[] commands;

    public ExecuteScriptHandler(Collection collection,CommandsEnum[] commands) {
        this.collection = collection;
        this.commands = commands;
    }

    @Override
    public String handle(Object args) {
        try {
            String filename = (String) args;
            StringBuilder result = new StringBuilder();
            File file = new File(filename);
            Scanner in = new Scanner(file);

            Map<String, Handler> handlers = new HashMap<>();

            handlers.put("add", new AddHandler(collection));
            handlers.put("add_if_min", new AddIfMinHandler(collection));
            handlers.put("clear", new ClearHandler(collection));
            handlers.put("exit", new ExitHandler(collection));
            handlers.put("filter_starts_with_name", new FilterStartsWithNameHandler(collection));
            handlers.put("help", new HelpHandler(commands));
            handlers.put("history", new HistoryHandler(commands));
            handlers.put("info", new InfoHandler(collection));
            handlers.put("insert_at_index", new InsertAtIndexHandler(collection));
            handlers.put("print_ascending", new PrintAscendingHandler(collection));
            handlers.put("print_field_ascending_birthday", new PrintFieldAscendingBirthdayHandler(collection));
            handlers.put("remove_by_id", new RemoveByIdHandler(collection));
            handlers.put("show", new ShowHandler(collection));
            handlers.put("update_id", new UpdateIdHandler(collection));
            handlers.put("is_exist", new IsExistHandler(collection));

            while (in.hasNextLine()) {
                String[] arraysOfParams = in.nextLine().trim().split(" ");
                if (!handlers.containsKey(arraysOfParams[0])) {
                    result.append("Команда не найдена. Чтобы ознакомиться со всеми командами, введите \"help\".\n");
                } else {
                    if (arraysOfParams.length > 1) {
                        String[] arg = Arrays.copyOfRange(arraysOfParams, 1, arraysOfParams.length);
                        result.append("Команда \"").append(arraysOfParams[0]).append("\":\n");
                        result.append(handlers.get(arraysOfParams[0]).handle(arg[0]));
                    } else {
                        result.append("Команда \"").append(arraysOfParams[0]).append("\":\n");
                        result.append(handlers.get(arraysOfParams[0]).handle(null));
                    }
                    result.append("\n");
                }
                result.append("__________________________\n");
            }
            return result.toString();
        } catch (NullPointerException | FileNotFoundException e) {
            return "Указанный файл не найден.";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}