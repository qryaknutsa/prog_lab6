package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;

public class PrintAscendingHandler implements Handler, Serializable {

    Collection collection;

    public PrintAscendingHandler(Collection collection) {
        this.collection = collection;
    }
    static class PersonHeightComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {

            return a.getHeight().compareTo(b.getHeight());
        }
    }
    @Override
    public String handle(Object args) {
        PersonHeightComparator phc = new PersonHeightComparator();
        LinkedList<Person> copy = collection.copyList();
        copy.sort(phc);
        StringBuilder str = new StringBuilder();
        str.append("Сравнение по росту:\n");
        for (Person persons : copy) {
            str.append(persons.getInfo());
        }
        return str.toString();
    }
}
