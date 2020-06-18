public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }
        while(head.val == val){
            if (head.next == null){
                return null;
            }
            head = head.next;
        }
        ListNode node = head;
        ListNode prev;
        while(node.next!=null){
            prev = node;
            node = node.next;
            if (node.val == val){
                prev.next = node.next;
                node = prev;
            }
        }
        return head;
    }
}
