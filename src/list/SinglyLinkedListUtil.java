package list;

public class SinglyLinkedListUtil {
	/**
	 * Prints the contents of linked list
	 * @param head
	 */
	public static void printList(SinglyLinkedListNode head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}		
	}
	
	public static SinglyLinkedListNode init(int[] arr) {
		SinglyLinkedListNode head = null, tail = null;
		for (int i = 0; i < arr.length; i++) {
			if (head == null) {
				head = new SinglyLinkedListNode(arr[i]);
				tail = head;
			} else {
				tail.next = new SinglyLinkedListNode(arr[i]);
				tail = tail.next;
			}
		}
		return head;
	}
}
