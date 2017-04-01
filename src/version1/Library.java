package version1;

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
            out.writeObject(bs);
        }
        out.writeInt(bookReaders.size());
        for (BookReader br: bookReaders) {
            out.writeObject(br);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int bookStoresSize = in.readInt();
        bookStores = new ArrayList<BookStore>();
        for (int i = 0; i < bookStoresSize; i++) {
            bookStores.add((BookStore)in.readObject());
        }
        int bookReadersSize = in.readInt();
        bookReaders = new ArrayList<BookReader>();
        for (int i = 0; i < bookReadersSize; i++) {
            bookReaders.add((BookReader)in.readObject());
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
