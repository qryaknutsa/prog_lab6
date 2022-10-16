package file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * File ClientReceiver
 */
public class FileReader {

    private static final String envPath = System.getenv("DATA_JSON");

    /**
     * Get an environment variable
     */
    public static String getFilePath(){return envPath;}

    /**
     * Read from file
     */
    public static String readFile(String filename) throws IOException {
        try {
            StringBuilder data = new StringBuilder();
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                data.append((char) i);
            }
            file.FileWriter.setFilename(filename);
            return data.toString();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Вы не ввели имя файла.");
            return null;
        }
    }
}
