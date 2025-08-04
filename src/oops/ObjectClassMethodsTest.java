package oops;

public class ObjectClassMethodsTest extends Object {

    int a;

    public ObjectClassMethodsTest(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return this.a == ((ObjectClassMethodsTest) obj).a;
    }

    public static void main(String[] args) {
        ObjectClassMethodsTest a = new ObjectClassMethodsTest(2);
        ObjectClassMethodsTest b = new ObjectClassMethodsTest(22);

        System.out.println(a.equals(b));
        
    }

}
