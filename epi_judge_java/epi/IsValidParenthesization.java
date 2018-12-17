package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class IsValidParenthesization {
  @EpiTest(testDataFile = "is_valid_parenthesization.tsv")

  public static boolean isWellFormed(String s) {
    Map<Character,Character> lookup = Map.of('(',')','[',']','{','}');
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < s.length(); i++){
      Character test = s.charAt(i);
      if(!stack.isEmpty() &&  lookup.getOrDefault(stack.peek(),'x') == test ){
        stack.pop();
      }else{
        stack.push(test);
      }
    }
    return stack.empty();
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsValidParenthesization.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
