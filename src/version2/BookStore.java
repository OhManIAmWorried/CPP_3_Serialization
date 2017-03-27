package version2;

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

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(books.size());
        for (Book b : books) {
            out.writeObject(b.getTitle());
            out.writeInt(b.getVersion());
            out.writeInt(b.getYear());
            out.writeInt(b.getAuthors().size());
            for (Author a : b.getAuthors()) {
                out.writeObject(a.getName());
                out.writeObject(a.getSurname());
            }
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        books = new ArrayList<Book>();
        int size = in.readInt();
        for (int i = 0; i < size; i++) {
            Book b = new Book((String)in.readObject(),new ArrayList<Author>(),in.readInt(),in.readInt());
            int authorsSize = in.readInt();
            for (int j = 0; j < authorsSize; j++) {
                b.addAuthor(new Author((String)in.readObject(),(String)in.readObject()));
            }
            books.add(b);
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
