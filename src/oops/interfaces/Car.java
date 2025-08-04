package oops.interfaces;

public class Car implements Body, Engine {

    @Override
    public void openDoor() {
        System.out.println("[CAR] : Doors are open.");

    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("[CAR] : Engine turned on.");
    }

    @Override
    public void start(int x) {
        // TODO Auto-generated method stub
        System.out.println("[CAR] : Body on.");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("[CAR] : Engine turned off.");
    }

    public static void main(String[] args) {
        Car c = new Car();

        c.start();
        c.openDoor();
        c.start(3);
        c.stop();
    }
}
