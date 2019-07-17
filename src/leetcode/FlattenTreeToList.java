package leetcode;

public class FlattenTreeToList {
	public void flatten(TreeNode root) {
        flattenHelper(root, null);
    }
    
    public void flattenHelper(TreeNode root, TreeNode next) {
        if (root == null)
            return;
        
        flattenHelper(root.right, next);
        flattenHelper(root.left, root.right);
        if (root.left == null && root.right == null)
            root.right = next;
        if (root.left != null)
        	root.right = root.left;
        root.left = null;
    }
    
    public static void main(String args[]) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.left = new TreeNode(3);
    	root.left.right = new TreeNode(4);
    	root.right = new TreeNode(5);
    	
    	FlattenTreeToList f = new FlattenTreeToList();
    	f.flatten(root);
    	System.out.println("Done");
    }
}
