package person;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class Birthday
 */
public class Birthday implements Serializable {
    private int bday;
    private int bmonth;
    private int byear;

    public int getByear() {
        return byear;
    }

    public void setByear(int byear) {
        this.byear = byear;
    }

    public int getBmonth() {
        return bmonth;
    }

    public void setBmonth(int bmonth) {
        this.bmonth = bmonth;
    }

    public int getBday() {
        return bday;
    }

    public void setBday(int bday) {
        this.bday = bday;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "bday=" + bday +
                ", bmonth=" + bmonth +
                ", byear=" + byear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return bday == birthday.bday && bmonth == birthday.bmonth && byear == birthday.byear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bday, bmonth, byear);
    }
}
