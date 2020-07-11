Whenever solving a problem on Binary Trees, try the following properties:

1.  Traverse the tree in InOrder\
    If its a Binary Search Tree, InOrder traversal of the tree will give you a sorted array.\
    And sorted arrays are immensely useful. In just O(n), you can:
    1.  Remove elements outside a given range (similar pruning)
    2.  Ascertain whether the given tree is a Binary Search Tree or not
    3.  Populate the InOrder successor or predecessor
    4.  Find a pair with a given sum
    5.  Merge two Binary Search Trees

2.  InOrder traversal without recursion.\
    Stack needs to be used so that one can move to the left-most node and then climb back.

3.  PreOrder traversal without recursion.\
    This also needs a stack but it's simpler than InOrder, just take care of the order of insertion of left and right in the stack.

4.  PostOrder traversal without recursion.\
    This is easy if two points can be remembered:
    -   LRD = swapLandR (reverse(DLR))
    -   Reverse of a stack can be done by pouring it into another stack.So this one needs two stacks but its extremely similar to PreOrder.\
    Just put the stuff into second stack where PreOrder prints and you are done.

5.  InOrder traversal without recursion and stack. (Morris Traversal)

    | To eliminate the stack, create a **thread** on the left child's rightmost child.\
    This thread will point to the current parent and help in returning back.\
    On returning back, nullify the thread again if already present. | ![](https://prismoskills.appspot.com/lessons/Binary_Trees/threadedtree.png) |