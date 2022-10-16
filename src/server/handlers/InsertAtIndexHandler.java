package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;

public class InsertAtIndexHandler implements Handler, Serializable {
    Collection collection;

    public InsertAtIndexHandler(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String handle(Object args) {
        Person person = (Person) args;
        collection.add(person);
        return "Человек с id " + person.getId() + " успешно добавлен.";

    }
}
