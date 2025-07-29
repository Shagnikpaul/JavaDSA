package oops;

public class OverrideTest {

    public static void main(String[] args) {
        ShapeJ soo = new ShapeJ();
        soo.area();

        ShapeJ circle = new Circle();
        circle.area();

        // cicle.circleMethod() gives error since it is not overridden by Circle class
        // from ShapeJ class...

        Circle c = new Circle();
        ShapeJ.unique();
        c.circleMethod();
    }

}