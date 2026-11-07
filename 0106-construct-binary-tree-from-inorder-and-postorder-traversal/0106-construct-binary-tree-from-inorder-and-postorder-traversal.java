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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int n= inorder.length;
         return build(0,n-1,0,n-1,postorder,inorder);
    }
     public TreeNode build(int poslo,int poshi,int inlo,int inhi,int[] postorder, int[] inorder) {
        if(poslo>poshi|| inlo>inhi) return null;
        int val=postorder[poshi];
        TreeNode root=new TreeNode(val);
        int r=inlo;
        for(int i=inlo;i<=inhi;i++){
            if(inorder[i]==val){
                r=i;
                break;
            }
        }
        int cnt=r-inlo;
        root.left=build(poslo,poslo+cnt-1,inlo,r-1,postorder,inorder);
        root.right=build(poslo+cnt,poshi-1,r+1,inhi,postorder,inorder);
        return root;
    }
}