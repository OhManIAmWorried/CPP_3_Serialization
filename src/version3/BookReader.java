package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class BookReader extends Human implements Externalizable {
    private static final long serialVersionUID = -5173499492846782791L;

    private int registrationID;
    private ArrayList<Book> booksInUse;

    public BookReader() {
        super();
        this.registrationID = -1;
        this.booksInUse = new ArrayList<Book>();
    }

    public BookReader(String name, String surname, int registrationID, ArrayList<Book> booksInUse) {
        super(name, surname);
        this.registrationID = registrationID;
        this.booksInUse = booksInUse;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(registrationID);
        out.writeInt(booksInUse.size());
        for (Book b : booksInUse) {
            b.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        registrationID = in.readInt();
        int booksInUseSize = in.readInt();
        for (int i = 0; i < booksInUseSize; i++) {
            Book b = new Book();
            b.readExternal(in);
            booksInUse.add(b);
        }
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
