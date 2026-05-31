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
    int sol=0;
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        height(root);
        if(sol<=1) return true;
        else return false;
    }
    private int height(TreeNode root){
        if(root==null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        sol = Math.max(sol,Math.abs(lh-rh));

        return Math.max(lh,rh)+1;
    }
}
