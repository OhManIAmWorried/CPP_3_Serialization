package version1;

import java.io.Serializable;

/**
 * Created by Oly on 26.03.2017.
 */
public abstract class Human implements Serializable {
    private static final long serialVersionUID = 1885634657794150073L;
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
