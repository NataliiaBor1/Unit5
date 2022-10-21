package sorts;

import java.util.Arrays;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for (var i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 5};
        int[] numbers1 = {7, 3, 1, 2, 0, 5};
        int[] numbers2 = {7, 3, 1, 2, 1, 0, 7, 5};
        System.out.println(Arrays.toString(sort(numbers)));
        System.out.println(Arrays.toString(sort(numbers1)));
        System.out.println(Arrays.toString(sort(numbers2)));
    }
}
