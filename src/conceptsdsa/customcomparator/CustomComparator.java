package conceptsdsa.customcomparator;

import customclasses.MyItem;

import java.util.Comparator;

public class CustomComparator implements Comparator<MyItem> {

    @Override
    public int compare(MyItem o1, MyItem o2) {
        

        return (o1.getItemValue() - o2.getItemValue());
    }
}
