/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> data = new ArrayList<>();
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            data.add(node.val);
            inorderTraversal(node.right);
        }
    }
    public int minDiffInBST(TreeNode root) {

        inorderTraversal(root);

        int len = data.size();
        int min = Integer.MAX_VALUE;

        for(int i=1;i<len;i++){
            min = Math.min(min,(data.get(i) - data.get(i-1)));
        }
        return min;
    }
}