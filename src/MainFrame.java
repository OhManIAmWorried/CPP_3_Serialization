import version1.Author;

import java.io.ObjectStreamClass;
import java.util.ArrayList;

/**
 * Created by Oly on 26.03.2017.
 */
public class MainFrame {
    public static void main(String[] args) {
        //System.out.println(ObjectStreamClass.lookup(version2.Author.class).getSerialVersionUID());
        testVersion1();
        testVersion2();
        testVersion3();
    }

    private static void testVersion1(){
        System.out.println("Testing version1");
        version1.Author a1 = new version1.Author("name1","surname1");
        version1.Author a2 = new version1.Author("name2","surname2");
        version1.Author a3 = new version1.Author("name3","surname3");
        ArrayList<version1.Author> authors = new ArrayList<>();
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        version1.Book b1 = new version1.Book("book1",authors,1998,1);
        version1.Book b2 = new version1.Book("book2",authors,1999,1);
        version1.Book b3 = new version1.Book("book3",authors,2000,1);
        ArrayList<version1.Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        version1.BookReader br1 = new version1.BookReader("name1","surname1",1,books);
        version1.BookReader br2 = new version1.BookReader("name2","surname2",2,books);
        version1.BookReader br3 = new version1.BookReader("name3","surname3",3,books);
        ArrayList<version1.BookReader> bookReaders = new ArrayList<>();
        bookReaders.add(br1);
        bookReaders.add(br2);
        bookReaders.add(br3);
        version1.BookStore bs1 = new version1.BookStore("BookStore1","type1",books);
        version1.BookStore bs2 = new version1.BookStore("BookStore2","type2",books);
        version1.BookStore bs3 = new version1.BookStore("BookStore3","type3",books);
        ArrayList<version1.BookStore> bookStores = new ArrayList<>();
        bookStores.add(bs1);
        bookStores.add(bs2);
        bookStores.add(bs3);
        version1.Library lib = new version1.Library("library",bookStores,bookReaders);
        version1.LibraryDriver ld = new version1.LibraryDriver();
        System.out.println(lib);
        ld.serializeObject(lib);
        System.out.println(ld.deSerializeObject());
    }

    private static void testVersion2(){
        System.out.println("Testing version2");
        version2.Author a1 = new version2.Author("name1","surname1");
        version2.Author a2 = new version2.Author("name2","surname2");
        version2.Author a3 = new version2.Author("name3","surname3");
        ArrayList<version2.Author> authors = new ArrayList<>();
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        version2.Book b1 = new version2.Book("book1",authors,1998,1);
        version2.Book b2 = new version2.Book("book2",authors,1999,1);
        version2.Book b3 = new version2.Book("book3",authors,2000,1);
        ArrayList<version2.Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        version2.BookReader br1 = new version2.BookReader("name1","surname1",1,books);
        version2.BookReader br2 = new version2.BookReader("name2","surname2",2,books);
        version2.BookReader br3 = new version2.BookReader("name3","surname3",3,books);
        ArrayList<version2.BookReader> bookReaders = new ArrayList<>();
        bookReaders.add(br1);
        bookReaders.add(br2);
        bookReaders.add(br3);
        version2.BookStore bs1 = new version2.BookStore("BookStore1","type1",books);
        version2.BookStore bs2 = new version2.BookStore("BookStore2","type2",books);
        version2.BookStore bs3 = new version2.BookStore("BookStore3","type3",books);
        ArrayList<version2.BookStore> bookStores = new ArrayList<>();
        bookStores.add(bs1);
        bookStores.add(bs2);
        bookStores.add(bs3);
        version2.Library lib = new version2.Library("library",bookStores,bookReaders);
        version2.LibraryDriver ld = new version2.LibraryDriver();
        System.out.println(lib);
        ld.serializeObject(lib);
        System.out.println(ld.deSerializeObject());
    }

    private static void testVersion3(){

    }

}
