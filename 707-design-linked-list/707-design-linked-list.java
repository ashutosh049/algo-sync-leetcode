class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        this.head = new ListNode(0);
        this.size = 0;
    }

    public int get(int index) {
        // if index is out of range, return -1
        if (index < 0 || index >= size) {
            return -1;
        }

        ListNode curr = head;

        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return; // do nothing
        }

        if (index < 0) {
            index = 0; // add at head
        }

        size++;

        // keep the head with us
        ListNode curr = head;

        // traverse till index -1
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        // Set newNode to point to curr's next
        // Update th next of curr to point to newNode
        ListNode newNode = new ListNode(val);
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void deleteAtIndex(int index) {
        // if index is out of range, do nothing
        if (index < 0 || index >= size) {
            return;
        }

        // decrement the size
        size--;

        ListNode curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
