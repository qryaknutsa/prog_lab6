package client;

import client.client.Client;
import client.handlers.*;
import client.reader.Reader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client("localhost", 43728);

        Map<String, Handler> handlers = new HashMap<>();

        handlers.put("add", new AddHandler(client));
        handlers.put("add_if_min", new AddIfMinHandler(client));
        handlers.put("clear", new ClearHandler(client));
        handlers.put("execute_script", new ExecuteScriptHandler(client));
        handlers.put("exit", new ExitHandler(client));
        handlers.put("filter_starts_with_name", new FilterStartsWithNameHandler(client));
        handlers.put("help", new HelpHandler(client));
        handlers.put("history", new HistoryHandler(client));
        handlers.put("info", new InfoHandler(client));
        handlers.put("insert_at_index", new InsertAtIndexHandler(client));
        handlers.put("print_ascending", new PrintAscendingHandler(client));
        handlers.put("print_field_ascending_birthday", new PrintFieldAscendingBirthdayHandler(client));
        handlers.put("remove_by_id", new RemoveByIdHandler(client));
        handlers.put("show", new ShowHandler(client));
        handlers.put("update_id", new UpdateIdHandler(client));

        Reader reader = new Reader();
        System.out.println("Чтобы ознакомиться со всеми командами, введите \"help\".");
        while (true) {
            String[] commandAndArgs = reader.read();
            if (!handlers.containsKey(commandAndArgs[0])) {
                System.out.println("Команда не найдена. Чтобы ознакомиться со всеми командами, введите \"help\".");
            }else{
                String response;
                //TODO: почему-то не добавляет имена команды
                if(commandAndArgs.length>1) {
                    String[] arg = Arrays.copyOfRange(commandAndArgs, 1, commandAndArgs.length);
                    response = handlers.get(commandAndArgs[0]).handle(arg);
                }else{

                    response = handlers.get(commandAndArgs[0]).handle(null);
                }
                HistoryHandler.history.add(commandAndArgs[0]);
                System.out.println(response);
            }

        }
    }
}
