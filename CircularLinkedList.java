package com.company;
import java.util.Scanner;

//Node class

class Node{
    int data;
    Node next;
}

//Main Class

class CircularLinkedList{
    static Node head;

    //Function to add First element when there is no element in Linked List

    static void firstElement(int data){
        System.out.println("It is the first element of the linked list and added successfully");
        head = new Node();
        head.data = data;
        head.next = head;
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
        newNode.next = head;
        while(temp.next!=head){
            temp = temp.next;
        }
        temp.next = newNode;
        System.out.println("Data added to last successfully");
    }

    //Function to add element at starting

    static void addFirst(int data){
        Node newNode = new Node();
        Node temp = head;
        newNode.data = data;
        if(temp==null){
            firstElement(data);
            return;
        }
        while(temp.next!=head){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
        head = newNode;
        System.out.println("Data added successfully at first");
    }

    //Function to delete the element

    static void delete(int data){
        Node temp = head;
        if(head==null){
            System.out.print("No element in Linked list");
            return;
        }
        do{
            if(temp.next.data==data) {
                if (temp.next == head && temp == head)
                    head = null;
                else if(temp.next==head) {
                    head = head.next;
                    temp.next = head;
                }else
                    temp.next = temp.next.next;
                System.out.println(data + " deleted successfully");
                return;
            }
            temp = temp.next;
        }while(temp!=head);
        System.out.println("Data "+data+" not found");
    }

    //Function to Search the element

    static void search(int data){
        Node temp = head;
        if(temp==null){
            System.out.println("No data in the list");
            return;
        }
        do{
            if(temp.data==data){
                System.out.println("Data Found");
                return;
            }
            temp = temp.next;
        }while(temp!=head);
        System.out.println("Data not found");
    }

    //Function to print the Data in the Linked List

    static void print(){
        Node temp = head;
        if(temp==null){
            System.out.println("No data in the linked list");
            return;
        }
        System.out.println("Data stored in linked list are:");
        do{
            System.out.println(temp.data);
            temp = temp.next;
        }while(temp!=head);
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
