package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;

public class AddIfMinHandler implements Handler, Serializable {

    Collection collection;

    public AddIfMinHandler(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String handle(Object args) {
        Person person = (Person) args;
        Person min = collection.getMinPerson();
        if (min == null || person.getHeight() < min.getHeight()) {
            person.setId(collection.getFreeId());
            collection.add(person);
            return "Человек успешно добавлен";
        }
        return "Человек не добавлен, его рост не минимальный.";
    }
}
