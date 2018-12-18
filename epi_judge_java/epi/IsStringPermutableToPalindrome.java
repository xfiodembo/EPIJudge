package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashMap;
import java.util.HashSet;

public class IsStringPermutableToPalindrome {
  @EpiTest(testDataFile = "is_string_permutable_to_palindrome.tsv")

  public static boolean canFormPalindrome(String s) {
    HashMap<Character,Integer> charCounts = new HashMap<>();
    for(int i = 0; i < s.length(); ++i){
      Character c = s.charAt(i);
      charCounts.putIfAbsent(c,0);
      charCounts.put(c,charCounts.get(c) + 1);
    }

    int oddOccurringChars = 0;

    for ( Integer count :charCounts.values()) {
      if(count%2 != 0){
        ++oddOccurringChars;
      }
    }
    int remainder = s.length()%2;
    return (remainder == 0 && oddOccurringChars == 0) ||(remainder !=0 && oddOccurringChars == 1) ;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsStringPermutableToPalindrome.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
