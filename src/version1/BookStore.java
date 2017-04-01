package version1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class BookStore implements Serializable {
    private String name;
    private String type;
    private transient ArrayList<Book> books;

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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(books.size());
        for (Book b : books) {
            out.writeObject(b);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        books = new ArrayList<Book>();
        int booksSize = in.readInt();
        for (int i = 0; i < booksSize; i++) {
            books.add((Book)in.readObject());
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
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
}
