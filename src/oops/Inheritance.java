package oops;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Inheritance {
    public static void main(String[] args) {
        Box n = new Box2(2, 3, 2, 22);
        
    }
}

class Box {
    int x;
    int y;
    int z;

    public Box(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Box2 extends Box {
    double weight;

    public Box2(int x, int y, int z, double weight) {
        super(x, y, z);
        this.weight = weight;

    }
}
