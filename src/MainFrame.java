import java.io.ObjectStreamClass;

/**
 * Created by Oly on 26.03.2017.
 */
public class MainFrame {
    public static void main(String[] args) {
        System.out.println(ObjectStreamClass.lookup(version2.Author.class).getSerialVersionUID());
        System.out.println(ObjectStreamClass.lookup(version2.Book.class).getSerialVersionUID());
        System.out.println(ObjectStreamClass.lookup(version2.BookReader.class).getSerialVersionUID());
        System.out.println(ObjectStreamClass.lookup(version2.BookStore.class).getSerialVersionUID());
        System.out.println(ObjectStreamClass.lookup(version2.Human.class).getSerialVersionUID());
        System.out.println(ObjectStreamClass.lookup(version2.Library.class).getSerialVersionUID());
    }
}
