package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class Library implements Externalizable {
    private static final long serialVersionUID = -7096293844656462087L;

    private String name;
    private ArrayList<BookStore> bookStores;
    private ArrayList<BookReader> bookReaders;

    public Library() {
        name = "DefaultName";
        bookStores = new ArrayList<BookStore>();
        bookReaders = new ArrayList<BookReader>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBookStore(BookStore bookStore) {
        bookStores.add(bookStore);
    }

    public void addBookReaders(BookReader bookReader) {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(bookStores.size());
        for (BookStore bs : bookStores) {
            bs.writeExternal(out);
        }
        out.writeInt(bookReaders.size());
        for (BookReader br : bookReaders) {
            br.writeExternal(out);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        for (int i = 0; i < in.readInt(); i++) {
            BookStore bs = new BookStore();
            bs.readExternal(in);
            bookStores.add(bs);
        }
        for (int i = 0; i < in.readInt(); i++) {
            BookReader br = new BookReader();
            br.readExternal(in);
            bookReaders.add(br);
        }
    }
}
