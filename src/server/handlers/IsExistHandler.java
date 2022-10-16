package server.handlers;

import person.Collection;
import person.Person;

import java.io.Serializable;

public class IsExistHandler implements Handler, Serializable {
    Collection collection;

    public IsExistHandler(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String handle(Object object) {
        String id = (String) object;
        for(Person person : collection.getCollection()){
            if(person.getId() == Integer.parseInt(id)){
                return "true";
            }
        }
        return "false";
    }
}


