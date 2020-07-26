# Problems

## Majority element
    - O(n^2) brute force
    - Insert elements in BST one by one and if an element is already present then increment the count of the node. At any stage, if the count of a node becomes more than n/2 then return. Tim o(nlogn) space o(n)
    - Moore's voting. o(n)
        - Find if there is a majority candidate o(n)
            ```
            int findCandidate(int a[], int size)  
            { 
                int maj_index = 0, count = 1; 
                int i; 
                for (i = 1; i < size; i++)  
                { 
                    if (a[maj_index] == a[i]) 
                        count++; 
                    else
                        count--; 
                        
                    if (count == 0) 
                    { 
                        maj_index = i; 
                        count = 1; 
                    } 
                } 
                return a[maj_index]; 
            } 
            ```
        - Find if the element is majority element. o(n))