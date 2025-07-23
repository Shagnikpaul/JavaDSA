package oops;

class Singleton {
    private Singleton() {
        // private means others can't create objects of this class on their own so they
        // gotta use another method just for obtaining the instance of this class.
        System.out.println("Object created ... ");
    }

    private static Singleton instance; // the only object of this class...

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // allowed since we are in the same class...
        }
        return instance;
    }
}

public class SingletonClass {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

         // all refer the same object
    }
}
