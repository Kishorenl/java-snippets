
## Inorder successor

## Nodes at k distance
    [Print All Nodes At K distance](code/PrintAllNodesAtKFromGivenNode.java)

## K closest value  in binary  tree

## Is subTree
    [Is subtree](code/isSubtree.java)




## Find two nodes with sum k in BST == o(n)
    - Inorder traversal and have a hashset for comparision.
        t(C) = o(n), space = o(n)
    ```
    static boolean findpairUtil(Node root, int sum, 
                                HashSet<Integer> set)  
    { 
        if (root == null) 
            return false; 
  
        if (findpairUtil(root.left, sum, set)) 
            return true; 
  
        if (set.contains(sum - root.data))  
        { 
            System.out.println("Pair is found (" +  
                                (sum - root.data) + 
                                ", " + root.data + ")"); 
            return true; 
        }  
        else
            set.add(root.data); 
  
        return findpairUtil(root.right, sum, set); 
    }
    ```

    - Other soln, without hashset - maintain array(as it is already sorted due to inorder traversal) - just traverse with two counter from start and end of the array. 


    
