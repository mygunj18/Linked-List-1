//206. Reverse Linked List
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*Step 1: Taken 3 pointers. Initially, assigned "fast" as head's next, "Prev" as null and "curr" as head.
 * Step 2: Assign curr's next as prev and then fast as curr. Now while incrementing.. curr will become prev, fast will become curr and fast.next will be new fast.
 * Step 3: At last make curr.next as prev when fast == null and then return cur.
 */

/*Output:
 * Nodes of singly linked list are: 
1 2 3 4 5 
The reverse of LinkedList are: 
reverseLinkedList$ListNode@5d22bbb7reverseLinkedList$ListNode@41a4555ereverseLinkedList$ListNode@3830f1c0reverseLinkedList$ListNode@39ed3c8dreverseLinkedList$ListNode@71dac704

//wrong output in VS code
*
*/


public class reverseLinkedList {

	//Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
	
		//Represent the head and tail of the singly linked list    
	    public static ListNode head = null;    
	    public ListNode tail = null;
	        
	    //addNode() will add a new node to the list    
	    public void addNode(int data) {    
	        //Create a new node    
	    	ListNode newNode = new ListNode(data);    
	            
	        //Checks if the list is empty    
	        if(head == null) {    
	            //If list is empty, both head and tail will point to new node    
	            head = newNode;    
	            tail = newNode;    
	        }    
	        else {    
	            //newNode will be added after tail such that tail's next will point to newNode    
	            tail.next = newNode;    
	            //newNode will become new tail of the list    
	            tail = newNode;    
	        }    
	    }    
	        
	    //display() will display all the nodes present in the list    
	    public void display() {    
	        //Node current will point to head    
	    	ListNode current = head;    
	            
	        if(head == null) {    
	            System.out.println("List is empty");    
	            return;    
	        }    
	        System.out.println("Nodes of singly linked list are: ");    
	        while(current != null) {    
	            //Prints each node by incrementing pointer    
	            System.out.print(current.val + " ");    
	            current = current.next;    
	        }    
	        System.out.println();    
	    }    
	 
	    
	    public static ListNode reverseList(ListNode head) {
	        if(head == null) return null;
	    
	        ListNode curr=head;
	        ListNode prev=null;
	        ListNode fast=head.next;
	               
	        while(fast!=null)
	        {
	            curr.next=prev; // reversing the pointer
	            prev=curr;      //updating prev node
	            curr=fast;      //updating curr node
	            fast=fast.next; //updating fast node 
	        }
	        
	        curr.next=prev;
	        printList(curr);
	        return curr;
	    }
	    
	    public static void printList(ListNode head)
	    {
	        while (head != null) {
	            System.out.print(head);
	            head = head.next;
	        }
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		reverseLinkedList sList = new reverseLinkedList();    
		
        //Add nodes to the list    
        sList.addNode(1);    
        sList.addNode(2);    
        sList.addNode(3);    
        sList.addNode(4);    
        sList.addNode(5);
            
        //Displays the nodes present in the list    
        sList.display();  

        System.out.println("The reverse of Linkednlist are: ");
        reverseList(head);
        
	}

}
