package generics;

public class GenericMethods {
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
        gm.f(2.3, 1);
    }

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public <T, K> void f(T x, K k) {
        System.out.println(x.getClass().getName() + " / " + k.getClass().getName());
    }
}