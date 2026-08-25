package oops;

import oops.SomeOne.Builder;

class SomeOne {
    private int id;
    private int age;
    private String firstName;
    private String middleName;
    private String lastName;

    private SomeOne() {

    }

    public static class Builder {
        private SomeOne someOne = new SomeOne();

        public Builder age(int x) {
            someOne.age = x;
            return this;
        }

        public Builder id(int id) {
            this.someOne.id = id;
            return this;
        }

        public Builder firstName(String n) {
            someOne.firstName = n;
            return this;
        }

        public Builder lastName(String n) {
            someOne.lastName = n;
            return this;
        }

        public Builder middleName(String s) {
            someOne.middleName = s;
            return this;
        }

        public SomeOne build() {
            return someOne;
        }
    }
}

public class MyBuilderPattern {
    public static void main(String[] args) {
        SomeOne someOne = new Builder()
                .age(21)
                .firstName("G.R. ")
                .lastName("Charukesh")
                .middleName(null).build();
    }

}
