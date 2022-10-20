import java.util.LinkedList;

public class Recursion {

    public static int recursionSearch(String s, LinkedList<String> list) {

        return recursionSearch1(s, list, 0);
    }

    private static int recursionSearch1(String s, LinkedList<String> list, int countIndexes) {
        if (countIndexes > list.size()) {
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
}
