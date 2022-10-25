import java.util.HashMap;
import java.util.Stack;

public class BalancedParentheses {
    //Write a function that takes in a string and returns true or false based on whether the string’s
    // opening-and-closing marks (that is, brackets) are balanced. Account for the following bracket types:
    // ()   {}   []   <>
    //The string doesn’t need to have all four types of brackets, but if an open bracket appears, the pair
    // should also be closed correctly. Assume you can use any libraries in Java needed.

    public static Boolean balancedParentheses(String s) {   // my solution
        int countOpen = 0;
        int countClose = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countOpen++;
            }
            else if (s.charAt(i) == ')') {
                countClose++;
            }
        }
        if (countOpen == countClose) {
            return true;
        }
        return false;
    }

    public static Boolean balancedParentheses1(String s) {  // my solution, wrong
        int countOpen = 0;
        int countClose = 0;

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ('('):
                case ('['):
                case ('{'):
                case ('<'):
                    countOpen++;
                    break;

                case (')'):
                case (']'):
                case ('}'):
                case ('>'):
                    countClose++;
                    break;
            }
        }
        if (countOpen == countClose) {
            return true;
        }
        return false;
    }

    public static Boolean balancedParentheses2(String s) {  // my solution, stack, wrong solution

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        Stack<Character> stack3 = new Stack<>();
        Stack<Character> stack4 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack1.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && !stack1.isEmpty()) {
                stack1.pop();
            }
            else if (s.charAt(i) == ')' && stack1.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == '{') {
                stack2.push(s.charAt(i));
            }
            else if (s.charAt(i) == '}' && !stack2.isEmpty()) {
                stack2.pop();
            }
            else if (s.charAt(i) == '}' && stack2.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == '[') {
                stack3.push(s.charAt(i));
            }
            else if (s.charAt(i) == ']' && !stack3.isEmpty()) {
                stack3.pop();
            }
            else if (s.charAt(i) == ']' && stack3.isEmpty()) {
                return false;
            }

            if (s.charAt(i) == '<') {
                stack4.push(s.charAt(i));
            }
            else if (s.charAt(i) == '>' && !stack4.isEmpty()) {
                stack4.pop();
            }
            else if (s.charAt(i) == '>' && stack4.isEmpty()) {
                return false;
            }
        }

        if (stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean balancedParentheses3(String s) {  // my solution, stack

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        charMap.put('>', '<');

        for (char x : s.toCharArray()) {

            switch (x) {
                case ('('):
                case ('['):
                case ('{'):
                case ('<'):
                    stack.push(x);
                    break;
                // "[(])" --->   [( --->  ( != [ ---> false
                // "[()]" --->  [( ---> ( != ( ----> [ != [
                case (')'):
                case (']'):
                case ('}'):
                case ('>'):
                    if (stack.isEmpty() || stack.pop().charValue() != charMap.get(x)) {
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


    public static boolean pParse(String input) {  //from Nick

        Stack<Character> charStack = new Stack<>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');
        charMap.put('>', '<');
//          ([)]
        //  stack.push()  --> (
        // stack.push --> [(
        // ')'  --> pop top recent element ( '[' ) and compare with value of hashMap for the ')' key; (charMap.get() )
                // and value will be exactly '('
        //  condition will be true --> we will return false
        for (char c : input.toCharArray()) {

            switch (c) {
                case ('('):
                case ('['):
                case ('{'):
                case ('<'):
                    charStack.push(c);
                    break;

                case (')'):
                case (']'):
                case ('}'):
                case ('>'):
                    if (charStack.isEmpty() || charStack.pop().charValue() != charMap.get(c)) {
                        return false;
                    }
                    break;
            }
        }
        if (!charStack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean balancedParentheses4(String s) {   // from solution expanding
        int numUnclosedOpenParens = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == '(') {
                numUnclosedOpenParens += 1;
            }
            else if (s.charAt(i) == ')') {
                numUnclosedOpenParens -= 1;
            }
            if (numUnclosedOpenParens < 0) {
                return false;
            }
        }
        return numUnclosedOpenParens == 0;
    }

    public static boolean balancedBrackets(String s) {   // from solution expanding

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < s.length(); i += 1) {

            // If character is opening bracket
            if (bracketPairs.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // Else, if character is closing bracket
            else if (bracketPairs.containsKey(s.charAt(i))) {
                // Closing bracket without matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Check that most recent bracket on stack matches
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int postfix(String expression) {  // "2 3 1 * + 9 -"   // from Nick, morning lecture
        // (2 + 3*1) - 9
        // 2 + 3 -> 23+
        // 31*  --> 3 --> 23+
        //  2 + 3 -- > 5
        // 59-  --> 5 - 9
        // 32
        Stack<Integer> charStack = new Stack<>();
        int temp;
        for (char token : expression.toCharArray()) {
            switch (token) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    charStack.push(Character.getNumericValue(token));
                    break;
                case '+':
                    charStack.push(charStack.pop() + charStack.pop());
                    break;
                    // 43-   4-3
                //     34
                case '-':
                    temp = charStack.pop();
                    charStack.push(charStack.pop() - temp);
                    break;
                case '*':
                    charStack.push(charStack.pop() * charStack.pop());
                    break;
                case '/':
                    temp = charStack.pop();
                    charStack.push(charStack.pop() / temp);
                    break;
                case '%':
                    temp = charStack.pop();
                    charStack.push(charStack.pop() % temp);
                    break;
            }

        }
        return charStack.pop();
    }

    public static void main(String[] args) {
        String s = "()"; // true
        String s1 = "())"; // false
        String s2 = "(())";  // true
        String s3 = "((((("; // false

        String s4 = "({}"; // false
        String s5 = "({})";  // true
        String s6 = "<({})"; // false
        String s7 = "<({})>";  // true
        String s8 = "[<({})>"; // false
        String s9 = "[<({})>]";  // true

        String s10 = "{{]]";  // false
        String s11 = "<}>{";  // false
        String s12 = "(]";   // false
        String s13 = "[(])";   // false

//        System.out.println(balancedParentheses(s));
//        System.out.println(balancedParentheses(s1));
//        System.out.println(balancedParentheses(s2));
//        System.out.println(balancedParentheses(s3));
        System.out.println("-----------------------");

        System.out.println(balancedParentheses3(s));
        System.out.println(balancedParentheses3(s1));
        System.out.println(balancedParentheses3(s2));
        System.out.println(balancedParentheses3(s3));
        System.out.println("-----------------------");
        System.out.println(balancedParentheses3(s4));
        System.out.println(balancedParentheses3(s5));
        System.out.println(balancedParentheses3(s6));
        System.out.println(balancedParentheses3(s7));
        System.out.println(balancedParentheses3(s8));
        System.out.println(balancedParentheses3(s9));
        System.out.println("-----------------------");
        System.out.println(balancedParentheses3(s10));
        System.out.println(balancedParentheses3(s11));
        System.out.println(balancedParentheses3(s12));
        System.out.println(balancedParentheses3(s13));
        System.out.println(balancedParentheses3(""));
    }
}
