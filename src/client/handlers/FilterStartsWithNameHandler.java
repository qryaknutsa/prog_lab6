package client.handlers;

import client.client.Client;

import java.io.IOException;
import java.io.Serializable;


public class FilterStartsWithNameHandler implements Handler, Serializable {

    Client client;

    public FilterStartsWithNameHandler(Client client){
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if(args == null){
            return "Этой команде нужен аргумент (фильтр)";
        }
        if(args.length>1){
            return "У этой команды не может быть так много аргументов.";
        }
        String filter = args[0];
        return client.send("filter_starts_with_name", filter);
    }
}
