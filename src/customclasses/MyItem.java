package customclasses;

public class MyItem {
    private int itemValue;
    private String itemName;

    public MyItem(int v, String n) {
        this.itemName = n;
        this.itemValue = v;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemValue() {
        return itemValue;
    }

}