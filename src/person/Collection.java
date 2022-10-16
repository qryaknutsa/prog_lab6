package person;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class Collection
 */
public class Collection implements Serializable {
    private LinkedList<Person> people = new LinkedList<>();
    private static final LocalDate localDate = LocalDate.now();


    private static final LocalTime localTime = LocalTime.now();

    public LinkedList<Person> getCollection() {
        return people;
    }

    public void setCollection(LinkedList<Person> people) {
        this.people = people;
    }


    /**
     * GetSize
     *
     * @return size of the list
     */
    public int getSize() {
        return people.size();
    }

    /**
     * Get info about list
     *
     * @return String line
     */
    public String getInfo() {
        return "Коллекция: LinkedList\nДата инициализации: " + localDate + "\nВремя инициализации: " + localTime + "\b\b\b\b\nРазмер коллекции: " + this.getSize();
    }

    /**
     * Checking is id busy
     *
     * @return boolean
     */
    public boolean isIdBusy(int id) {
        for (Person person : people)
            if (person.getId() == id) return true;
        return false;
    }

    /**
     * Getting a free id for a new person
     *
     * @return free id
     */
    public int getFreeId() {
        HashMap<Integer, String> busyId = new HashMap<>();
        for (Person person : people) {
            busyId.put(person.getId(), "id");
        }
        int id = 1;
        while (true) {
            if (busyId.get(id) == null) {
                return id;
            } else id++;
        }
    }


    public Person getMinPerson() {
        if (people.size() == 0) {
            return null;
        }
        Person min = people.getFirst();
        for (Person person : people) {
            if (person.getHeight() < min.getHeight()) {
                min = person;
            }
        }
        return min;
    }

    /**
     * adding a person to list
     */
    public void add(Person p) {
        people.add(p);
    }

    public LinkedList<Person> copyList(){
        return (LinkedList<Person>) people.clone();
    }

}




