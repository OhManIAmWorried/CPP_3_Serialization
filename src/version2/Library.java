package version2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class Library implements Serializable {
    private String name;
    private transient ArrayList<BookStore> bookStores;
    private transient ArrayList<BookReader> bookReaders;

    public Library(String name, ArrayList<BookStore> bookStores, ArrayList<BookReader> bookReaders) {
        this.name = name;
        this.bookStores = bookStores;
        this.bookReaders = bookReaders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        for (BookStore bs : bookStores) {
            sb.append(" ").append(bs);
        }
        for (BookReader br : bookReaders) {
            sb.append(" ").append(br);
        }
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(bookStores.size());
        for (BookStore bs : bookStores) {
            out.writeObject(bs.getName());
            out.writeObject(bs.getType());
            out.writeInt(bs.getBooks().size());
            for (Book b : bs.getBooks()) {
                out.writeObject(b.getTitle());
                out.writeInt(b.getYear());
                out.writeInt(b.getVersion());
                out.writeInt(b.getAuthors().size());
                for (Author a : b.getAuthors()) {
                    out.writeObject(a.getName());
                    out.writeObject(a.getSurname());
                }
            }
        }
        out.writeInt(bookReaders.size());
        for (BookReader br: bookReaders) {
            out.writeObject(br.getName());
            out.writeObject(br.getSurname());
            out.writeInt(br.getRegistrationID());
            out.writeInt(br.getBooksInUse().size());
            for (Book b : br.getBooksInUse()) {
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
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int bookStoresSize = in.readInt();
        bookStores = new ArrayList<BookStore>();
        for (int i = 0; i < bookStoresSize; i++) {
            String name = (String)in.readObject();
            String type = (String)in.readObject();
            int booksSize = in.readInt();
            ArrayList<Book> books = new ArrayList<Book>();
            for (int j = 0; j < booksSize; j++) {
                String title = (String)in.readObject();
                int year = in.readInt();
                int version = in.readInt();
                ArrayList<Author> authors = new ArrayList<Author>();
                int authorsSize = in.readInt();
                for (int k = 0; k < authorsSize; k++) {
                    authors.add(new Author((String)in.readObject(),(String)in.readObject()));
                }
                books.add(new Book(title,authors,year,version));
            }
            bookStores.add(new BookStore(name,type,books));
        }
        int bookReadersSize = in.readInt();
        bookReaders = new ArrayList<BookReader>();
        for (int i = 0; i < bookReadersSize; i++) {
            String name = (String)in.readObject();
            String surname = (String)in.readObject();
            int registrationID = in.readInt();
            int booksInUseSize = in.readInt();
            ArrayList<Book> booksInUse = new ArrayList<>();
            for (int j = 0; j < booksInUseSize; j++) {
                String title = (String)in.readObject();
                int version = in.readInt();
                int year = in.readInt();
                int authorsSize = in.readInt();
                ArrayList<Author> authors = new ArrayList<>();
                for (int k = 0; k < authorsSize; k++) {
                    authors.add(new Author((String)in.readObject(),(String)in.readObject()));
                }
                booksInUse.add(new Book(title,authors,year,version));
            }
            bookReaders.add(new BookReader(name,surname,registrationID,booksInUse));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBookStore(BookStore bookStore) {
        bookStores.add(bookStore);
    }

    public void addBookReader(BookReader bookReader) {
        bookReaders.add(bookReader);
    }

    public ArrayList<BookStore> getBookStores() {
        return bookStores;
    }

    public void setBookStores(ArrayList<BookStore> bookStores) {
        this.bookStores = bookStores;
    }

    public ArrayList<BookReader> getBookReaders() {
        return bookReaders;
    }

    public void setBookReaders(ArrayList<BookReader> bookReaders) {
        this.bookReaders = bookReaders;
    }
}
