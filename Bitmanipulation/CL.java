import java.util.Scanner;

import org.w3c.dom.Node;

public class CL {
     public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("Welcome to the Circular Linked List Program :)");
        System.out.println("****************************************");
        LL list=new LL();
        int ch=0;
        do{
            System.out.println("1.Creation");
            System.out.println("2.Dispaly");
            System.out.println("3.Insertion at Begin");
            System.out.println("4.Insertion at Any");
            System.out.println("5.Insertion at Endṇ");
            System.out.println("6.Deletion at begin");
            System.out.println("7.Deletion at Any");
            System.out.println("8.Deletion at End");
            System.out.println("9.Exit");
            System.out.print("Enter the Choice: ");
            ch=sc.nextInt();
            switch (ch)
            {
                case 1 -> list.Creation();
                case 2 -> list.display();
                case 3 -> list.Insertion_begin();
                case 4 -> list.Insertion_Any();
                case 5 -> list.Insertion_End();
                case 6 -> list.Delete_begin();
                case 7 -> list.Delete_Any();
                case 8 -> list.Delete_End();
                case 9 -> 
                           {
                            System.out.print("Thanks For Using Our Program....");
                            System.exit(0);
                           }
                default -> System.out.println("Invalid option");
            }
        }while(true);
       
    }
}
class LL
{
    Node head;
    class Node{
        int data;
        Node link;

        Node(int data){
            this.data=data;
            this.link=null;
        }
    }
    void Creation(){
       Scanner sc = new Scanner(System.in);
       int ch=1,data;
       Node temp=null;
       while(ch!=0)
       {
        System.out.print("Enter Data: ");
        data=sc.nextInt();
        Node newnode=new Node(data);
        if(head==null)
        {
            head=temp=newnode;
        }
        else 
        {
            temp.link=newnode;
            newnode.link=head;
            temp=newnode;
        }
        System.out.print("Enter 1 to continue and 0 t exit: ");
        ch=sc.nextInt();
       }
    }
    void display()
    {
        Node temp=head;
        while(temp.link!=head)
        {
            System.out.print(temp.data+" ->");
            temp=temp.link;
        }
        System.out.print(temp.data+" ->NULL\n");
    }
    void Insertion_begin()
    {
        if(head==null)
        {
            System.out.println("You didn't create the  list to insert You Fool...");
            return;
        }
         Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Data: ");
        int data=sc.nextInt();
        Node temp=head;
        while(temp.link!=head)
        {
            temp=temp.link;
        }
        Node newnode=new Node(data);
        newnode.link=head;
        head=newnode;
        temp.link=head;
        System.out.println("Sucessfuly Inserted...");
    }
    void Insertion_End()
    {
        if(head==null)
        {
            System.out.println("You didn't create the  list to insert You Fool...");
            return;
        }
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the Data: ");
        int data=sc.nextInt();
        Node newnode=new Node(data);
        Node temp=head;
        while(temp.link!=head)
        {
            temp=temp.link;
        }
        temp.link=newnode;
        newnode.link=head;
        System.out.println("Sucessfuly Inserted...");
    }
    void Insertion_Any()
    {
        if(head==null)
        {
            System.out.println("You didn't create the  list to insert You Fool...");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Position To Insert the data: ");
        int pos=sc.nextInt();
        int count=1;
        Node temp=head;
        while(temp.link!=head)
        {
            count++;
            temp=temp.link;
        }
        if(pos>count+1||pos<1)
        {
            System.out.println("Insertion Can't Be done....");
            return;
        }
        System.out.print("Enter the Data: ");
        int data=sc.nextInt();
        Node newnode=new Node(data);
        if(pos==1)
        {
            newnode.link=head;
            head=newnode;
            temp.link=head; 
            System.out.println("Sucessfuly Inserted...");
            return;
        }
        int i=1;
        temp=head;
        while(i<pos-1)
        {
            temp=temp.link;
            i++;
        }
        newnode.link=temp.link;
        temp.link=newnode;
        System.out.println("Sucessfuly Inserted...");
    }
    void Delete_begin()
    {
        if(head==null)
        {
            System.out.println("You didn't create the  list to insert You Fool...");
            return;
        }
        Node temp=head;
        while(temp.link!=head)
        {
            temp=temp.link;
        } 
        temp.link=head.link;
        head=head.link;
        System.out.println("Sucessfully Deleted....");
    }
    void Delete_End()
    {
        if(head==null)
        {
            System.out.println("You didn't create the  list to insert You Fool...");
            return;
        }
        Node temp=head;
        while(temp.link.link!=head)
        {
            temp=temp.link;
        } 
        temp.link=head;
        System.out.println("Sucessfully deleted....");
    }
    void Delete_Any()
    {
         if(head==null)
        {
            System.out.println("You didn't create the  list to insert You Fool...");
            return;
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Position To Delete the data: ");
        int pos=sc.nextInt();
        int count=1;
        Node temp=head;
        while(temp.link!=head)
        {
            count++;
            temp=temp.link;
        }
        if(pos>count+1||pos<1)
        {
            System.out.println("Deletion Can't Be done....");
            return;
        }
        temp=head;
        if(pos==1)
        {  
            while(temp.link!=head)
            {
              temp=temp.link;
            } 
            temp.link=head.link;
            head=head.link;   
            System.out.println("Sucessfuly deleted...");
            return;
        }
        int i=1;
        while(i<pos-1)
        {
            temp=temp.link;
            i++;
        }
        temp.link=temp.link.link;
        System.out.println("Sucessflly Deleted...");
    }
}