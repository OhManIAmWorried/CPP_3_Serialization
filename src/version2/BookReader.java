package version2;

import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class BookReader extends Human {
    private int registrationID;
    private transient ArrayList<Book> booksInUse;

    public BookReader(String name, String surname, int registrationID, ArrayList<Book> booksInUse) {
        super(name,surname);
        this.registrationID = registrationID;
        this.booksInUse = booksInUse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" ").append(registrationID);
        for (Book b : booksInUse) {
            sb.append(" ").append(b);
        }
        return sb.toString();
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
