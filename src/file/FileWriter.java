package file;

import person.Person;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

/**
 * File writer
 */
public class FileWriter {
    static String filename;

    /**
     * Set filename
     */
    public static void setFilename(String filename) {
        FileWriter.filename = filename;
    }

    /**
     * Write data to file
     */
    public static void writeFile(LinkedList<Person> persons) throws FileNotFoundException {
        Gson gson = new Gson();
        try {
            File file = new File(filename);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(gson.toJson(persons));
            printWriter.close();
            System.out.println("Коллекция сохранена.");
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

}
