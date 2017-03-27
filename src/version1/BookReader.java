package version1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class BookReader extends Human implements Serializable {
    private static final long serialVersionUID = 6294325218895599064L;
    private int registrationID;
    private ArrayList<Book> booksInUse;

    public ArrayList<Book> getBooksInUse() {
        return booksInUse;
    }

    public void addBook(Book book) {
        booksInUse.add(book);
    }

    public void setBooksInUse(ArrayList<Book> booksInUse) {
        this.booksInUse = booksInUse;
    }
}
