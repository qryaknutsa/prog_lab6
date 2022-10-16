package server.handlers;

import file.FileWriter;
import person.Collection;

import java.io.FileNotFoundException;
import java.io.Serializable;

public class ExitHandler implements Handler, Serializable {
    Collection collection;

    public ExitHandler(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String handle(Object args) {
        try {
            FileWriter.writeFile(collection.getCollection());
            return "Сохранение в файл... Выход из консоли";

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return "Файл не найден, сохранение не произошло. Выход из консоли...";
        }
    }
}

