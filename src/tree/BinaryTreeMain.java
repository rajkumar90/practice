package tree;

public class BinaryTreeMain {
	public int maxPathSum(BinaryTreeNode root) {
        if (root == null)
            return 0;
        
        int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE, sumInclRoot = root.val;
        if (root.left != null) {
            leftSum = maxPathSum(root.left);
            sumInclRoot = Math.max(sumInclRoot, sumInclRoot + leftSum);
        }
        if (root.right != null) {
            rightSum = maxPathSum(root.right);
            sumInclRoot = Math.max(sumInclRoot, sumInclRoot + rightSum);
        }
        
        int max = Math.max(leftSum, Math.max(rightSum, sumInclRoot));
//        max = Math.max(max, root.val);
        return max;
    }
	
	public static void main(String[] args) {
		BinaryTreeMain b = new BinaryTreeMain();
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.left = new BinaryTreeNode(-2);
		root.right = new BinaryTreeNode(3);
		
		System.out.println(b.maxPathSum(root));
	}
}
