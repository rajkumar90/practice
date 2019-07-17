package leetcode;

public class BSTToDLL_426 {
	
	public Node treeToDoublyList(Node root) {
		if (root == null)
			return null;
		
		Node left = treeToDoublyList(root.left);
		Node right = treeToDoublyList(root.right);
		
		root.left = root;
		root.right = root;
		
		left = joinLists(left, root);
		left = joinLists(left, right);
		
		return left;
	}

	private Node joinLists(Node left, Node right) {
		if (left == null)
			return right;
		else if (right == null)
			return left;
		
		Node leftLast = left.left;
		Node rightLast = right.left;
		
		leftLast.right = right;		
		left.left = rightLast;
				
		right.left = left;
		rightLast.right = left;
			
		return left;
	}

	public static void main(String[] args) {
		Node root = new Node(4, null, null);
		root.left = new Node(2, null, null);
		root.right = new Node(5, null, null);
		Node result = new BSTToDLL_426().treeToDoublyList(root);
		
		System.out.println("Done" + result.val);
	}

}
