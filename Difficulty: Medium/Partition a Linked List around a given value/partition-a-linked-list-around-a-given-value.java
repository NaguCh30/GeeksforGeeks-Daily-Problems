class Solution {
    public Node partition(Node head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        Node equal = null, equalTail = null;
        Node less = null, lessTail = null;
        Node big = null, bigTail = null;

        Node temp = head;

        while (temp != null) {
            Node next = temp.next;
            temp.next = null;

            if (temp.data < x) {
                if (less == null) {
                    less = lessTail = temp;
                } else {
                    lessTail.next = temp;
                    lessTail = temp;
                }
            }

            else if (temp.data == x) {
                if (equal == null) {
                    equal = equalTail = temp;
                } else {
                    equalTail.next = temp;
                    equalTail = temp;
                }
            }

            else {
                if (big == null) {
                    big = bigTail = temp;
                } else {
                    bigTail.next = temp;
                    bigTail = temp;
                }
            }

            temp = next;
        }

        // Connect the three lists safely
        Node newHead = null;
        Node tail = null;

        if (less != null) {
            newHead = less;
            tail = lessTail;
        }

        if (equal != null) {
            if (newHead == null) {
                newHead = equal;
            } else {
                tail.next = equal;
            }
            tail = equalTail;
        }

        if (big != null) {
            if (newHead == null) {
                newHead = big;
            } else {
                tail.next = big;
            }
            tail = bigTail;
        }

        return newHead;
    }
}