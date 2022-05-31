import java.util.Scanner;

class Node{
    int data;
    Node next;
}
class ReverseALinkedList{

    static Node head = null;
    static Scanner scan = new Scanner(System.in);

    static void push(){
        Node newNode = new Node(),temp = head;
        newNode.data = scan.nextInt();
        newNode.next = null;
        if(temp==null){
            head = newNode;
        }else{
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Data added to Linked List");
    }

    static void print(){
        Node temp = head;
        if(temp==null)
            System.out.println("Linked list is empty");
        else{
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    static void reverse(){
        Node temp = head, t1 = null, t2 = null;
        while(temp!=null){
            t2 = temp.next;
            temp.next = t1;
            t1 = temp;
            temp = t2;
        }
        head = t1;
    }

    public static void main(String args[]){
        while(true){
            int x = scan.nextInt();
            switch(x){
                case 1:
                    push();
                    break;
                case 2:
                    print();
                    break;
                case 3:
                    reverse();
                    break;
                default:
                    System.out.println("Invalid Command");
            }
        }
    }
}
