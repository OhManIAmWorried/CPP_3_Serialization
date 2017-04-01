package version2;

/**
 * Created by Oly on 26.03.2017.
 */
public class Author extends Human {
    public Author(String name, String surname) {
        super(name,surname);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" ").append(super.getSurname());
        return sb.toString();
    }
}
