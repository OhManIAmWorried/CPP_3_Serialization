package version2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class BookReader extends Human implements Serializable {
    private int registrationID;
    private transient ArrayList<Book> booksInUse;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(super.getName());
        out.writeObject(super.getSurname());
        out.writeInt(booksInUse.size());
        for (Book b: booksInUse) {
            out.writeObject(b.getTitle());
            out.writeInt(b.getVersion());
            out.writeInt(b.getYear());
            out.writeInt(b.getAuthors().size());
            for (Author a: b.getAuthors()) {
                out.writeObject(a.getName());
                out.writeObject(a.getSurname());
            }
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        super.setName((String)in.readObject());
        super.setSurname((String)in.readObject());
        int booksInUseSize = in.readInt();
        booksInUse = new ArrayList<Book>();
        for (int i = 0; i < booksInUseSize; i++) {
            String title = (String)in.readObject();
            int version = in.readInt();
            int year = in.readInt();
            int authorsSize = in.readInt();
            ArrayList<Author> authors = new ArrayList<Author>();
            for (int j = 0; j < authorsSize; j++) {
                authors.add(new Author((String) in.readObject(),(String) in.readObject()));
            }
            booksInUse.add(new Book(title,authors,year,version));
        }
    }

    public BookReader(String name, String surname, int registrationID, ArrayList<Book> booksInUse) {
        super(name,surname);
        this.registrationID = registrationID;
        this.booksInUse = booksInUse;
    }

    public int getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(int registrationID) {
        this.registrationID = registrationID;
    }

    public void addBook(Book book) {
        booksInUse.add(book);
    }

    public ArrayList<Book> getBooksInUse() {
        return booksInUse;
    }

    public void setBooksInUse(ArrayList<Book> booksInUse) {
        this.booksInUse = booksInUse;
    }
}
