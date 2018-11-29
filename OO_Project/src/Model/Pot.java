package Model;

/**
 * Holds the value of the current value of the pot.
 */
public class Pot implements Cloneable{
    /**
     * The value of the pot as an int.
     */
    private int value = 0;

    /**
     * Gets the value of the pot.
     * @return The value of the pot as a int.
     */
    public int getValue() {
        return value;
    }

    /**
     * Updates the value of the pot.
     * @param raise The amount to add to the current pot value.
     */
    public void raisePot(int raise){
        this.value = this.value + raise;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
    @Override
    public Pot clone(){
        Pot potClone = new Pot();
        potClone.value = this.value;
        return potClone;
    }
}
