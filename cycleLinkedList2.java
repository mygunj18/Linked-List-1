//142. Linked List Cycle II
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

//Your code here along with comments explaining your approach
/*Step 1: First we will check whether there are any elements in LinkednList or not. If not then we will return null. As the position to which there forms a cycle 
 * from linkedinlist's last node. We will use two pointer Floyyd's algo. 
 * Step 2: We will name these 2 pointers as fast and slow and initially they will be at head. Then while fast is not equal to null as well as fast.next is not equal to null.
 * Keep incrementing slow by one and fast pointer by 2.
 * sTEP 3: If slow reaches the last element of linkedlist still slow has not yet become equal to fast. Then rewind the pointers by assigning slow pointer to again the heead.
 * Step 4: Now increment the slow pointer by 1 and fast pointer by 1 this time while fast != slow. Once fast will become equal to slow. At that index, cycle forms.
 * Step 5: return that index by returning either low or fast pointer value.
 */

/*Nodes of singly linked list are: 
3 2 0 -4 5 
The cycle exists at node: 
2
*/


public class cycleLinkedList2 {
	
	 //* Definition for singly-linked list.
	  class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
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
	  
    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;  // If there is no cycle, return null given in question
        
        ListNode slow=head;
        ListNode fast=head;
        boolean hascycle = false;
        
        while(fast !=null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast)
            {
                hascycle=true;
                break;
            }
        }
            
            if(!hascycle) return null;
            
            //rewinding
            slow=head;
            while(slow != fast)//if still slow and fast pointers have not met and fast's value is not null yet then
            {
                slow=slow.next;
                fast=fast.next;
            }
            System.out.println(fast.val);
        return fast;
        
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	cycleLinkedList2 sList = new cycleLinkedList2();    
        
        //Add nodes to the list    
        sList.addNode(3);    
        sList.addNode(2);    
        sList.addNode(0);    
        sList.addNode(-4);    
        sList.addNode(5);
            
        //Displays the nodes present in the list    
        sList.display();  
        /*Create loop for testing */
        head.next.next.next.next.next = head.next;
        System.out.println("The cycle exists at node: ");
    	detectCycle(head);
    	
    	
	}
}