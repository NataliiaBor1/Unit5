import java.util.Arrays;

public class MissingNumber {

    public static int findMissingNumber (int[] n, int max) {
        int missingNumber = 0;
        int count = 1;
        Arrays.sort(n);

        if (n.length == max && n[n.length-1] == max) {
            return 0;
        }

        for (int i = 0; i < n.length; i++) {
            if (n[i] == count) {
                count++;
            }
        }
        return missingNumber;
    }

    public static int findMissingNumber1 (int[] n, int max) {    // my solution   O(n^2)  // wrong solution
        int missingNumber = 0;  // work for not all test cases
        Arrays.sort(n);

        if (n.length == max && n[n.length-1] == max) { // if nothing is missing
            return 0;
        }
            for (int i = 0; i < n.length; i++) {
                if (i % 2 == 0 && n[i] % 2 == 0) {
                    missingNumber = n[i]-1;
                    break;
                }
                if (i % 2 == 1 && n[i] % 2 == 1) {
                    missingNumber = n[i]-1;
                    break;
                }
            }
        return missingNumber;
    }

    public static int findMissingNumber2 (int[] n, int max) { // O(n)
        int maxSum = (1 + max) * max/ 2;
        int realSum = 0;
        for (int i = 0; i < n.length; i++) {
            realSum += n[i];
        }
        if (maxSum - realSum == max) {
            return max;
        }
        return maxSum - realSum;
    }

    public static void main(String[] args) {
        int[] num = {2, 1, 4, 3, 6, 5, 7, 10, 9};  // {1,2,3,4,5,6,7,9,10} // must return 8
        int[] num1 = {2, 1, 4, 3, 6, 5, 7, 8, 9}; // must return 10
        int[] num2 = {2, 1, 4, 3, 6, 5, 7, 8, 9, 10}; // must return 0

        System.out.println(findMissingNumber1(num, 10));
        System.out.println(findMissingNumber1(num1, 10));
        System.out.println(findMissingNumber1(num2, 10));
        System.out.println("-----------------------");

        System.out.println(findMissingNumber2(num, 10));
        System.out.println(findMissingNumber2(num1, 10));
        System.out.println(findMissingNumber2(num2, 10));

        System.out.println("-------------------------");
        System.out.println(findMissingNumber(num, 10));
        System.out.println(findMissingNumber(num1, 10));
        System.out.println(findMissingNumber(num2, 10));
    }

}
