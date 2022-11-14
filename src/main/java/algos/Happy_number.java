package algos;

public class Happy_number {

    public static void main(String[] args) {

        isHappy(5);

    }

    static public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    static private int digitSquareSum(int n) {
        int res = 0;
        int digit;
        for (; n > 0; n /= 10) {
            digit = n % 10;
            res += digit * digit;
        }
        return res;
    }


}
