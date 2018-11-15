package Model;

public class Pot {
    private int value = 0;

    public int getValue() {
        return value;
    }
    public void raisePot(int raise){
        this.value = this.value + raise;
    }
    public String toString(){
        return Integer.toString(value);
    }
}
