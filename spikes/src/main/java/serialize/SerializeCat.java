package serialize;

import java.io.*;

class Cat implements Serializable {
    protected String name;

    public Cat(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}   // 1

public class SerializeCat {
    public static void main(String[] args) {
        Cat c = new Cat("ASDF");  // 2
        try {
            FileOutputStream fs = new FileOutputStream("testSer.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(c);   // 3
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fis = new FileInputStream("testSer.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            c = (Cat) ois.readObject();  // 4
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("desrialized cat: " + c);
    }
}