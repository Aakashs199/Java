import java.util.Scanner;
class Node 
 {
    int data;
    Node left, right;
    public Node(int item)
     {
        data = item;
        left = right = null;
    }
}

public class BinaryTree
 {
  Node root;
  public BinaryTree()
   {
      root = null;
   }

   void printLevelOrder()
     {
     int h = height(root);
     System.out.println("Height: "+h);
     for (int i = 1; i <= h; i++)
            printCurrentLevel(root, i);
     }


    int height(Node root) 
      {
           

        if (root == null)
            return 0;
        else
         {
            int lheight = height(root.left);
            int rheight = height(root.right);
              System.out.println("Root: "+lheight);
              System.out.println("Root: "+rheight);
            return Math.max(lheight, rheight) + 1;
         }
       }

    void printCurrentLevel(Node root, int level)
     {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) 
         {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
         }
    }
   public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        System.out.println("Enter the value for the root node:");
        int rootData = sc.nextInt();
        tree.root = new Node(rootData);
        System.out.println("Enter the value for the left child of the root node (or -1 if none):");
        int leftData = sc.nextInt();
        if (leftData != -1)
          {
            tree.root.left = new Node(leftData);
            System.out.println("Enter the value for the left child of the left node (or -1 if none):");
            int leftLeftData = sc.nextInt();
            if (leftLeftData != -1) 
             {
                tree.root.left.left = new Node(leftLeftData);
             }
            System.out.println("Enter the value for the right child of the left node (or -1 if none):");
            int leftRightData = sc.nextInt();
            if (leftRightData != -1)
            {
                 tree.root.left.right = new Node(leftRightData);
            }
        }

        System.out.println("Enter the value for the right child of the root node (or -1 if none):");
        int rightData = sc.nextInt();
        if (rightData != -1) {
            tree.root.right = new Node(rightData);

            System.out.println("Enter the value for the left child of the right node (or -1 if none):");
            int rightLeftData = sc.nextInt();
            if (rightLeftData != -1) {
                tree.root.right.left = new Node(rightLeftData);
            }

            System.out.println("Enter the value for the right child of the right node (or -1 if none):");
            int rightRightData = sc.nextInt();
            if (rightRightData != -1) {
                tree.root.right.right = new Node(rightRightData);
            }
        }

        System.out.println("Level order traversal of binary tree is:");
        tree.printLevelOrder();
    }
}
