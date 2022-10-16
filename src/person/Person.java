package person;

import server.MainServer;
import sun.applet.Main;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Class Person
 */
public class Person implements Comparable<Person>, Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float height; //Поле может быть null, Значение поля должно быть больше 0
    private ZonedDateTime birthday; //Поле не может быть null
    private float weight; //Значение поля должно быть больше 0
    private Country country; //Поле не может быть null
    private Location location; //Поле не может быть null

    private static final Scanner in = new Scanner(System.in);
    static ZonedDateTime zonedBirthday;
    static boolean vis;


    //TODO: почему-то переспрашивает, говоря, что введены некорректные данные, а они нормальные
    public Person() {
    }


    public Person(String id) {
        if (Objects.equals(id, "any")) {
            setId(0);
        } else {
            setId(Integer.parseInt(id));
        }
        setName();
        Coordinates coordinates = new Coordinates();
        setCoordinatesX(coordinates);
        setCoordinatesY(coordinates);

        setCoordinates(coordinates);

        setCreationDate(LocalDate.now());

        setHeight();
        Birthday b = new Birthday();
        setBirthdayYear(b);
        setBirthdayMonth(b);
        setBirthdayDay(b);
        setBirthday(zonedBirthday);

        setWeight();
        setCountry();

        Location location = new Location();
        setLocationX(location);
        setLocationY(location);
        setLocationZ(location);
        setLocationName(location);
        setLocation(location);

    }


    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Float getHeight() {
        return height;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public float getWeight() {
        return weight;
    }

    public Country getCountry() {
        return country;
    }

    public Location getLocation() {
        return location;
    }

    public Integer getId() {
        return id;
    }


    public void setThisName(String name) {
        this.name = name;
    }

    public void setThisCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setThisCreationDate(LocalDate localDate) {
        this.creationDate = localDate;
    }

    public void setThisHeight(Float height) {
        this.height = height;
    }

    public void setThisBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public void setThisWeight(float weight) {
        this.weight = weight;
    }

    public void setThisCountry(Country country) {
        this.country = country;
    }

    public void setThisLocation(Location location) {
        this.location = location;
    }

    public void setThisId(Integer id) {
        this.id = id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName() {
        System.out.print("Введите имя человека: ");
        String name = in.nextLine();
        if (name.trim().length() == 0) {
            System.out.println("Вы не ввели имя человека. Попробуйте ещё раз.");
            this.setName();
        }
        this.name = name;
    }

    /**
     * set coordinate x for coordinate for person
     */
    public void setCoordinatesX(Coordinates cx) {
        System.out.print("Введите координату х: ");
        String x = in.nextLine();
        if (x.trim().length() == 0) {
            System.out.println("Вы не ввели значение х. Попробуйте ещё раз.");
            this.setCoordinatesX(cx);
        } else {
            try {
                int xx = Integer.parseInt(x);
                cx.setX(xx);
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение для x. Попробуйте ещё раз.");
                this.setCoordinatesX(cx);
            }
        }
    }

    /**
     * set coordinate y for coordinate for person
     */
    public void setCoordinatesY(Coordinates cy) {
        System.out.print("Введите координату y: ");
        String y = in.nextLine();
        if (y.trim().length() == 0) {
            System.out.println("Вы не ввели значение y. Попробуйте ещё раз.");
            this.setCoordinatesY(cy);
        } else {
            try {
                long yy = Long.parseLong(y);
                if (yy < -860) {
                    System.out.println("Вы ввели неправильное значение y. Координата y должна быть больше -860. Попробуйте ещё раз.");
                    this.setCoordinatesY(cy);
                } else {
                    cy.setY(yy);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение для y. Попробуйте ещё раз.");
                this.setCoordinatesY(cy);
            }
        }
    }

    /**
     * Set height to person
     */
    public void setHeight() {
        System.out.print("Введите значение роста в метрах: ");
        String h = in.nextLine();
        try {
            if (h.trim().length() == 0 | h.equals("")) {
                this.setHeight();
            } else {
                float hh = Float.parseFloat(h);
                if (hh <= 0) {
                    System.out.println("Вы ввели некорректное значение для роста, значение не может быть ниже нуля. Попробуйте ещё раз.");
                    this.setHeight();
                } else {
                    this.height = hh;
                }
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение для роста. Попробуйте ещё раз.");
            this.setHeight();
        }
    }


    /**
     * Set weight to person
     */
    public void setWeight() {
        System.out.print("Введите значение веса в килограммах: ");
        String w = in.nextLine();
        if (w.trim().length() == 0) {
            System.out.println("Вы не ввели значение веса. Попробуйте ещё раз.");
            this.setWeight();
        }
        try {
            float ww = Float.parseFloat(w);
            if (ww <= 0) {
                System.out.println("Вы ввели некорректное значение для веса, значение не может быть ниже нуля. Попробуйте ещё раз.");
                this.setWeight();
            } else {
                this.weight = ww;
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значение для веса. Попробуйте ещё раз.");
            this.setWeight();
        }
    }

    /**
     * Set country to person
     */
    public void setCountry() {
        System.out.print("Выберите национальность человека (RUSSIA, FRANCE, NORTH_KOREA), регистр не важен: ");
        String country = in.nextLine().toUpperCase();
        if (country.trim().length() == 0) {
            System.out.println("Вы не выбрали страну. Попробуйте ещё раз.");
            this.setCountry();
        } else {
            try {
                this.country = Country.valueOf(country);
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение для национальности человека. Попробуйте ещё раз.");
                this.setCountry();
            }
        }
    }

    /**
     * set coordinate x for location for person
     */
    public void setLocationX(Location locationX) {
        System.out.print("Введите координату х для обозначения локации: ");
        String x = in.nextLine();
        if (x.trim().length() == 0) {
            System.out.println("Вы не ввели координату х. Попробуйте ещё раз.");
            this.setLocationX(locationX);
        } else {
            try {
                long xx = Long.parseLong(x);
                locationX.setX(xx);
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение х. Попробуйте ещё раз.");
                this.setLocationX(locationX);
            }
        }
    }

    /**
     * set coordinate y for location for person
     */
    public void setLocationY(Location locationY) {
        System.out.print("Введите координату y для обозначения локации: ");
        String y = in.nextLine();
        if (y.trim().length() == 0) {
            System.out.println("Вы не ввели координату y. Попробуйте ещё раз.");
            this.setLocationY(locationY);
        } else {
            try {
                float yy = Float.parseFloat(y);
                if (Math.abs(yy) > Float.MAX_VALUE) {
                    System.out.println("Вы ввели слишком большое значение y. Попробуйте ещё раз.");
                    this.setLocationY(locationY);
                } else {
                    locationY.setY(yy);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение y. Попробуйте ещё раз.");
                this.setLocationY(locationY);
            }
        }
    }

    /**
     * set coordinate z for location for person
     */
    public void setLocationZ(Location locationZ) {
        System.out.print("Введите координату z для обозначения локации: ");
        String z = in.nextLine();
        if (z.trim().length() == 0) {
            System.out.println("Вы не ввели координату z. Попробуйте ещё раз.");
            this.setLocationZ(locationZ);
        } else {
            try {
                double zz = Double.parseDouble(z);
                if (Math.abs(zz) > Double.MAX_VALUE) {
                    System.out.println("Вы ввели слишком большое значение z. Попробуйте ещё раз.");
                    this.setLocationZ(locationZ);
                } else {
                    locationZ.setZ(zz);
                }
            } catch (Exception e) {
                System.out.println("Вы ввели некорректное значение z. Попробуйте ещё раз.");
                this.setLocationZ(locationZ);
            }
        }
    }

    /**
     * set name for location for person
     */
    public void setLocationName(Location locationName) {
        System.out.print("Введите имя локации: ");
        String name = in.nextLine();
        //if (name.trim().length() == 0 | name.equals("")) {
        if (name.trim().equals("")) {
            locationName.setName("null");
        } else {
            locationName.setName(name);
        }
    }

    /**
     * set year for birthday for person
     */
    public void setBirthdayYear(Birthday birthday) {
        System.out.print("Введите год рождения человека: ");
        String year = in.nextLine();
        if (year.trim().length() == 0) {
            System.out.println("Вы не ввели год рождения. Попробуйте ещё раз.");
            this.setBirthdayYear(birthday);
        }
        try {
            int yyear = Integer.parseInt(year);
            if (yyear < 0 | yyear > LocalDate.now().getYear()) {
                System.out.println("Вы ввели некорректное значение года. Попробуйте ещё раз.");
                this.setBirthdayYear(birthday);
            } else {
                vis = (yyear % 4 == 0 & yyear % 100 != 0) || yyear % 400 == 0;
                birthday.setByear(yyear);
            }
        } catch (Exception e) {
            System.out.println("Вы ввели некорректное значения года рождения. Попробуйте ещё раз.");
            this.setBirthdayYear(birthday);
        }
    }

    void incorrectMonth(Birthday birthday) {
        System.out.println("Вы не ввели месяц рождения. Попробуйте ещё раз.");
        this.setBirthdayMonth(birthday);
    }

    void correctMonth(Birthday birthday, int mmonth) {
        if (birthday.getByear() == LocalDate.now().getYear()) {
            if (mmonth > LocalDate.now().getMonthValue()) {
                System.out.println("Вы ввели некорректное значение месяца. Попробуйте ещё раз.");
                this.setBirthdayMonth(birthday);
            }
        }
        birthday.setBmonth(mmonth);
    }

    /**
     * set month for birthday for person
     */

    public void setBirthdayMonth(Birthday birthday) {
        System.out.print("Введите месяц рождения человека: ");
        String month = in.nextLine();
        if (month.trim().length() == 0) incorrectMonth(birthday);
        else {
            try {
                int mmonth = Integer.parseInt(month);
                if (mmonth <= 0 | mmonth >= 13) incorrectMonth(birthday);
                else correctMonth(birthday, mmonth);
            } catch (Exception e) {
                incorrectMonth(birthday);
            }
        }
    }

    /**
     * set day for birthday for person
     */

    void incorrectDate(Birthday birthday) {
        System.out.println("Вы ввели некорректное значение даты. Попробуйте ещё раз.");
        this.setBirthdayDay(birthday);
    }

    void coorectDate(Birthday birthday, int dday) {
        if (birthday.getByear() == LocalDate.now().getYear()) {
            if (birthday.getBmonth() == LocalDate.now().getMonthValue()) {
                if (dday > LocalDate.now().getDayOfMonth()) {
                    incorrectDate(birthday);
                }
            }
        }
        birthday.setBday(dday);
        zonedBirthday = ZonedDateTime.of(birthday.getByear(), birthday.getBmonth(), dday, 0, 0, 0, 0, ZoneId.of("Europe/Moscow"));
    }


    public void setBirthdayDay(Birthday birthday) {
        System.out.print("Введите число рождения человека: ");
        String day = in.nextLine();
        int month = birthday.getBmonth();
        //System.out.println("month was" + month);
        if (day.trim().length() == 0) {
            System.out.println("Вы не ввели месяц рождения. Попробуйте ещё раз.");
            this.setBirthdayDay(birthday);

        } else {
            try {
                int dday = Integer.parseInt(day);
                if (dday <= 0 | dday > 31) incorrectDate(birthday);
                if (month == 2) {
                    if (!vis) {
                        if (dday > 28) incorrectDate(birthday);
                        if (dday <= 28) coorectDate(birthday, dday);
                    } else {
                        if (dday > 29) incorrectDate(birthday);
                        if (dday <= 29) coorectDate(birthday, dday);
                    }

                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    if (dday > 30) incorrectDate(birthday);
                    if (dday <= 30) coorectDate(birthday, dday);
                } else {
                    //System.out.println(month);
                    if (dday > 31) incorrectDate(birthday);
                    if (dday <= 31) coorectDate(birthday, dday);
                }


            } catch (DateTimeException e) {
                e.printStackTrace();
                incorrectDate(birthday);
            }
        }
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getInfo() {
        return "__________________________\nЧеловек с id: " + getId() + "\nЧеловек с именем: " + getName() + "\nЕго координаты:\n\tx - " + coordinates.getX() + "\n\ty - " + coordinates.getY() + "\nДата создания: " + getCreationDate() + "\nРост человека в метрах: " + getHeight() + "\nДень рождения: " + getBirthday().getDayOfMonth() + "." + getBirthday().getMonthValue() + "." + getBirthday().getYear() + "\nВес в кг: " + getWeight() + "\nСтрана рождения - " + getCountry() + "\nЛокация:\n\tНазвание места - " + location.getName() + "\n\tx - " + location.getX() + "\n\ty - " + location.getY() + "\n\tz - " + location.getZ() + "\n__________________________";
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", birthday=" + birthday +
                ", weight=" + weight +
                ", country=" + country +
                ", location=" + location +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Float.compare(person.weight, weight) == 0 && Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(coordinates, person.coordinates) && Objects.equals(creationDate, person.creationDate) && Objects.equals(height, person.height) && Objects.equals(birthday, person.birthday) && country == person.country && Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, height, birthday, weight, country, location);
    }

    @Override
    public int compareTo(Person o) {
        if (this.getName().equals(o.getName())) {
            return 0;
        }
        if (this.getName().compareTo(o.getName()) > 0) {
            return -1;
        } else {
            return 1;
        }
    }
}