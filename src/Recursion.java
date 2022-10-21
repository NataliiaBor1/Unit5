import java.util.LinkedList;

public class Recursion {

    public static int recursionSearch(String s, LinkedList<String> list) {

        return recursionSearch1(s, list, 0);
    }

    private static int recursionSearch1(String s, LinkedList<String> list, int countIndexes) {
        if (countIndexes >= list.size()) {
            return -1;
        }
        if (s.equalsIgnoreCase(list.get(countIndexes))) {
            return countIndexes;
        }
        else {
            countIndexes++;
            return recursionSearch1(s, list, countIndexes);
        }

    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("hey");
        list.add("there");
        list.add("you");

        System.out.println(recursionSearch("hey", list));         // 0  // work correctly!
        System.out.println(recursionSearch("porcupine", list));  //-1   // work correctly
        System.out.println(recursionSearch("there", list));     // 1  // work correctly!
        System.out.println(recursionSearch("you", list));       // 2  // work correctly!
        System.out.println("-----------------------------------");

        LinkedList<String> list1 = new LinkedList<>();
        list1.add("I");
        list1.add("love");
        list1.add("Java");
        list1.add("and");
        list1.add("development");

        System.out.println(recursionSearch("I", list1));               // 0   // work correctly!
        System.out.println(recursionSearch("porcupine", list1));     //-1   // work correctly
        System.out.println(recursionSearch("love", list1));         // 1  // work correctly!
        System.out.println(recursionSearch("Java", list1));         // 2  // work correctly!
        System.out.println(recursionSearch("and", list1));          // 3  // work correctly!
        System.out.println(recursionSearch("development", list1));  // 4  // work correctly!
        System.out.println("-----------------------------------");


            }
}
