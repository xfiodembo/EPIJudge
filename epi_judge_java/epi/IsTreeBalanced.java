package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
public class IsTreeBalanced {

  @EpiTest(testDataFile = "is_tree_balanced.tsv")

  public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
    return Math.abs(getHeight(tree.left,0)- getHeight(tree.right,0)) <= 1;
  }
  public static int getHeight(BinaryTreeNode<Integer> tree, int height){
    if(tree == null){
      return height;
    }
    height = Math.max(height,getHeight(tree.left,height + 1));
    height = Math.max(height,getHeight(tree.right,height + 1));
    return  height;

  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "IsTreeBalanced.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
