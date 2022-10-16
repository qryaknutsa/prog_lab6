package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;

public class FilterStartsWithNameHandler implements Handler, Serializable {

    Collection collection;

    public FilterStartsWithNameHandler(Collection collection) {
        this.collection = collection;
    }
    @Override
    public String handle(Object args) {
        StringBuilder string = new StringBuilder();
        String filter = (String) args;
        for (Person persons : collection.getCollection()) {
            if (persons.getName().startsWith((filter))) {
                string.append(persons.getInfo());
            }
        }
        if (string.length() == 0) {
            string = new StringBuilder("Людей с таким именем нет.");

        }
        return string.toString();
    }
}
