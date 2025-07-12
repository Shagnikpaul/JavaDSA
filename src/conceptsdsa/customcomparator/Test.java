package conceptsdsa.customcomparator;

import java.util.ArrayList;
import customclasses.MyItem;

public class Test {
    public static void main(String[] args) {
        MyItem item1 = new MyItem(21, "Hi");
        MyItem item2 = new MyItem(42, "Hello");
        MyItem item3 = new MyItem(13, "World");
        MyItem item4 = new MyItem(8, "Java");
        MyItem item5 = new MyItem(19, "Code");
        MyItem item6 = new MyItem(33, "Fun");

        ArrayList<MyItem> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        for (MyItem i : itemList) {
            System.out.println("Value : " + i.getItemValue() + " Name : " + i.getItemName());
        }

        System.out.println("After sorting according to the itemValue... ");
        itemList.sort(new CustomComparator());

        for (MyItem i : itemList) {
            System.out.println("Value : " + i.getItemValue() + " Name : " + i.getItemName());
        }
    }

}
