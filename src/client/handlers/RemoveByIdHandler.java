package client.handlers;

import client.client.Client;

import java.io.IOException;
import java.io.Serializable;

public class RemoveByIdHandler implements Handler, Serializable {
    Client client;

    public RemoveByIdHandler(Client client) {
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if (args == null) {
            return "Этой команде нужен аргумент (id).";
        }
        if(args.length>1){
            return "У этой команды не может быть так много аргументов.";
        }
        String id = args[0];
        return client.send("remove_by_id", id);
    }
}
