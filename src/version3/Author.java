package version3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Oly on 26.03.2017.
 */
public class Author extends Human implements Externalizable {
    private static final long serialVersionUID = 8204037216806971361L;

    public Author() {
        super();
    }

    public Author(String name, String surname) {
        super(name,surname);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName()).append(" ").append(super.getSurname());
        return sb.toString();
    }
}
