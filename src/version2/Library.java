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
