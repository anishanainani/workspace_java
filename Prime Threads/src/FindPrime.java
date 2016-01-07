

/**
 *
 * @author Vikhyat Gupta (0985873)
 */
public class FindPrime {

    public synchronized int countPrime(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; ++i) {
            if (isPrime(i)) {
                ++count;
            }
        }
        return count;
    }

    public boolean isPrime(int num) {
        for (int k = 2; k < num; k++) {
            if (num % k == 0) {
                return false;
            }
        }
        return true;
    }
}
