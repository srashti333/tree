import java.util.Scanner;

class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data=data;
    }
}
public class BinarySearchTree
{
    private Node root;
    public BinarySearchTree()
    {
        root=null;
    }

    Node current=root;
    Node p;
    public void insert(int x)
    {
        Node newnode=new Node(x);
        newnode.data=x;
        if(root==null)
        {
            root=newnode;
            p=root;
        }
        else{
            Node current=root;
            Node parent=null;
            while(true)
            {
                parent=current;
                if(x< parent.data)
                {
                    current=current.left;
                    if(current==null)
                    {
                        parent.left=newnode;
                        return;
                    }
                }
                else
                {
                    current=current.right;
                    if(current==null)
                    {
                        parent.right=newnode;
                        return;
                    }
                }
            }

        }
    }
    public void inorder()
    {
        traversal(root);
    }

    public void traversal(Node root)
    {
        if(root==null)
            return;
        traversal(root.left);
        System.out.print(root.data+" ");
        traversal(root.right);
    }

    public Node search(int x)
    {
        Node current =root;
        while(current.data!=x)
        {
            if(current.data>x)
            {
                current=current.left;
            }
            else
            {
                current=current.right;
            }
            if(current==null)
                return null;
        }
        return current;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        char ch='y';
        BinarySearchTree obj=new BinarySearchTree();
        System.out.println("""
                              press <1> for insertion.
                              press <2> for traversal.
                              press <3> for searching.\n
                              """);

        while(ch=='y'||ch=='Y')
        {
            int n=sc.nextInt();
            switch(n)
            {
                case 1:
                    obj.insert(sc.nextInt());
                    obj.inorder();
                    break;
                case 2:
                    obj.inorder();
                    break;
                case 3:
                    obj.search(sc.nextInt());
                    break;
                default:
                    System.out.println("enter valid value");
            }
            System.out.println("\nenter y/n");
            ch=sc.next().charAt(0);
        }
    }
}
