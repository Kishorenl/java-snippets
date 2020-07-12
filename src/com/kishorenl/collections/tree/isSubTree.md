## Basic Approach

Traverse the tree T in preorder fashion. For every visited node in the traversal, see if the subtree rooted with this node is identical to S.

Complexity: Time worst case complexity of above solution is O(mn) where m and n are number of nodes in given two trees.

```java
class BinaryTree  
{ 
    Node root1,root2; 
   
    /* A utility function to check whether trees with roots as root1 and 
       root2 are identical or not */
    boolean areIdentical(Node root1, Node root2)  
    { 
        /* base cases */
        if (root1 == null && root2 == null) 
            return true; 
   
        if (root1 == null || root2 == null) 
            return false; 
   
        /* Check if the data of both roots is same and data of left and right 
           subtrees are also same */
        return (root1.data == root2.data 
                && areIdentical(root1.left, root2.left) 
                && areIdentical(root1.right, root2.right)); 
    } 
   
    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S)  
    { 
        /* base cases */
        if (S == null)  
            return true; 
   
        if (T == null) 
            return false; 
   
        /* Check the tree with root as current node */
        if (areIdentical(T, S))  
            return true; 
   
        /* If the tree with root as current node doesn't match then 
           try left and right subtrees one by one */
        return isSubtree(T.left, S) 
                || isSubtree(T.right, S); 
    } 
   
    public static void main(String args[])  
    { 
        System.out.println(isSubtree(tree.root1, tree.root2)); 
    } 
} 

```

## Better and efficient algo

O(n) solution. The idea is based on the fact that inorder and preorder/postorder uniquely identify a binary tree. Tree S is a subtree of T if both inorder and preorder traversals of S are substrings of inorder and preorder traversals of T respectively.

```java

class Passing { 

	int i; 
	int m = 0; 
	int n = 0; 
} 

class BinaryTree { 

	static Node root; 
	Passing p = new Passing(); 

	String strstr(String haystack, String needle) 
	{ 
		if (haystack == null || needle == null) { 
			return null; 
		} 
		int hLength = haystack.length(); 
		int nLength = needle.length(); 
		if (hLength < nLength) { 
			return null; 
		} 
		if (nLength == 0) { 
			return haystack; 
		} 
		for (int i = 0; i <= hLength - nLength; i++) { 
			if (haystack.charAt(i) == needle.charAt(0)) { 
				int j = 0; 
				for (; j < nLength; j++) { 
					if (haystack.charAt(i + j) != needle.charAt(j)) { 
						break; 
					} 
				} 
				if (j == nLength) { 
					return haystack.substring(i); 
				} 
			} 
		} 
		return null; 
	} 

	// A utility function to store inorder traversal of tree rooted 
	// with root in an array arr[]. Note that i is passed as reference 
	void storeInorder(Node node, char arr[], Passing i) 
	{ 
		if (node == null) { 
			arr[i.i++] = '$'; 
			return; 
		} 
		storeInorder(node.left, arr, i); 
		arr[i.i++] = node.data; 
		storeInorder(node.right, arr, i); 
	} 

	// A utility function to store preorder traversal of tree rooted 
	// with root in an array arr[]. Note that i is passed as reference 
	void storePreOrder(Node node, char arr[], Passing i) 
	{ 
		if (node == null) { 
			arr[i.i++] = '$'; 
			return; 
		} 
		arr[i.i++] = node.data; 
		storePreOrder(node.left, arr, i); 
		storePreOrder(node.right, arr, i); 
	} 

	/* This function returns true if S is a subtree of T, otherwise false */
	boolean isSubtree(Node T, Node S) 
	{ 
		/* base cases */
		if (S == null) { 
			return true; 
		} 
		if (T == null) { 
			return false; 
		} 

		// Store Inorder traversals of T and S in inT[0..m-1] 
		// and inS[0..n-1] respectively 
		char inT[] = new char[100]; 
		String op1 = String.valueOf(inT); 
		char inS[] = new char[100]; 
		String op2 = String.valueOf(inS); 
		storeInorder(T, inT, p); 
		storeInorder(S, inS, p); 
		inT[p.m] = '\0'; 
		inS[p.m] = '\0'; 

		// If inS[] is not a substring of preS[], return false 
		if (strstr(op1, op2) != null) { 
			return false; 
		} 

		// Store Preorder traversals of T and S in inT[0..m-1] 
		// and inS[0..n-1] respectively 
		p.m = 0; 
		p.n = 0; 
		char preT[] = new char[100]; 
		char preS[] = new char[100]; 
		String op3 = String.valueOf(preT); 
		String op4 = String.valueOf(preS); 
		storePreOrder(T, preT, p); 
		storePreOrder(S, preS, p); 
		preT[p.m] = '\0'; 
		preS[p.n] = '\0'; 

		// If inS[] is not a substring of preS[], return false 
		// Else return true 
		return (strstr(op3, op4) != null); 
	} 

	// Driver program to test above functions 
	public static void main(String args[]) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		Node T = new Node('a'); 
		T.left = new Node('b'); 
		T.right = new Node('d'); 
		T.left.left = new Node('c'); 
		T.right.right = new Node('e'); 

		Node S = new Node('a'); 
		S.left = new Node('b'); 
		S.right = new Node('d'); 
		S.left.left = new Node('c'); 

		if (tree.isSubtree(T, S)) { 
			System.out.println("Yes, S is a subtree of T"); 
		} 
		else { 
			System.out.println("No, S is not a subtree of T"); 
		} 
	} 
} 

```