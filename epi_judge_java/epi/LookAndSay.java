package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.HashSet;
import java.util.Set;

public class LookAndSay {
  @EpiTest(testDataFile = "look_and_say.tsv")

  public static String lookAndSay(int n) {
    String s = "1";
    for(int i = 1; i < n; i++){
      s = nextNumber(s);
    }
    return s;
  }

  public static String nextNumber(String s){
    StringBuilder ret = new StringBuilder();
    for(int i = 0 ; i< s.length(); i++)
    {
      int count = 1;
      Character test = s.charAt(i);
      while(i + 1 < s.length() && s.charAt(i + 1) == test){
        count++;
        i++;
      }
      ret.append(count).append(test);
    }
    return ret.toString();

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "LookAndSay.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
