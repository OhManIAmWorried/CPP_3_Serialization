package version1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class Book implements Serializable {
    private transient String title;
    private transient ArrayList<Author> authors;
    private int year;
    private int version;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title);
        for (Author a : authors) {
            sb.append(" ").append(a);
        }
        sb.append(" ").append(year).append(" ").append(version);
        return sb.toString();
    }

    public Book(String title, ArrayList<Author> authors, int year, int version) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.version = version;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(title);
        out.writeInt(authors.size());
        for (Author author : authors) {
            out.writeObject(author);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        title = (String)in.readObject();
        int authorsSize = in.readInt();
        authors = new ArrayList<Author>();
        for (int i = 0; i < authorsSize; i++) {
            authors.add((Author)in.readObject());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
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
