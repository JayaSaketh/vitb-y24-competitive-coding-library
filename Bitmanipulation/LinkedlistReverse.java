import java.util.Scanner;
public class LinkedlistReverse {
    public static void main(String args[])
    {
        LL list = new LL();
        list.creation();
        list.display();
        list.reverse1();
        list.display();
    }
    
}
class LL{
     Node head;
    class Node{
        int data;
        Node link;
        Node(int data)
        {
            this.data=data;
            this.link=null;
        }
    }
    void creation()
    {
         Scanner sc= new Scanner(System.in);
        int ch=1;
        Node temp=null;
        while(ch!=0)
        {
            System.out.print("Enter the Data: ");
            int data=sc.nextInt();
            Node newnode=new Node(data);
            if(head==null)
            {
                head=temp=newnode;
            }
            else{
                temp.link=newnode;
                temp=newnode;
            }
            System.out.print("Enter 1 to continue and 0 to exit : ");
            ch=sc.nextInt();
        }
        System.out.println("SUCESSFULLY CREATED....");
    }
    void display()
    {
         if(head==null)
       {
        System.out.println("List is Empty ");
        return;
       }
       Node temp=head;
       while(temp!=null)
       {
        System.out.print(temp.data+" -> ");
        temp=temp.link;
       }
       System.out.print("NULL\n");
    }
   void reverse1()
    {
        reverse2(head);
    }
    void reverse2(Node temp)
    {
        if(temp.link==null)
        {
            head=temp;
            return;
        }
        reverse2(temp.link);
        temp.link.link=temp;
        temp.link=null;
    }
}
