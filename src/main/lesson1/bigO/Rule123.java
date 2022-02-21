package lesson1.bigO;

public class Rule123 {

    public static int findMax(int[] array) {

        int max = array[0]; //O(1)

        System.out.println("Начинаем поиск"); //O(1)

        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        } //O(1 + 4 * (n - 1))

        System.out.println("Поиск окончен. Максимальное число: " + max); //O(1)

        return max; //O(1)
    }
}

// O(1) + O(1) + O(1) + O(1) + O(4n - 3)
// O(4n - 3)
// O(4n)
// O(n)
