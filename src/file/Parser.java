package file;

import person.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedList;

/**
 * Parser
 */
public class Parser {
    /**
     * Fill a collection from file
     */
    public static Collection fillCollection(String data) {
        Collection collection = new Collection();
        LinkedList<Person> people = new LinkedList<>();
        Gson gson = new Gson();
        if (data == null) System.out.println("Файл не был найден. Коллекция не была заполнена.");
        else {
            try {
                Type type = new TypeToken<LinkedList>() {
                }.getType();
                LinkedList<LinkedTreeMap> treeMaps = gson.fromJson(data, type);
                if(treeMaps==null){
                    return collection;
                }
                for (LinkedTreeMap params : treeMaps) {
                    Person person = new Person();

                    person.setThisId(((Double) params.get("id")).intValue());

                    person.setThisName((String) params.get("name"));

                    LinkedTreeMap coordParams = (LinkedTreeMap) params.get("coordinates");
                    Coordinates coordinates = new Coordinates();
                    coordinates.setX(((Double) coordParams.get("x")).intValue());
                    coordinates.setY(((Double) coordParams.get("y")).longValue());
                    person.setThisCoordinates(coordinates);

                    LinkedTreeMap<String, Double> creationDate = (LinkedTreeMap) params.get("creationDate");
                    int cyear = creationDate.get("year").intValue();
                    int cmonth = creationDate.get("month").intValue();
                    int cday = creationDate.get("day").intValue();
                    person.setThisCreationDate(LocalDate.of(cyear, cmonth, cday));

                    person.setThisHeight(((Double) params.get("height")).floatValue());

                    LinkedTreeMap<String, LinkedTreeMap> birthday = (LinkedTreeMap) params.get("birthday");
                    LinkedTreeMap<String, LinkedTreeMap> dateTime = (LinkedTreeMap) birthday.get("dateTime");
                    LinkedTreeMap<String, Double> date = (LinkedTreeMap) dateTime.get("date");
                    int byear = date.get("year").intValue();
                    int bmonth = date.get("month").intValue();
                    int bday = date.get("day").intValue();
                    person.setThisBirthday(ZonedDateTime.of(byear, bmonth, bday, 0, 0, 0, 0, ZoneId.of("Europe/Moscow")));

                    person.setThisWeight(((Double) params.get("weight")).floatValue());

                    person.setThisCountry(Country.valueOf((String) params.get("country")));

                    LinkedTreeMap locParams = (LinkedTreeMap) params.get("location");
                    Location location = new Location();
                    location.setX(((Double) locParams.get("x")).longValue());
                    location.setY(((Double) locParams.get("y")).floatValue());
                    location.setZ((Double) locParams.get("z"));
                    location.setName((String) locParams.get("name"));
                    person.setThisLocation(location);

                    people.add(person);
                }
                collection.setCollection(people);
                System.out.println("Коллекция успешно заполнена.");
                return collection;
            } catch (JsonSyntaxException e) {
                System.out.println("Ошибка заполнения. Коллекция не была заполнена.");
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("В файле указаны некорректные данные. Коллекция не была заполнена.");
            }
        }
        return null;
    }
}