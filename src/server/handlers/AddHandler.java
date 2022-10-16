package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;

public class AddHandler implements Handler, Serializable {

    Collection collection;

    public AddHandler(Collection collection){
        this.collection = collection;
    }

    @Override
    public String handle(Object args) {
        Person person = (Person) args;
        person.setId(collection.getFreeId());
        collection.add(person);
        return "Человек успешно добавлен в коллекцию";
    }
}
