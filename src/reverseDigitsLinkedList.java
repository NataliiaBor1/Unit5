import java.util.LinkedList;

public class reverseDigitsLinkedList {
    //You will be given two linked lists in “reverse-digit” format. For example, the number 123 would be
    // represented in a linked list like this: 3 → 2 → 1 You should return the sum of these two numbers in
    // the same “reverse-digit” format. For 123 + 456, this should return 579, in the form of a linked list
    // like this: 9 → 7 → 5.
    //What is the runtime of this function?

    public static LinkedList<Integer> reverseDigitsLinkedList(LinkedList<Integer> first, LinkedList<Integer> second) {
        // wrong solution!!!!
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> temp1 = new LinkedList<>();
        LinkedList<Integer> temp2 = new LinkedList<>();

        while (!first.isEmpty()) {
            temp1.add(first.pollLast());
        }

        while (!second.isEmpty()) {
            temp2.add(second.pollLast());
        }

        String s1 = temp1.toString();
        String s2 = temp2.toString();
        s1 = s1.replace("[", "");
        s1 = s1.replace("]", "");
        s1 = s1.replace(", ", "");

        s2 = s2.replace("[", "");
        s2 = s2.replace("]", "");
        s2 = s2.replace(", ", "");

        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);

        int sum = num1 + num2;
        String sum1 = String.valueOf(sum);
        char[] sum2 = sum1.toCharArray();

        for (int i = sum2.length-1; i >= 0; i--) {
            result.add(Character.getNumericValue(sum2[i]));
        }
        return result;
    }

    public static LinkedList<Integer> reverseDigitsLinkedList1(LinkedList<Integer> first, LinkedList<Integer> second) {

        LinkedList<Integer> result = new LinkedList<>();
        int a;
        int b;
        int sum = 0;

        while (!first.isEmpty() || !second.isEmpty()) {
            if (!first.isEmpty()) {
                a = first.pollFirst(); // 2 // 1
            }
            else {
                a = 0; // 0
            }

            if (!second.isEmpty()) {
                b = second.pollFirst(); // 5 //4  // 9
            }
            else {
                b = 0;
            }
            sum += a + b;  // 0 + 4 + 6  // 1+2+5 // 0+1+4 // 0+0+9
            if (sum < 10) {     // 6+4 // 8 // 5 // 9
                result.add(sum);  //  8 // 5  // 9
                sum = 0;
            }
            else {
                result.add(sum % 10); // 0 //
                sum = 1;
            }
        }
        if (sum > 0) {
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> first = new LinkedList<>();
        LinkedList<Integer> second = new LinkedList<>();

        first.add(4);
        first.add(2);
        first.add(1);  // 124

        second.add(6);
        second.add(5);
        second.add(4);
        second.add(9);  // 9456    // sum = 9580 -----> list {0, 8, 5, 9}


        System.out.println(reverseDigitsLinkedList(first, second));
        System.out.println("________________________");
        System.out.println(reverseDigitsLinkedList1(first, second));

        LinkedList<Integer> first1 = new LinkedList<>();
        LinkedList<Integer> second1 = new LinkedList<>();

        first1.add(9);
        first1.add(9);
        first1.add(9);

        second1.add(9);
        second1.add(9);
        second1.add(9);
        second1.add(9);  // 10998 // 8,9,9,0,1

//        System.out.println(reverseDigitsLinkedList(first1, second1));
        System.out.println(reverseDigitsLinkedList1(first1, second1));

    }
}
