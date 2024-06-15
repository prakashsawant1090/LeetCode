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


static void pre(TreeNode head,ArrayList<Integer> ans){
    if(head==null) return;
    ans.add(head.val);
    pre(head.left,ans);
    pre(head.right,ans);
}

    public List<Integer> preorderTraversal(TreeNode root) {
          ArrayList<Integer> ans =new ArrayList<>();
        pre(root,ans);
        return ans;
    }
}