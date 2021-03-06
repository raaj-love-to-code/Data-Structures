import java.util.Scanner;

//Node class

class Node{
    int data;
    Node next,prev;
}

//Main Class

class DoublyLinkedList{
    static Node head;
	
	//Function to add First element when there is no element in Linked List
	
    static void firstElement(int data){
       System.out.println("It is the first element of the linked list");
       head = new Node();
       head.data = data;
       head.next = null;
       head.prev = null;
    }
	
	// Function to add element at last
	
    static void addLast(int data){
        if(head==null){
            firstElement(data);
            return;
        }
        Node newNode = new Node();
        Node temp = head;
        newNode.data = data;
        newNode.next = null;
        while(temp.next!=null){
            temp = temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;
        System.out.println("Data added to last successfully");
    }
	
	//Function to add element at starting
	
    static void addFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = null;
        if(head==null){
            firstElement(data);
            return;
        }else{ 
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Data added successfully at first");
    }
	
	//Function to delete the element
	
    static void delete(int data){
        Node temp = head;
        if(temp.data == data){
            head = head.next;
            head.prev = null;
        }
        while(temp.next!=null){
            if(temp.next.data==data){
                temp.next.next.prev = temp;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        System.out.println("Deleted data "+data+" successfully");
    }
    
   	 //Function to Search the element
    
    static void search(int data){
        Node temp = head;
        while(temp!=null){
            if(temp.data==data){
                System.out.println("Data Found");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Data not found");
    }
	
	//Function to print the Data in the Linked List
	
    static void print(){
        Node temp = head;
        Node revTemp = temp;
        if(temp==null){
            System.out.println("No data in the linked list");
            return;
        }
	
	// Print data in Forward Direction
	
        System.out.println("Data stored in linked list are (Forward direction):");
        while(temp!=null){
            System.out.println(temp.data);
            revTemp = temp;
            temp = temp.next;
        }
	
	// Print Data in Backward Direction
	
        temp = revTemp;
        System.out.println("Data stored in linked list are (Backward direction):");
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }
	
	//Main Function
	
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Enter the command:\n1 - print\n2 - addFirst\n3 - addLast\n4 - delete\n5 - Search\n6 - Exit");
            int n = scan.nextInt();
            switch (n){
                case 1:
                    print();
                    break;
                case 2:
                    int d = scan.nextInt();
                    addFirst(d);
                    break;
                case 3: 
                    d = scan.nextInt();
                    addLast(d);
                    break;
                case 4:
                    d = scan.nextInt();
                    delete(d);
                    break;
                case 5:
                    d = scan.nextInt();
                    search(d);
                    break;
                case 6:
                    scan.close();
                    return;
                default:
                    System.out.println("Type a valid command");
            }
        }
    }
}
