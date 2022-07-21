//160. Intersection of Two Linked Lists
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*Step 1: First let's find the length of two linked lists. So, that we can have head's of two lists at same index or level. 
 * Step 2: If any of the two lists are null then there are no intersection. So, check 2 lists for that.
 * Step 3: Now if listA is larger than listB in size then decrement listA to level where heads's will match.
 * Step 4: If ListB is larger than listA then decrement ListB to level of ListA's head.
 * Step 5: Now iterate both lists equally through slow(for listA) and fast(for listB) pointers and when these 2 pointers meet or become equal that is the node where two 
 * lists are intersecting. Return any of the two pointers slow or fast. 
 * */

/*Output:
 * The Intersection is at:null   // wrong output in VS code
*/

public class intersectionLinkedList {

	//Definition for singly-linked list.
	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	    }
	 }
     static ListNode headA,  headB;
	 
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null) return null;
	        
	        //Find the length of two linkednlists given
	        
	        int lenA=0;
	        int lenB=0;
        
	        //I will increment and store count in lenA and lenB for size of headA and headB
	        ListNode slowA=headA;
	        ListNode fastB=headB;
	        
	        //iterating through linkedList A 
	        while(slowA != null)
	        {
	            lenA++;
	            slowA=slowA.next;
	        }
	        //iterating through linkedList B 
	        while(fastB != null)
	        {
	            lenB++;
	            fastB=fastB.next;
	        }
	        
	//checking whichever is greater and then proceeding to make head of both linkedlist at same index to start with
	        while(lenA > lenB)
	        {
	            lenA--;
	            headA=headA.next;
	        }
	//checking whichever is greater and then proceeding to make head of both linkedlist at same index to start with
	        while(lenB > lenA)
	        {
	            lenB--;
	            headB=headB.next;
	        }
	        
	        while(headA != headB)
	        {
	            headA=headA.next;
	            headB=headB.next;
	            if(headA == headB)
	            {
	                break;
	            }            
	        }
	        System.out.println("The Intersection is at:" + headA);
	        return headA;       
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intersectionLinkedList list = new intersectionLinkedList();
		
        //Add nodes to the listA    
        list.headA = new ListNode(1);    
        list.headA.next = new ListNode(9);    
        list.headA.next.next = new ListNode(1);    
        list.headA.next.next.next = new ListNode(2);    
        list.headA.next.next.next.next = new ListNode(4);
        
        //Add nodes to the listB   
        list.headB = new ListNode(3);    
        list.headB.next = new ListNode(2);    
        list.headB.next.next = new ListNode(4);

        list.getIntersectionNode(headA, headB);

	}

}
