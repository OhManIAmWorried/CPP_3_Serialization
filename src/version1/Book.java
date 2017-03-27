package version1;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Oly on 26.03.2017.
 */
public class Book implements Serializable {
    private static final long serialVersionUID = -4528466037336429799L;
    private String title;
    private LinkedList<Author> authors;
    private int year;
    private int version;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void setAuthors(LinkedList<Author> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
