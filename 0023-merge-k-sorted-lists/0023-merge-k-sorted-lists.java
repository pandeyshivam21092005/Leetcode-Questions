/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null|| lists.length==0) return null;
        int interval=1;
       while(interval<lists.length){
         for(int i=0;i+interval<lists.length;i+=interval*2){
            lists[i]=mergeTwoList(lists[i],lists[i+interval]);
        }
        interval*=2;
       }
       return lists[0];
    }
    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        ListNode i=l1;
        ListNode j= l2;
        ListNode dummy= new ListNode(-1);
        ListNode k=dummy;
        while(i!=null && j!=null){
            if(i.val<=j.val){
                k.next=i;
                i=i.next;
            }
            else{
                k.next=j;
                j=j.next;
            }
            k=k.next;
        }
        if(i==null) k.next=j;
        else k.next=i;
        return dummy.next;

    }
}