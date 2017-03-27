package version3;

import java.io.*;

/**
 * Created by Oly on 26.03.2017.
 */
public class LibraryDriver {
    private final String fileName = "file.txt";
    public static void serializeObject(String fileName, Object obj){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(obj);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object deSerializeObject(String fileName){
        Object obj = null;
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
            obj = is.readObject();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
