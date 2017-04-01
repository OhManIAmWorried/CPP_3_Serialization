package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class BookStore implements Externalizable {
    private static final long serialVersionUID = -2377667993900040104L;

    private String name;
    private String type;
    private ArrayList<Book> books;

    public BookStore() {
        name = "DefaultName";
        type = "DefaultType";
        books = new ArrayList<Book>();
    }

    public BookStore(String name, String type, ArrayList<Book> books) {
        this.name = name;
        this.type = type;
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" ").append(type);
        for (Book b : books) {
            sb.append(" ").append(b);
        }
        return(sb.toString());
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(type);
        out.writeInt(books.size());
        for (Book b : books) {
            b.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        type = (String)in.readObject();
        int booksSize = in.readInt();
        for (int i = 0; i < booksSize; i++) {
            Book b = new Book();
            b.readExternal(in);
            books.add(b);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
