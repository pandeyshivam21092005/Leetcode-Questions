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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean foundnull=false;
        while(!queue.isEmpty()){
            TreeNode curr= queue.remove();
            if(curr==null) foundnull=true;
            else{
                if(foundnull) return false;
                queue.add(curr.left);
                queue.add(curr.right);
            } 
            
        }
        return true;
    }
}