package client.handlers;


import client.client.Client;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class HistoryHandler implements Handler, Serializable {

    public static ArrayList<String> history = new ArrayList<>();
    Client client;
    public HistoryHandler(Client client){
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if(args != null){
            return "У этой команды не должно быть аргументов.";
        }
        return client.send("history", history);
    }
}
