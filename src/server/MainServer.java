package server;

import commands.*;
import protocol.Message;
import server.handlers.*;
import file.FileReader;
import file.Parser;
import person.Collection;
import server.handlers.PrintFieldAscendingBirthdayHandler;
import server.server.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainServer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server(43728);

        String filename = "collection.json";
        String env = System.getenv("COLLECTION");
        if(env != null && env.length()>0){
            filename = env;
        }
        Collection collection = Parser.fillCollection(FileReader.readFile(filename));

        Map<String, Handler> handlers = new HashMap<>();

        handlers.put("add", new AddHandler(collection));
        handlers.put("add_if_min", new AddIfMinHandler(collection));
        handlers.put("clear", new ClearHandler(collection));
        handlers.put("execute_script", new ExecuteScriptHandler(collection, CommandsEnum.values()));
        handlers.put("exit", new ExitHandler(collection));
        handlers.put("filter_starts_with_name", new FilterStartsWithNameHandler(collection));
        handlers.put("help", new HelpHandler(CommandsEnum.values()));
        handlers.put("history", new HistoryHandler(CommandsEnum.values()));
        handlers.put("info", new InfoHandler(collection));
        handlers.put("insert_at_index", new InsertAtIndexHandler(collection));
        handlers.put("print_ascending", new PrintAscendingHandler(collection));
        handlers.put("print_field_ascending_birthday", new PrintFieldAscendingBirthdayHandler(collection));
        handlers.put("remove_by_id", new RemoveByIdHandler(collection));
        handlers.put("show", new ShowHandler(collection));
        handlers.put("update_id", new UpdateIdHandler(collection));
        handlers.put("is_exist", new IsExistHandler(collection));

        //TODO: history

        while (true) {
            Message message = server.read();
            System.out.println("__________________________\nПолучено сообщение от клиента.");
            System.out.println("Была вызвана команда " + message.command + ".");
            String response = handlers.get(message.command).handle(message.args);
            System.out.println("Отправляем ответ клиенту.\n__________________________");
            server.send(response);
        }
    }
}
