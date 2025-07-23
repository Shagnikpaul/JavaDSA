package oops;
public class ThisKeywordConstructor {
    int x,y;
    
    ThisKeywordConstructor() {
        this(2,3);
    }

    ThisKeywordConstructor(int x, int y){
        this.x = x;
        this.y = y;
    }
}
