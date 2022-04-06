package main.com.leetcode.dsa.lcpractice;

/*You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Constraints:

* The number of nodes in each linked list is in the range [1, 100].
* 0 <= Node.val <= 9
* It is guaranteed that the list represents a number that does not have leading zeros.

https://leetcode.com/problems/add-two-numbers/
*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SumTwoNumbersLinkedList {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currentNode = null;
        ListNode firstNode = null;
        ListNode previousNode = null;
        int carriedNumber = 0;
        int counter = 0;

        while(l1 != null || l2 != null) {
            currentNode = new ListNode();
            if (l1 != null && l2 != null) {
                currentNode.val = (l1.val + l2.val + carriedNumber) % 10;
                carriedNumber = (l1.val + l2.val + carriedNumber) / 10;
            }
            else if (l1 == null) {
                currentNode.val = (l2.val + carriedNumber) % 10;
                carriedNumber = (l2.val + carriedNumber) / 10;
            }
            else
            {
                currentNode.val = (l1.val + carriedNumber) % 10;
                carriedNumber = (l1.val + carriedNumber) / 10;
            }

            if(counter == 0){
                firstNode = currentNode;
                previousNode = firstNode;
            }
            else if(counter == 1){
                firstNode.next = currentNode;
                previousNode.next = currentNode;
                previousNode = currentNode;
            }
            else{
                previousNode.next = currentNode;
                previousNode = currentNode;
            }

            if(carriedNumber != 0)
            {
                currentNode = new ListNode(1, null);
                previousNode.next = currentNode;
            }


            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;

            counter++;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        SumTwoNumbersLinkedList obj = new SumTwoNumbersLinkedList();

        ListNode l1 = new ListNode(2, new ListNode(8, null));
        ListNode l2 = new ListNode(8, new ListNode(1, null));

        ListNode l3 = obj.addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
}
