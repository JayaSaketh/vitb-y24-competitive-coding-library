import java.util.Scanner;
class DL{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("Welcome to the Double Linked List Program :)");
        System.out.println("****************************************");
        LL list=new LL();
        int ch=0;
        do{
            System.out.println("1.Creation");
            System.out.println("2.Dispaly");
            System.out.println("3.Insertion at Begin");
            System.out.println("4.Insertion at Any");
            System.out.println("5.Insertion at End");
            System.out.println("6.Deletion at begin");
            System.out.println("7.Deletion at Any");
            System.out.println("8.Deletion at End");
            System.out.println("9.Exit");
            System.out.print("Enter the Choice: ");
            ch=sc.nextInt();
            switch (ch)
            {
                case 1 -> list.creation();
                case 2 -> list.display();
                case 3 -> list.Insertion_Begin();
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
class LL{
    Node head=null;
    class Node{
        int data;
        Node prev,nxt;
        Node(int data)
        {
            this.data=data;
            this.nxt=null;
            this.prev=null;
        }
    }
    void creation()
    {
        Scanner sc=new Scanner(System.in);
        int ch=1,data;
        Node temp=null;
        while(ch!=0)
        {
            System.out.print("Enter the Data: ");
            data=sc.nextInt();
            Node newnode=new Node(data);
            if(head==null)
            {
                head=temp=newnode;
            }
            else{
                temp.nxt=newnode;
                newnode.prev=temp;
                temp=newnode;
            }
            System.out.print("Enter 1 to continue and 0 to exit: ");
            ch=sc.nextInt();
        }
    }
    void display()
    {
        Node temp=head;
        while (temp!=null)
        {
            System.out.print(temp.data+" <-> ");
            temp=temp.nxt;
        }
        System.out.println("NULL");
    }
    void Insertion_Begin()
    {
        Scanner sc=new Scanner(System.in);
        if(head==null)
        {
            System.out.println("You fisrt Create the list to insert into it");
            return;
        }
        int data;
        System.out.print("Enter the Data: ");
        data=sc.nextInt();
        Node newnode=new Node(data);
        newnode.nxt=head;
        head.prev=newnode;
        head=newnode;
    }
    void Insertion_End()
    {
        Scanner sc=new Scanner(System.in);
        if(head==null)
        {
            System.out.println("You fisrt Create the list to insert into it");
            return;
        }
        int data;
        System.out.print("Enter the Data: ");
        data=sc.nextInt();
        Node newnode=new Node(data);
        Node temp=head;
        while(temp.nxt!=null)
        {
            temp=temp.nxt;
        }
        temp.nxt=newnode;
        newnode.prev=temp;
    }
   void  Insertion_Any()
   {
      Scanner sc=new Scanner(System.in);
     if(head==null)
        {
            System.out.println("You fisrt Create the list to insert into it");
            return;
        }
        System.out.print("Enter the Position of data to be Inserted: ");
        int pos = sc.nextInt();
        Node temp=head;
        int count=0;
        while(temp.nxt!=null)
        {
            count++;
            temp=temp.nxt;
        }
        if(pos<1||pos>count+1)
        {
            System.out.println("Insertion can't be Done...");
            return;
        }
        int data;
        System.out.print("Enter the Data: ");
        data=sc.nextInt();
        Node newnode=new Node(data);
        if(pos==1)
        {
        newnode.nxt=head;
        head.prev=newnode;
        head=newnode;
        return;
        }
        int i=1;
        temp=head;
        while(i<pos-1)
        {
            i++;
            temp=temp.nxt;
        }
        newnode.prev=temp;
        newnode.nxt=temp.nxt;
        temp.nxt.prev=newnode;
        temp.nxt=newnode;
        System.out.println("Sucessfully Inserted....");
    }
    void Delete_begin()
    {
      if(head==null)
      {
        System.out.println("Fisrt create the list to delete in it...");
        return;
      }   
       head.nxt.prev=null;
       head=head.nxt;
       System.out.println("Sucessfully Deleted....");
    }
    void Delete_End()
    {
        if(head==null)
      {
        System.out.println("Fisrt create the list to delete in it...");
        return;
      }
      Node temp=head;
      while(temp.nxt.nxt!=null)
      {
        temp=temp.nxt;
      }
      temp.nxt.prev=null;
      temp.nxt=null;
      System.out.println("Sucessfully Deleted....");
    }
    void Delete_Any()
    {
        Scanner sc=new Scanner(System.in);
        if(head==null)
        {
            System.out.println("You fisrt Create the list to delete in it");
            return;
        }
        System.out.print("Enter the Position of data to be Deleted: ");
        int pos = sc.nextInt();
        Node temp=head;
        int count=0;
        while(temp.nxt!=null)
        {
            count++;
            temp=temp.nxt;
        }
        if(pos<1||pos>count+1)
        {
            System.out.println("Deletion can't be Done...");
            return;
        }
        if(pos==1)
        {
         temp=head;
         head.nxt.prev=null;
         head=head.nxt;
         System.out.println("Sucessfully Deleted....");
         temp.nxt=null;
         temp=null;
         return;
        }
        int i=1;
        temp=head;
        while(i<pos-1)
        {
            i++;
            temp=temp.nxt;
        }
        temp.nxt.prev=null;
        temp.nxt=temp.nxt.nxt;
        temp.nxt.prev.nxt=null;
        temp.nxt.prev=temp;
    }
}