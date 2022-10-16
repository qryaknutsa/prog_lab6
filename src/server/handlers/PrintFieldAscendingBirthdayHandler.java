package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;

public class PrintFieldAscendingBirthdayHandler implements Handler, Serializable {

    Collection collection;

    public PrintFieldAscendingBirthdayHandler(Collection collection) {
        this.collection = collection;
    }

    static class PersonBirthdayComparator implements Comparator<Person> {

        public int compare(Person a, Person b) {
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }

    @Override
    public String handle(Object args) {
        LinkedList<Person> copy = collection.copyList();
        PersonBirthdayComparator pbc = new PersonBirthdayComparator();
        copy.sort(pbc);
        StringBuilder str = new StringBuilder();
        for (Person persons : copy) {
            str.append(persons.getId()).append(" : ").append(persons.getBirthday().getDayOfMonth()).append(".").append(persons.getBirthday().getMonthValue()).append(".").append(persons.getBirthday().getYear()).append("\n");
        }
        return str.toString();    }
}
