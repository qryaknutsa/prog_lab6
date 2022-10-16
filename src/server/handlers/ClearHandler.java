package server.handlers;


import person.Collection;

import java.io.Serializable;

public class ClearHandler implements Handler, Serializable {

    Collection collection;

    public ClearHandler(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String handle(Object args) {
        collection.getCollection().clear();
        return "Коллекция успешно очищена.";
    }
}
