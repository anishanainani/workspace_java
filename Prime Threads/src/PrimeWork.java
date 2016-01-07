

/**
 *
 * @author vikhy_000
 */
public class PrimeWork {

    private int hi, lo, bite, current;
    private boolean complete;

    public PrimeWork(int max, int bite) {
        lo = 1;
        hi = max;
        current = lo;
        this.bite = bite;
    }

    public PrimeWork(int min, int max, int bite) {
        lo = min;
        hi = max;
        current = lo;
        this.bite = bite;
        complete = false;

    }

    public synchronized Range getWork() {
      
        if (!complete) {
            if (current + bite > hi) {
                Range range = new Range(current, hi);
                current= hi;
                complete = true;
                return range;
            } else {
                Range range = new Range(current, current + bite - 1);
                current += bite;
                return range;
            }
        }
        System.out.println("g");
        return null;
        
    }
}
