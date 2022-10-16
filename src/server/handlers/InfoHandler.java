package server.handlers;

import person.Collection;

import java.io.Serializable;

public class InfoHandler implements Handler, Serializable {

    Collection collection;

    public InfoHandler(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String handle(Object args) {
        String str = "";
        str += "__________________________\n";
        str += collection.getInfo();
        str += "\n__________________________";
        return str;
    }
}
