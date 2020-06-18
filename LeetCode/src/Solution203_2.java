public class Solution203_2 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode res = removeElements(head.next,val);
        if(head.val == val){
            head = res;
        }else {
            head.next = res;
        }
        return head;
    }
}
