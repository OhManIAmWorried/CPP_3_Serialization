package version2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Oly on 26.03.2017.
 */
public class Author extends Human /*implements Serializable*/{
    public Author(String name, String surname) {
        super(name,surname);
    }
/*
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(super.getName());
        out.writeObject(super.getSurname());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        super.setName((String)in.readObject());
        super.setSurname((String)in.readObject());
    }
*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" ").append(super.getSurname());
        return sb.toString();
    }
}
