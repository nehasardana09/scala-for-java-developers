package examples;

/**
 * No Tail Call Optimization:
 * The JVM does not optimize tail-recursive calls, so each recursive call adds a new stack frame.
 * This can lead to a StackOverflowError if the recursion depth is too large.
 */

public class TailRecursionExample {
    public static void main(String[] args) {
        System.out.println(factorial(5, 1));  // Output: 120
        System.out.println(factorial(5));     // Output: 120
    }

    //tail recursion
    public static int factorial(int n, int acc) {
        if (n == 0) {
            return acc;
        } else {
            return factorial(n - 1, n * acc);
        }
    }

    // iteration
    public static int factorial(int n) {
        int acc = 1;
        while (n > 0) {
            acc *= n;
            n--;
        }
        return acc;
    }
}
