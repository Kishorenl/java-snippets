### Check if two lists are equal?

- if the order is already maintained, 
    list1.equals(list2);
- if order is not maintained, create hashset and compare (if distinct elements in both)
    public static <T> boolean listEqualsIgnoreOrder(List<T> list1, List<T> list2) 
    {
        return new HashSet<>(list1).equals(new HashSet<>(list2));
    }
- if order not maintained and not distinct elements
    create hashmap with counts and insert/delete elements as needed.


