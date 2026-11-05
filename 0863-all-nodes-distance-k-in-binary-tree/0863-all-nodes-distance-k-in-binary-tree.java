/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,TreeNode> parent=new HashMap<>();

    public void findparent(TreeNode root,TreeNode par){
        if(root==null) return;
        parent.put(root,par);

        findparent(root.left,root);
        findparent(root.right,root);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findparent(root,null);
        Queue<TreeNode>q=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();

        q.add(target);
        visited.add(target);

        int dist=0;

        while(!q.isEmpty()){
            int size=q.size();

            if(dist==k){
            List<Integer> ans=new ArrayList<>();
            for(TreeNode node:q){
                ans.add(node.val);
            }
            return ans;
          }

          for(int i=0;i<size;i++){
            TreeNode curr=q.remove();

            if(curr.left!=null && !visited.contains(curr.left)){
                q.add(curr.left);
                visited.add(curr.left);
            }

            if(curr.right!=null && !visited.contains(curr.right)){
                q.add(curr.right);
                visited.add(curr.right);
            }

            TreeNode par= parent.get(curr);

            if(par!=null && !visited.contains(par)){
                q.add(par);
                visited.add(par);
            }
          }
          dist++;
        }
        return new ArrayList<>();
    }
}