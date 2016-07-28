package generics;

import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

public class Holder3<T> {
    private T a;

    public Holder3(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<Pet>(new Cat("matcheck"));
        Pet a = h3.get(); // No cast needed
//         h3.set("Not an Pet"); // Error
//         h3.set(1); // Error
        System.out.println("Got: " + a);
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }
}