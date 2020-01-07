import java.util.*;
public class Solution {
//    public static boolean IsPopOrder(int [] pushA,int [] popA) {
//        int length=popA.length;
//        if(length==0)
//            return true;
//        if(length==1)
//            return popA[0]==pushA[0];
//        int i;
//        for (i = 0; i < popA.length; i++) {
//            if(popA[i]==pushA[0])
//                break;
//        }
//        return IsPopOrder(Arrays.copyOfRange(pushA, 1, i+1),Arrays.copyOfRange(popA, 0, i)) &&
//                IsPopOrder(Arrays.copyOfRange(pushA, i+1, length),Arrays.copyOfRange(popA, i+1,length));
//    }

    public static boolean IsPopOrder(int[] pushA,int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) return false;
        if (pushA.length == 0) return true;
        if (pushA.length == 1) return pushA[0] == popA[0];
        int first = popA[0], index = -1;
        for (int i : pushA) {
            index += 1;
            if (i == first) break;
        }
        if (index == -1) return false;
        int[] left = Arrays.copyOfRange(pushA, 0, index);
        int[] right = Arrays.copyOfRange(pushA, index+1, pushA.length);
        int leftEnd = index, rightStart = index + 1;
        if (index != 0 && popA[1] != left[index-1]) {
            leftEnd = popA.length - 1;
            rightStart = 1;
        }
        int[] rightInpopA = Arrays.copyOfRange(popA, rightStart, rightStart+right.length);
        return IsPopOrder(right, rightInpopA) && reverse(left, popA, leftEnd);
    }

    private static boolean reverse(int[] a, int[] b, int index) {
        if (index != 0) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[index-i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {0,2};
        System.out.println(IsPopOrder(a, b));
    }
}
