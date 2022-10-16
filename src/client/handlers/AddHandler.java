package client.handlers;


import client.client.Client;
import person.Person;
import server.MainServer;

import java.io.IOException;
import java.io.Serializable;

public class AddHandler implements Handler, Serializable {

    Client client;

    public AddHandler(Client client) {
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if(args != null){
            return "У этой команды не должно быть аргументов.";
        }
        Person person = new Person("any");
        return client.send("add", person);
    }
}
