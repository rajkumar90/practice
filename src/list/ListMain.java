package list;

public class ListMain {

	static boolean hasCycle(SinglyLinkedListNode head) {

		SinglyLinkedListNode slow = head, fast = head;
		while (slow != null && fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				return true;
		}
		return false;
	}

	public static SinglyLinkedListNode partition(SinglyLinkedListNode head, int x) {
		if (head == null)
			return head;

		SinglyLinkedListNode head1 = null, head2 = null, tail1 = null, tail2 = null;
		while (head != null) {
			if (head.val < x) {
				if (head1 == null) {
					head1 = head;
					tail1 = head;
				} else {
					tail1.next = head;
					tail1 = head;
				}
			} else {
				if (head2 == null) {
					head2 = head;
					tail2 = head;
				} else {
					tail2.next = head;
					tail2 = head;
				}
			}

			head = head.next;
		}

		if (head1 == null)
			return head2;
		
		tail1.next = head2;
		tail2.next = null;
		return head1;
	}
	
	public static SinglyLinkedListNode oddEvenLinkedList(SinglyLinkedListNode head) {
		if (head == null || head.next == null)
			return head;
		
		SinglyLinkedListNode oddHead = head, oddTail = head, evenHead = head.next, evenTail = head.next;
		
		head = evenHead.next;
		while(head != null) {
			if (evenTail.next != null) {
				oddTail.next = evenTail.next;
				oddTail = oddTail.next;
				head = head.next;
			}
			
			if (oddTail.next != null) {
				evenTail.next = oddTail.next;
				evenTail = evenTail.next;
				head = head.next;
			}
				
			
		}
		
		evenTail.next = null;
		oddTail.next = evenHead;
		return oddHead;
	}
	
	public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
		SinglyLinkedListNode prev = null, cur = head, nex = null;
		while(cur != null) {
			nex = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nex;
		}
		
		return prev;
	}
	
	
	public static SinglyLinkedListNode reverseKGroup(SinglyLinkedListNode head, int k) {
        if (head == null)
            return head;
        
        SinglyLinkedListNode temp = head;
        for (int i = 0; i < k-1; i++) {                        
            if (temp.next == null)
                return reverse(head);
            temp = temp.next;
        }
        
        SinglyLinkedListNode next = temp.next;
        temp.next = null;
        temp = reverse(head);
        head.next = reverseKGroup(next, k);
        
        return temp;
    }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5};
		SinglyLinkedListNode head = SinglyLinkedListUtil.init(arr);
		
		SinglyLinkedListUtil.printList(reverseKGroup(head, 2));
	}

}
