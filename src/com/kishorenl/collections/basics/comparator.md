Comparable vs Comparator
------------------------

NOTE: Both are interfaces.

1.  Comparable interface can be used to provide single way of sorting whereas Comparator interface is used to provide different ways of sorting.
2.  For using Comparable, Class needs to implement it whereas for using Comparator we don't need to make any change in the class.
3.  Comparable interface is in `java.lang` package whereas Comparator interface is present in `java.util` package.
4.  We don't need to make any code changes at client side for using Comparable, `Arrays.sort() (for array  of objects/primitives)` or `Collection.sort()`(for list(collection) of objects) methods automatically uses the `compareTo()` method of the class. For Comparator, client needs to provide the Comparator class to use in compare() method.

### Note
Collections.sort(objs) -> will throw exception if the object didn't implement comparable interfaces.

We need to use comparable interface if we want to use Arrays, Collections.sort() methods.

```
public class Employee implements Comparable<Employee> {
    @Override
    public int compareTo(Employee emp) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        return (this.id - emp.id);
    }
}
```
--> So, this is coded at the definition file only. But if we want to have a custom sort at the client (where we want to use these objects), we need to use comparator interface.

```
    /**
     * Comparator to sort employees list or array in order of Salary
     */
    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {

        @Override
        public int compare(Employee e1, Employee e2) {
            return (int) (e1.getSalary() - e2.getSalary());
        }
    };

    Arrays.sort(employees, SalaryComparator);

```
