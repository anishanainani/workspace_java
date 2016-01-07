

/**
 *
 * @author vikhy_000
 */
public class Range {

    public int high, low;

    public Range(int low, int high) {
        this.high = high;
        this.low = low;
    }
    
    int getLow(){
    	return low;
    }

    int getHigh(){
    	return high;
    }
    public String toString() {
        return "" + low + "," + high;

    }

}
