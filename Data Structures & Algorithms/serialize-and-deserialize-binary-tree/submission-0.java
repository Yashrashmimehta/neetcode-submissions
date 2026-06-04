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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();

        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.poll();
            if(n==null) {
                s.append("n ");
            }else{
                s.append(n.val+" ");
                q.add(n.left);
                q.add(n.right);
            }
        }
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
         if(data.equals("")) return null;

        String[] values = data.split(" ");

        TreeNode root =
            new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for(int i = 1; i < values.length; i++){

            TreeNode parent = q.poll();

            // Left Child
            if(!values[i].equals("n")){

                TreeNode left =
                    new TreeNode(Integer.parseInt(values[i]));

                parent.left = left;
                q.add(left);
            }

            // Right Child
            if(++i < values.length &&
               !values[i].equals("n")){

                TreeNode right =
                    new TreeNode(Integer.parseInt(values[i]));

                parent.right = right;
                q.add(right);
            }
        }

        return root;
    }
}
