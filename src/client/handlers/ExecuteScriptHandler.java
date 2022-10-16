package client.handlers;


import client.client.Client;

import java.io.IOException;
import java.io.Serializable;

public class ExecuteScriptHandler implements Handler, Serializable {

    Client client;

    public ExecuteScriptHandler(Client client) {
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if (args == null) {
            return "Это команде нужен аргумент (имя файла).";
        }
        if(args.length>1){
            return "У этой команды не может быть так много аргументов.";
        }
        String filename = args[0];
        return client.send("execute_script", filename);
    }
}
