package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiTestComparator;
import epi.test_framework.LexicographicalListComparator;
import epi.test_framework.GenericTest;

import java.util.*;
import java.util.function.BiPredicate;
public class Anagrams {
  @EpiTest(testDataFile = "anagrams.tsv")

  public static List<List<String>> findAnagrams(List<String> dictionary) {
    List<List<String>> ret = new ArrayList<>();
    HashMap<String,List<String>> map = new HashMap<>();
    for (String s: dictionary) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      if(!map.containsKey(key)){
        map.put(key,new ArrayList<>());
      }
      if(!map.get(key).contains(s)){
        map.get(key).add(s);
      }
    }
    for (String k : map.keySet()) {
      List<String> anagrams = map.get(k);
      if(anagrams.size() > 1){
        ret.add(anagrams);
      }

    }

    return ret;
  }
  @EpiTestComparator
  public static BiPredicate<List<List<String>>, List<List<String>>> comp =
      (expected, result) -> {
    if (result == null) {
      return false;
    }
    for (List<String> l : expected) {
      Collections.sort(l);
    }
    expected.sort(new LexicographicalListComparator<>());
    for (List<String> l : result) {
      Collections.sort(l);
    }
    result.sort(new LexicographicalListComparator<>());
    return expected.equals(result);
  };

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "Anagrams.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
