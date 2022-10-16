package client.handlers;


import client.client.Client;

import java.io.IOException;
import java.io.Serializable;

public class HelpHandler implements Handler, Serializable {

    Client client;

    public HelpHandler(Client client){
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if(args != null){
            return "У этой команды не должно быть аргументов.";
        }
        return client.send("help", null);
    }
}
