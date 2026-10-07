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
        if(lists.length==0) return null;
        ListNode ans=lists[0];
        for(int i=1;i<lists.length;i++){
            ans=mergeTwoList(ans,lists[i]);
        }
        return ans;
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