package oops;

public class ShapeJ {

    int x;

    public ShapeJ() {
        this.x = 0;
    }

    public static void unique() {
        System.out.println("Unique from ShapeJ");
    }

    public void area() {
        System.out.println("Generic Area");
    }
}

class Circle extends ShapeJ {

    private int radius;
    private int diameter;
    

    @Override // just a notation
    public void area() {
        System.out.println("Circular Area");
    }


    
    public static void unique() {
        System.out.println("Unique from Circle");
    }

    public void circleMethod() {
        System.out.println("I am pointless");
    }



    public int getDiameter() {
        return diameter;
    }



    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }



   

    

    

    
}

class Triangle extends ShapeJ {

}
