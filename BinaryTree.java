package binaryTree;

import java.util.LinkedList;
import java.util.*;

/*class Node{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data=data;
		left=null;right=null;
	}
}*/
public class BinaryTree {
	Node root;
	public BinaryTree(int data)
	{
		root=new Node(data);
	}
	public void printInorder(Node root)
	{
		if(root==null)return;
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}
	public void printPostorder(Node root)
	{
		if(root==null) return ;
		printPostorder(root.left);
		printPostorder(root.right);
		System.out.println(root.data);
	}
	public void printPreorder(Node root)
	{
		if(root==null) return ;
		System.out.println(root.data);
		printPreorder(root.left);
		printPreorder(root.right);
	}
	// height of root node is consider as 1
	/* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
	public int height(Node root)
	{
		if(root==null) return 0;
		else {
			int lheight=height(root.left);
			int rheight=height(root.right);
			if(lheight>rheight) return lheight+1;
			else return rheight+1;
		}
	}
	// level order in O(n^2) 
	public void printLevel(Node root)
	{
		for(int i=1;i<=height(root);i++)
		{
			printGivenLevel(root,i);
		}
	}
	public void printGivenLevel(Node root,int i)
	{
		 if(root==null) return;
		 if(i==1) System.out.print(root.data+" ");
		 else if(i>1)
		 {
			 printGivenLevel(root.left, i-1);
			 printGivenLevel(root.right, i-1);
		 }
	}
	
	// O(n) solution 
	  public void levelOrder(Node root)
	  {
		  Queue<Node> q=new LinkedList<Node>();
		  q.add(root);
		  while(!q.isEmpty())
		  {
			  Node temp=q.poll();
			  System.out.print(temp.data+" ");
			  if(temp.left!=null)q.add(temp.left);
			  if(temp.right!=null)q.add(temp.right);
		  }
	  }
	  // line  by line level  order
	  public void levelOrderlbyl(Node root)
	  {
		  Queue<Node> q=new LinkedList<Node>();
		  int nodeCount=0;
		  q.add(root);
		  while(true)
		  {
			  nodeCount=q.size();
			  if(nodeCount==0)return;
			  while(nodeCount!=0)
			  {
				 Node temp=q.poll();
				 System.out.print(temp.data+" ");
				 if(temp.left!=null)q.add(temp.left);
				 if(temp.right!=null)q.add(temp.right);
				 nodeCount--; 
			  }
			  System.out.println();
		  }
 	  }
	  // Inorder by using stack
	  public void Inorder(Node root)
	  {
		  Stack<Node> s=new Stack<Node>();
		  Node current=root;
		 
		  while(current!=null)
		  {
			  s.push(current);
			  current=current.left;
		  }
		  while(!s.isEmpty())
		  {
			  current=s.pop();
			  System.out.println(current.data);
			  current=current.right;
			  while(current!=null)
			  {
				  s.push(current);
				  current=current.left;
			  }
		  }
	  }
	public static void main(String gg[])
	{
		BinaryTree bt=new BinaryTree(1);
		bt.root.left=new Node(2);
		bt.root.right=new Node(3);
		bt.root.right.right=new Node(4);
		bt.root.right.right.right=new Node(5);
		bt.printInorder(bt.root);
		System.out.println();
		bt.printPostorder(bt.root);
		System.out.println();
		bt.printPreorder(bt.root);
		System.out.println();
		System.out.println(bt.height(bt.root));
		bt.printLevel(bt.root);
		System.out.println();
		bt.levelOrderlbyl(bt.root);
		System.out.println();
	    bt.Inorder(bt.root);
	}
    
}
