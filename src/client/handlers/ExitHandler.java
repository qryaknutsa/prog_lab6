package client.handlers;

import client.client.Client;

import java.io.IOException;
import java.io.Serializable;

public class ExitHandler implements Handler, Serializable {

    Client client;

    public ExitHandler(Client client){
        this.client = client;
    }
    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if(args != null){
            return "У этой команды не должно быть аргументов.";
        }
        String message = client.send("exit", null);
        System.out.println(message);
        System.exit(0);
        return "";
    }
}
