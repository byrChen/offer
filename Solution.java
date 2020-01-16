import java.util.*;
public class Solution {
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        int length = sequence.length;
        if (length <= 2) return true;
        int[] inOrder = sequence.clone();
        Arrays.sort(inOrder);
        return IsPopOrder(inOrder, sequence);
    }

    public static boolean IsPopOrder(int[] pushA,int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) return false;
        Stack<Integer> s = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            s.push(pushA[i]);
            while (!s.empty() && s.peek() == popA[j]) {
                s.pop();
                j += 1;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(VerifySquenceOfBST(a));
    }
}
