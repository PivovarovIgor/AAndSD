import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Homework01 {

    public static void main(String[] args) {

        /*

        2. Определить сложность следующих алгоритмов:
        -. Поиск элемента массива с известным индексом:  O(1)
        -. Дублирование одномерного массива через foreach:  O(n)
        -. Удаление элемента массива с известным индексом без сдвига: O(1)
        -. Удаление элемента массива с неизвестным индексом без сдвига: O(n)
        -. Удаление элемента массива с неизвестным индексом со сдвигом: O(n)

         */

        //3. Определить сложность следующих алгоритмов. Сколько произойдет итераций?

        simpleA(); // O(n)
        simpleB(); // O (n^2)
        simpleC(); //O(log n)
        simpleD(); //O(n)
        simpleE(); // O(n)
    }

    private static void simpleE() {
        fib(BigInteger.valueOf(50)); // O(n)
    }

    private static void simpleD() {
        factorial(BigInteger.valueOf(10000)); //O(n)
    }

    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.valueOf(2))) {
            return n;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.valueOf(2))));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }

    private static void simpleC() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayList.add(i * j);
                n--;
            } //O(n / 2) => O(n)
        } //O(log n)
    }

    private static void simpleB() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList.add(i * j);
            } // O(n)
        } // O (n^2)
    }

    private static void simpleA() {
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                arrayList.add(i * j);
            } // O(log n)
        } // O(n)
    }
}
