package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class Book implements Externalizable {
    private static final long serialVersionUID = -3731285884011654695L;

    private String title;
    private ArrayList<Author> authors;
    private int year;
    private int version;

    public Book() {
        title = "DefaultTitle";
        authors = new ArrayList<Author>();
        year = -1;
        version = -1;
    }

    public Book(String title, ArrayList<Author> authors, int year, int version) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.version = version;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeInt(year);
        out.writeInt(version);
        out.writeInt(authors.size());
        for (Author a : authors) {
            a.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String)in.readObject();
        year = in.readInt();
        version = in.readInt();
        int authorsSize = in.readInt();
        for (int i = 0; i < authorsSize; i++) {
            Author a = new Author();
            a.readExternal(in);
            authors.add(a);
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
