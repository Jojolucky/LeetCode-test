/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist206;

/**
 *
 * @author jojo
 */
public class LinkedList206 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ListNode head = new ListNode();
        ListNode node = head;
        for (int i = 1; i < 6; i++) {
            node.next = new ListNode(i);
            node = node.next;
            
        }
        node = head;
        System.out.println("Original linkedlist: ");
        while (node != null) {

            System.out.print(node.val + "->");
            node = node.next;
        }
        
        
        System.out.println();
        ListNode reversed = reverseList(head);
        node = reversed;
        System.out.println("Reversed linkedlist: ");
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();

    }

    public static ListNode reverseList(ListNode head) {

        ListNode dummy = null;
        ListNode cur = new ListNode();
        cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy;
            dummy = cur;
            cur = temp;
        }
        return dummy;

    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
