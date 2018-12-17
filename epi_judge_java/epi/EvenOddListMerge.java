package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class EvenOddListMerge {
  @EpiTest(testDataFile = "even_odd_list_merge.tsv")

  public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
    if(L == null){
      return  null;
    }
    List<ListNode<Integer>> even = new ArrayList<>();
    List<ListNode<Integer>> odd = new ArrayList<>();
    ListNode<Integer> current = L;
    Boolean isEven = true;
    while(current!=null){
      if(isEven){
        even.add(current);
        isEven = false;
      }else{
        odd.add(current);
        isEven = true;
      }
      current = current.next;
    }
    ListNode<Integer> head = even.get(0);
    if(even.size() > 0){
      even.get(even.size() -1).next = null;
    }
    if(odd.size() > 0){
      odd.get(odd.size() -1).next = null;
    }
    current = head;
    for(int i = 1; i < even.size(); i++){
      current.next = even.get(i);
      current = current.next;

    }
    for(int i = 0; i < odd.size(); i++){
      current.next = odd.get(i);
      current = current.next;

    }
    return head;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "EvenOddListMerge.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
