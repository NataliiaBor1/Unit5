package sorts;

import java.util.Arrays;

public class BubbleSort {  // classic

    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i; j++) {
                if (array[j-1] > array[j]) {
                    array[j] = array[j-1] + array[j];
                    array[j-1] = array[j] - array[j-1];
                    array[j] = array[j] - array[j-1];
                }
            }
        }
        return array;
    }

    public static int[] bubbleSort(int[] arr) {  // from Nick  // work incorrectly
        boolean done = false;
        while (!done) {
            done = true;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[i+i]) {
                    arr[i] = arr[i] ^ arr[i+1];
                    arr[i+1] = arr[i] ^ arr[i+1];
                    arr[i] = arr[i] ^ arr[i+1];
                    done = false;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 5};
        int[] numbers1 = {7, 3, 1, 2, 0, 5};
        int[] numbers2 = {7, 3, 1, 2, 1, 0, 7, 5};
        System.out.println(Arrays.toString(sort(numbers)));
        System.out.println(Arrays.toString(sort(numbers1)));
        System.out.println(Arrays.toString(sort(numbers2)));
        System.out.println("--------------------");

//        System.out.println(Arrays.toString(bubbleSort(numbers)));  //work incorrectly
//        System.out.println(Arrays.toString(bubbleSort(numbers1)));
//        System.out.println(Arrays.toString(bubbleSort(numbers2)));
    }
}
