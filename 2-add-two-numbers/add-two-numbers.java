
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;  // A variable to store the "carry-over" to the next digit (like in column addition)
        ListNode dummyHead = new ListNode(0); // A dummy node at the beginning of the result list (makes adding the first element easier) \U0001f607
        ListNode current = dummyHead; // A pointer to the current node in the result list

        // While at least one of the lists isn't finished, or there's a carry-over
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;  // If l1 isn't finished, take its digit, otherwise 0
            int val2 = (l2 != null) ? l2.val : 0;  // If l2 isn't finished, take its digit, otherwise 0

            int sum = val1 + val2 + carry;  // Calculate the sum of the digits and the carry-over
            carry = sum / 10;  // Determine the carry-over to the next digit (if the sum is >= 10)
            int digit = sum % 10;  // Get the digit for the result list (the remainder after dividing by 10)

            current.next = new ListNode(digit);  // Create a new node in the result list with the calculated digit
            current = current.next;  // Move to the next node in the result list

            if (l1 != null) {
                l1 = l1.next;  // Move to the next node in l1
            }
            if (l2 != null) {
                l2 = l2.next;  // Move to the next node in l2
            }
        }
        return dummyHead.next;  // Return the result list (starting from the node after the dummy node) \U0001f389
    }
}