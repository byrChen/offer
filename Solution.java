public class Solution {

    private TreeNode root;


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        if (pre == null || in == null || pre.length != in.length) return null;
        if (pre.length == in.length && pre.length <= 1) return new TreeNode(pre[0]);
        TreeNode t = new TreeNode(pre[0]);
        int index = 0;
        while (in[index] != pre[0]) {
            index += 1;
        }
        int lLen = index, rLen = pre.length - index - 1;
        int[] lpre = new int[lLen], lin = new int[lLen];
        int[] rpre = new int[rLen], rin = new int[rLen];
        System.arraycopy(pre, 1, lpre, 0, lLen);
        System.arraycopy(pre, index+1, rpre, 0, rLen);
        System.arraycopy(in, 0, lin, 0, lLen);
        System.arraycopy(in, index+1, rin, 0, rLen);
        t.left = reConstructBinaryTree(lpre, lin);
        t.right = reConstructBinaryTree(rpre, rin);
        return t;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3,4,5,6,7}, in = {3,2,4,1,6,5,7};
        Solution s = new Solution();
        System.out.println(s.reConstructBinaryTree(pre, in).val);
    }
}
