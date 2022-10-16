package client.handlers;


import client.client.Client;
import person.Person;

import java.io.IOException;
import java.io.Serializable;

public class AddIfMinHandler implements Handler, Serializable {

    Client client;

    public AddIfMinHandler(Client client) {
        this.client = client;
    }

    @Override
    public String handle(String[] args) throws IOException, ClassNotFoundException {
        if(args != null){
            return "У этой команды не должно быть аргументов.";
        }
        Person person = new Person("any");
        return client.send("add_if_min", person);
    }
}
