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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null){
            return null;
        }
        else if(list2==null){
            return list1;
        }
        else if(list1==null){
            return list2;
        }
        ListNode result = new ListNode();
        if(list1.val>list2.val){
            result.val=list2.val;
            list2=list2.next;
        }
        else{
            result.val=list1.val;
            list1=list1.next;
        }
        ListNode current = result;
        while(list1!=null&&list2!=null){
            ListNode next = new ListNode();
            if(list1.val>list2.val){
                next.val=list2.val;
                list2=list2.next;
            }
            else{
                next.val=list1.val;
                list1=list1.next;
            }
            current.next=next;
            current=current.next;
        }
        if(list2==null){
            current.next=list1;
        }
        else if(list1==null){
            current.next=list2;
        }
        return result;
    }
}